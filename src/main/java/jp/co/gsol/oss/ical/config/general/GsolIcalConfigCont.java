package jp.co.gsol.oss.ical.config.general;


import java.math.BigInteger;

import org.seasar.util.lang.StringUtil;

import jp.co.intra_mart.foundation.config.ConfigurationException;
import jp.co.intra_mart.foundation.config.ConfigurationLoader;

public class GsolIcalConfigCont {
    final GsolIcalConfig conf;
    public GsolIcalConfigCont() throws ConfigurationException {
        conf = ConfigurationLoader.load(GsolIcalConfig.class);
    }

    public final String getDocumentDirectry() {
        return conf.getDocumentDirectry();
    }
    public final String getLocationPath() {
        return conf.getLocationPath();
    }
    public final String getProdId() {
        return conf.getProdId();
    }
    public final String getCalendarNameTemplate() {
        return conf.getCalendarNameTemplate();
    }
    public final boolean isAutoMkdir() {
        return or(conf.isAutoMkdir(), true);
    }
    public final boolean isAutoRecoveryFile() {
        return or(conf.isAutoRecoveryFile(), false);
    }
    public final int getIcsStartMonth() {
        return or(conf.getIcsStartMonth(), -1);
    }
    public final int getIcsEndMonth() {
        return or(conf.getIcsEndMonth(), 13);
    }
    public final int getIcsFilenameLen() {
        return or(conf.getIcsFilenameLen(), 50);
    }
    public final String getIcsFileExtension() {
        return or(conf.getIcsFileExtension(), ".ics");
    }
    public final String getTempFilePrefix() {
        return conf.getTempFilePrefix();
    }
    public final String getTempFileSuffix() {
        return conf.getTempFileSuffix();
    }
    public final String getCharset() {
        return or(conf.getCharset(), "utf-8");
    }
    public final String getIacSchEventDatePattern() {
        return or(conf.getIacSchEventDatePattern(), "yyyyMMdd");
    }
    private final boolean or(final Boolean val, final boolean def) {
        return val != null ? val: def;
    }
    private final int or(final BigInteger val, final int def) {
        return val != null ? val.intValue(): def;
    }
    private final String or(final String val, final String def) {
        return !StringUtil.isEmpty(val) ? val: def;
    }
}
