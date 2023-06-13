package kr.codemons.orbitproject.domain.exception.user;

public class DuplicateHandlerException extends RuntimeException {
	
	public DuplicateHandlerException() {
		super();
	}
	
	public DuplicateHandlerException(String message) {
		super(message);
	}
	
	public DuplicateHandlerException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public DuplicateHandlerException(Throwable cause) {
		super(cause);
	}
	
	protected DuplicateHandlerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
