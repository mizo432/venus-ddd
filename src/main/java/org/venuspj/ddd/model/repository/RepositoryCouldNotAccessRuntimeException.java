package org.venuspj.ddd.model.repository;

/**
 * リポジトリにアクセスできない場合に発生する例外
 */
public class RepositoryCouldNotAccessRuntimeException extends RuntimeException {

    public RepositoryCouldNotAccessRuntimeException() {
        
    }

    public RepositoryCouldNotAccessRuntimeException(String message) {
        super(message);
    }

    public RepositoryCouldNotAccessRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public RepositoryCouldNotAccessRuntimeException(Throwable cause) {
        super(cause);
    }

    public RepositoryCouldNotAccessRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
