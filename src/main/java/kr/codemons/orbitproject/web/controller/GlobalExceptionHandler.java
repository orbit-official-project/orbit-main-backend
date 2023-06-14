package kr.codemons.orbitproject.web.controller;

import io.jsonwebtoken.JwtException;
import kr.codemons.orbitproject.domain.exception.MissingParameterException;
import kr.codemons.orbitproject.domain.exception.server.InvalidSecretKeyException;
import kr.codemons.orbitproject.domain.exception.user.DuplicateEmailException;
import kr.codemons.orbitproject.domain.exception.user.DuplicateHandlerException;
import kr.codemons.orbitproject.domain.exception.ERROR_STRING;
import kr.codemons.orbitproject.domain.exception.user.MalformedEmailAuthentication;
import kr.codemons.orbitproject.domain.exception.user.UnAuthenticatedEmailException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@ResponseStatus(HttpStatus.BAD_REQUEST)
@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(JwtException.class)
	public String jwtExceptionHandler() {
		return "JWT_EXCEPTION";
	}
	
	@ExceptionHandler(DuplicateEmailException.class)
	public String duplicateEmailException() {
		return ERROR_STRING.USER_EMAIL_DUPLICATE.name();
	}

	@ExceptionHandler(DuplicateHandlerException.class)
	public String duplicateHandlerException() {
		return ERROR_STRING.USER_HANDLER_DUPLICATE.name();
	}

	@ExceptionHandler({IllegalStateException.class, MissingParameterException.class})
	public String missingParameterException () {
		return ERROR_STRING.NEED_ARGUMENT.name();
	}

	@ExceptionHandler(InvalidSecretKeyException.class)
	public String badSecretKeyException () { return ERROR_STRING.INVALID_SECRET_KEY.name(); }

	@ExceptionHandler(MalformedEmailAuthentication.class)
	public String malformedEmailAuthenticationException () { return ERROR_STRING.MALFORMED_EMAIL_AUTHENTICATION.name(); }

	@ExceptionHandler(UnAuthenticatedEmailException.class)
	public String unAuthenticatedEmailException () { return ERROR_STRING.UNAUTHENTICATED_EMAIL.name(); }
}
