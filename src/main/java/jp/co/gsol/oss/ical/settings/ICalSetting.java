package jp.co.gsol.oss.ical.settings;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Map;

import jp.co.gsol.oss.ical.exception.ICalException;
import jp.co.intra_mart.common.platform.log.Logger;

import net.arnx.jsonic.JSON;
import net.arnx.jsonic.JSONException;

import org.seasar.util.io.ResourceUtil;


/**
 * 設定ファイル読み取りクラス.
 * @author Global Solutions Co., Ltd.
 */

public final class ICalSetting {

    /** 設定ファイルを読み込めたか.*/
    private static boolean __valid = false;
    /** 設定ファイル名.*/
    private static final String __filename = "iCalSettings.json";
    /** 未設定文字列.*/
    private static final String __UNDEFINED = "undefined";
    /** not used.*/
    private ICalSetting() { };
    /**
     * 設定ファイルを読み込めたか.
     * @return 設定ファイルを読み込めた場合、true
     */
    public static boolean valid() {
        return __valid;
    }

    /** document directory へのパス文字列.*/
    private static String documentDirectory = __UNDEFINED;
    /** ics ファイルダウンロードURI文字列.*/
    private static String locationPath = __UNDEFINED;
    /** カレンダー product id 文字列.*/
    private static String prodId = __UNDEFINED;
    /** カレンダー名テンプレート文字列.*/
    private static String calendarNameTemplate = __UNDEFINED;
    /** 何ヶ月後からスケジュールを抽出するか.*/
    private static BigDecimal icsStartMonth = new BigDecimal(-1);
    /** 何ヶ月後までスケジュールを抽出するか.*/
    private static BigDecimal icsEndMonth = new BigDecimal(13);
    /** ics ファイル名の長さ.*/
    private static BigDecimal icsFilenameLen = new BigDecimal(50);
    /** ics ファイルの拡張子文字列.*/
    private static String icsFileExtension = ".ics";
    /** temporary file prefix.*/
    private static String tempFilePrefix = null;
    /** temporary file の拡張子文字列.*/
    private static String tempFileSuffix = null;
    /** icsファイル書き込みに使用する文字コード.*/
    private static String charset = "utf-8";
    /** iac_sch_event テーブルの日付パターン文字列.*/
    private static String iacSchEventDatePattern = __UNDEFINED;
    /** auto make dir.*/
    private static Boolean autoMkdir = false;
    /** auto recovery file.*/
    private static Boolean autoRecovery = false;

    static {
        try {
            readFile();
        } catch (IOException | ICalException e) {
            e.printStackTrace();
        }
    }

    /**
     * 設定ファイルを読み込む.
     * @return 設定ファイルを読み込めた場合、true
     * @throws IOException {@link net.arnx.jsonic.JSON}
     * または、 {@link java.io.BufferedInputStream} または、 {@link java.io.InputStream}
     * @throws ICalException 設定ファイルが不正な場合
     */
    private static synchronized boolean
    readFile() throws IOException, ICalException {
        final InputStream in = ResourceUtil.getResourceAsStream(__filename);
        final BufferedInputStream bin = new BufferedInputStream(in);
        final Logger logger = Logger.getLogger();
        try {
            __valid = false;
            logger.info("Read: " + __filename);
            final Map<String, Object> props = JSON.decode(bin);
            for (Field field: ICalSetting.class.getDeclaredFields())
                if (!field.getName().startsWith("__")) {
                    Object value = props.get(field.getName());
                    value = value != null ? value : field.get(null);
                    field.set(null, field.getType().cast(value));
                    logger.info("field: {} value: {}", field.getName(), value);
                }
            __valid = true;
        } catch (JSONException | IllegalArgumentException | IllegalAccessException e) {
            throw new ICalException(e);
        } finally {
            bin.close();
            in.close();
        }
        return __valid;
    }

    /**
     * document directory へのパス文字列.
     * @return document directory へのパス文字列
     */
    public static String documentDirectory() {
        return documentDirectory;
    }
    /**
     * ics ファイルダウンロードURI文字列.
     * @return ics ファイルダウンロードURI文字列
     */
    public static String locationPath() {
        return locationPath;
    }
    /**
     * カレンダー product id 文字列.
     * @return カレンダー product id 文字列
     */
    public static String prodId() {
        return prodId;
    }
    /**
     * カレンダー名テンプレート文字列.
     * @return カレンダー名テンプレート文字列
     */
    public static String calendarNameTemplate() {
        return calendarNameTemplate;
    }
    /**
     * 何ヶ月後からスケジュールを抽出するか.
     * @return start month
     */
    public static int icsStartMonth() {
        return icsStartMonth.intValue();
    }
    /**
     * 何ヶ月後までスケジュールを抽出するか.
     * @return end month
     */
    public static int icsEndMonth() {
        return icsEndMonth.intValue();
    }
    /**
     * ics ファイル名の長さ.
     * @return ics ファイル名の長さ
     */
    public static int icsFilenameLen() {
        return icsFilenameLen.intValue();
    }
    /**
     * ics ファイルの拡張子文字列.
     * @return ics ファイルの拡張子文字列
     */
    public static String icsFileExtension() {
        return icsFileExtension;
    }
    /**
     * temporary file prefix.
     * @return temporary file prefix
     */
    public static String tempFilePrefix() {
        return tempFilePrefix;
    }
    /**
     * temporary file の拡張子文字列.
     * @return temporary file の拡張子文字列
     */
    public static String tempFileSuffix() {
        return tempFileSuffix;
    }
    /**
     * icsファイル書き込みに使用する文字コード.
     * @return charset string
     */
    public static String charset() {
        return charset;
    }
    /**
     * iac_sch_event テーブルの日付パターン文字列.
     * @return date pattern string
     */
    public static String iacSchEventDatePattern() {
        return iacSchEventDatePattern;
    }
    /**
     * auto make dir.
     * @return boolean autoMkdir
     */
    public static boolean autoMkdir() {
        return autoMkdir;
    }
    /**
     * auto recovery file.
     * @return boolean autoRecovery
     */
    public static boolean autoRecovery() {
        return autoRecovery;
    }
    /**
     * 設定ファイルをリロードする.
     * @return 設定ファイルを読み込めた場合、true
     * @throws ICalException 設定ファイルが不正な場合
     * @throws IOException ファイル読み込みエラー
     */
    public static boolean reload() throws IOException, ICalException {
        return readFile();
    }
}
