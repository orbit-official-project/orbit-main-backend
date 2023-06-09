package kr.codemons.orbitproject.domain.exception;

public class UserHandlerNotFoundException extends RuntimeException {
    public UserHandlerNotFoundException() {
        super();
    }

    public UserHandlerNotFoundException(String message) {
        super(message);
    }

    public UserHandlerNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserHandlerNotFoundException(Throwable cause) {
        super(cause);
    }

    protected UserHandlerNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
