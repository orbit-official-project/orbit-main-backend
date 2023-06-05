package kr.codemons.orbitproject.domain.exception;

public class InvalidVerifyCodeException extends RuntimeException {
    public InvalidVerifyCodeException() {
        super();
    }

    public InvalidVerifyCodeException(String message) {
        super(message);
    }

    public InvalidVerifyCodeException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidVerifyCodeException(Throwable cause) {
        super(cause);
    }

    protected InvalidVerifyCodeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
