package kr.codemons.orbitproject.domain.exception.user;

public class DuplicateHostNameException extends RuntimeException {
	
	public DuplicateHostNameException() {
		super();
	}
	
	public DuplicateHostNameException(String message) {
		super(message);
	}
	
	public DuplicateHostNameException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public DuplicateHostNameException(Throwable cause) {
		super(cause);
	}
	
	protected DuplicateHostNameException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
