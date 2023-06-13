package kr.codemons.orbitproject.domain.exception.user;

public class InitMessageHelperException extends RuntimeException {
	
	public InitMessageHelperException() {
		super();
	}
	
	public InitMessageHelperException(String message) {
		super(message);
	}
	
	public InitMessageHelperException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public InitMessageHelperException(Throwable cause) {
		super(cause);
	}
	
	protected InitMessageHelperException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
