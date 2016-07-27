
package jp.co.gsol.oss.ical.config.general;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex typeのJavaクラス。
 * 
 * <p>次のスキーマ・フラグメントは、このクラス内に含まれる予期されるコンテンツを指定します。
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="document-directry" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="location-path" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="prod-id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="calendar-name-template" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="auto-mkdir" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="auto-recovery-file" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ics-start-month" type="{http://global-solutions.co.jp/ical/config/general}negative-integer" minOccurs="0"/>
 *         &lt;element name="ics-end-month" type="{http://global-solutions.co.jp/ical/config/general}positive-integer" minOccurs="0"/>
 *         &lt;element name="ics-filename-len" type="{http://global-solutions.co.jp/ical/config/general}positive-integer" minOccurs="0"/>
 *         &lt;element name="ics-file-extension" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="temp-file-prefix" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="temp-file-suffix" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="charset" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="iac-sch-event-date-pattern" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {

})
@XmlRootElement(name = "gsol-ical-config", namespace = "http://global-solutions.co.jp/ical/config/general")
public class GsolIcalConfig {

    @XmlElement(name = "document-directry", namespace = "http://global-solutions.co.jp/ical/config/general", required = true)
    protected String documentDirectry;
    @XmlElement(name = "location-path", namespace = "http://global-solutions.co.jp/ical/config/general", required = true)
    protected String locationPath;
    @XmlElement(name = "prod-id", namespace = "http://global-solutions.co.jp/ical/config/general", required = true)
    protected String prodId;
    @XmlElement(name = "calendar-name-template", namespace = "http://global-solutions.co.jp/ical/config/general", required = true)
    protected String calendarNameTemplate;
    @XmlElement(name = "auto-mkdir", namespace = "http://global-solutions.co.jp/ical/config/general")
    protected Boolean autoMkdir;
    @XmlElement(name = "auto-recovery-file", namespace = "http://global-solutions.co.jp/ical/config/general")
    protected Boolean autoRecoveryFile;
    @XmlElement(name = "ics-start-month", namespace = "http://global-solutions.co.jp/ical/config/general")
    protected BigInteger icsStartMonth;
    @XmlElement(name = "ics-end-month", namespace = "http://global-solutions.co.jp/ical/config/general")
    protected BigInteger icsEndMonth;
    @XmlElement(name = "ics-filename-len", namespace = "http://global-solutions.co.jp/ical/config/general")
    protected BigInteger icsFilenameLen;
    @XmlElement(name = "ics-file-extension", namespace = "http://global-solutions.co.jp/ical/config/general")
    protected String icsFileExtension;
    @XmlElement(name = "temp-file-prefix", namespace = "http://global-solutions.co.jp/ical/config/general")
    protected String tempFilePrefix;
    @XmlElement(name = "temp-file-suffix", namespace = "http://global-solutions.co.jp/ical/config/general")
    protected String tempFileSuffix;
    @XmlElement(namespace = "http://global-solutions.co.jp/ical/config/general")
    protected String charset;
    @XmlElement(name = "iac-sch-event-date-pattern", namespace = "http://global-solutions.co.jp/ical/config/general")
    protected String iacSchEventDatePattern;

    /**
     * documentDirectryプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentDirectry() {
        return documentDirectry;
    }

    /**
     * documentDirectryプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentDirectry(String value) {
        this.documentDirectry = value;
    }

    /**
     * locationPathプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocationPath() {
        return locationPath;
    }

    /**
     * locationPathプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocationPath(String value) {
        this.locationPath = value;
    }

    /**
     * prodIdプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProdId() {
        return prodId;
    }

    /**
     * prodIdプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProdId(String value) {
        this.prodId = value;
    }

    /**
     * calendarNameTemplateプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCalendarNameTemplate() {
        return calendarNameTemplate;
    }

    /**
     * calendarNameTemplateプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCalendarNameTemplate(String value) {
        this.calendarNameTemplate = value;
    }

    /**
     * autoMkdirプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAutoMkdir() {
        return autoMkdir;
    }

    /**
     * autoMkdirプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAutoMkdir(Boolean value) {
        this.autoMkdir = value;
    }

    /**
     * autoRecoveryFileプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAutoRecoveryFile() {
        return autoRecoveryFile;
    }

    /**
     * autoRecoveryFileプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAutoRecoveryFile(Boolean value) {
        this.autoRecoveryFile = value;
    }

    /**
     * icsStartMonthプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getIcsStartMonth() {
        return icsStartMonth;
    }

    /**
     * icsStartMonthプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setIcsStartMonth(BigInteger value) {
        this.icsStartMonth = value;
    }

    /**
     * icsEndMonthプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getIcsEndMonth() {
        return icsEndMonth;
    }

    /**
     * icsEndMonthプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setIcsEndMonth(BigInteger value) {
        this.icsEndMonth = value;
    }

    /**
     * icsFilenameLenプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getIcsFilenameLen() {
        return icsFilenameLen;
    }

    /**
     * icsFilenameLenプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setIcsFilenameLen(BigInteger value) {
        this.icsFilenameLen = value;
    }

    /**
     * icsFileExtensionプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIcsFileExtension() {
        return icsFileExtension;
    }

    /**
     * icsFileExtensionプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIcsFileExtension(String value) {
        this.icsFileExtension = value;
    }

    /**
     * tempFilePrefixプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTempFilePrefix() {
        return tempFilePrefix;
    }

    /**
     * tempFilePrefixプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTempFilePrefix(String value) {
        this.tempFilePrefix = value;
    }

    /**
     * tempFileSuffixプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTempFileSuffix() {
        return tempFileSuffix;
    }

    /**
     * tempFileSuffixプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTempFileSuffix(String value) {
        this.tempFileSuffix = value;
    }

    /**
     * charsetプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCharset() {
        return charset;
    }

    /**
     * charsetプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCharset(String value) {
        this.charset = value;
    }

    /**
     * iacSchEventDatePatternプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIacSchEventDatePattern() {
        return iacSchEventDatePattern;
    }

    /**
     * iacSchEventDatePatternプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIacSchEventDatePattern(String value) {
        this.iacSchEventDatePattern = value;
    }

}
