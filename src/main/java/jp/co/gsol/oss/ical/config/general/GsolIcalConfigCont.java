package jp.co.gsol.oss.ical.config.general;


import java.math.BigInteger;
import java.util.Properties;

import org.seasar.framework.util.ResourceUtil;
import org.seasar.util.lang.StringUtil;

import jp.co.intra_mart.foundation.config.ConfigurationException;
import jp.co.intra_mart.foundation.config.ConfigurationLoader;

public class GsolIcalConfigCont {
    final GsolIcalConfig conf;
    final Properties props = ResourceUtil.getProperties(
            "jp/co/gsol/oss/ical/config/general/ical-config.properties");
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
        return or(conf.isAutoMkdir(),
                props.getProperty("default_auto_mkdir"));
    }
    public final boolean isAutoRecoveryFile() {
        return or(conf.isAutoRecoveryFile(),
                props.getProperty("default_auto_recovery_file"));
    }
    public final int getIcsStartMonth() {
        return or(conf.getIcsStartMonth(),
                props.getProperty("default_ics_start_month"));
    }
    public final int getIcsEndMonth() {
        return or(conf.getIcsEndMonth(),
                props.getProperty("default_ics_end_month"));
    }
    public final int getIcsFilenameLen() {
        return or(conf.getIcsFilenameLen(),
                props.getProperty("default_ics_filename_len"));
    }
    public final String getIcsFileExtension() {
        return or(conf.getIcsFileExtension(),
                props.getProperty("default_ics_file_extension"));
    }
    public final String getTempFilePrefix() {
        return conf.getTempFilePrefix();
    }
    public final String getTempFileSuffix() {
        return conf.getTempFileSuffix();
    }
    public final String getCharset() {
        return or(conf.getCharset(),
                props.getProperty("default_charset"));
    }
    public final String getIacSchEventDatePattern() {
        return or(conf.getIacSchEventDatePattern(),
                props.getProperty("default_iac_sch_event_date_pattern"));
    }
    private final boolean or(final Boolean val, final String def) {
        return or(val, Boolean.valueOf(def));
    }
    private final boolean or(final Boolean val, final boolean def) {
        return val != null ? val: def;
    }
    private final int or(final BigInteger val, final String def) {
        return or(val, Integer.valueOf(def));
    }
    private final int or(final BigInteger val, final int def) {
        return val != null ? val.intValue(): def;
    }
    private final String or(final String val, final String def) {
        return !StringUtil.isEmpty(val) ? val: def;
    }
}
