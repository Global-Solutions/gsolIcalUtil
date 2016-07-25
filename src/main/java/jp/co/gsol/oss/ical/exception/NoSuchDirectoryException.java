package jp.co.gsol.oss.ical.exception;

/**
 * ディレクトリが見つからなかったとき.
 * @author Global Solutions Co., Ltd.
 */
public class NoSuchDirectoryException extends Exception {
    /** UID. */
    private static final long serialVersionUID = -5843816631115566142L;

    /**
     * 新規例外を構築.
     */
    public NoSuchDirectoryException() {
        super();
    }

    /**
     * 指定された詳細メッセージを使用して、新規例外を構築.
     * @param message 詳細メッセージ
     */
    public NoSuchDirectoryException(final String message) {
        super(message);
    }

    /**
     * 指定された原因を持つ新規例外を構築.
     * @param cause 原因
     */
    public NoSuchDirectoryException(final Throwable cause) {
        super(cause);
    }

    /**
     *  指定された詳細メッセージと原因を持つ新規例外を構築.
     *  @param message 詳細メッセージ
     *  @param cause 原因
     */
    public NoSuchDirectoryException(
            final String message, final Throwable cause) {
        super(message, cause);
    }
}
