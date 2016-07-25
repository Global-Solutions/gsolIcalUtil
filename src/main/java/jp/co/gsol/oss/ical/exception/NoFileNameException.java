package jp.co.gsol.ical.exception;

/**
 * ファイル名が指定されなかったとき.
 * @author Global Solutions Co., Ltd.
 */
public class NoFileNameException extends Exception {

    /** UID. */
    private static final long serialVersionUID = -9084990762019248141L;

    /**
     * 新規例外を構築.
     */
    public NoFileNameException() {
        super();
    }

    /**
     * 指定された詳細メッセージを使用して、新規例外を構築.
     * @param message 詳細メッセージ
     */
    public NoFileNameException(final String message) {
        super(message);
    }

    /**
     * 指定された原因を持つ新規例外を構築.
     * @param cause 原因
     */
    public NoFileNameException(final Throwable cause) {
        super(cause);
    }

    /**
     *  指定された詳細メッセージと原因を持つ新規例外を構築.
     *  @param message 詳細メッセージ
     *  @param cause 原因
     */
    public NoFileNameException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
