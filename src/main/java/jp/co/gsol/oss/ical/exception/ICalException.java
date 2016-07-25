package jp.co.gsol.ical.exception;

/**
 * icsファイルを作成中に発生した例外.
 * @author Global Solutions Co., Ltd.
 *
 */
public class ICalException extends Exception {

    /**
     * シリアル番号.
     */
    private static final long serialVersionUID = -8387780717542770966L;

    /**
     * 新規例外を構築.
     */
    public ICalException() {
        super();
    }

    /**
     * 指定された詳細メッセージを使用して、新規例外を構築.
     * @param message 詳細メッセージ
     */
    public ICalException(final String message) {
        super(message);
    }

    /**
     * 指定された原因を持つ新規例外を構築.
     * @param cause 原因
     */
    public ICalException(final Throwable cause) {
        super(cause);
    }

    /**
     *  指定された詳細メッセージと原因を持つ新規例外を構築.
     *  @param message 詳細メッセージ
     *  @param cause 原因
     */
    public ICalException(final String message, final Throwable cause) {
        super(message, cause);
    }

}
