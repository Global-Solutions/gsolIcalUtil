package jp.co.gsol.oss.ical.exception;

/**
 * ディレクトリトラバーサルを検知したとき.
 * @author Global Solutions Co., Ltd.
 */
public class DirectoryTraversalException extends Exception {
    /** UID. */
    private static final long serialVersionUID = -6954433783303536638L;

    /**
     * 新規例外を構築.
     */
    public DirectoryTraversalException() {
        super();
    }

    /**
     * 指定された詳細メッセージを使用して、新規例外を構築.
     * @param message 詳細メッセージ
     */
    public DirectoryTraversalException(final String message) {
        super(message);
    }

    /**
     * 指定された原因を持つ新規例外を構築.
     * @param cause 原因
     */
    public DirectoryTraversalException(final Throwable cause) {
        super(cause);
    }

    /**
     *  指定された詳細メッセージと原因を持つ新規例外を構築.
     *  @param message 詳細メッセージ
     *  @param cause 原因
     */
    public DirectoryTraversalException(
            final String message, final Throwable cause) {
        super(message, cause);
    }
}
