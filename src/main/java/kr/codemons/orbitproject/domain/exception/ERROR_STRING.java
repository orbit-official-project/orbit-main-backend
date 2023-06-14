package kr.codemons.orbitproject.domain.exception;

public enum ERROR_STRING {
    USER_NOT_FOUND,
    USER_DUPLICATE,
    USER_EMAIL_DUPLICATE,
    USER_HANDLER_DUPLICATE,

    SERVER_NOT_FOUND,
    SERVER_NAME_DUPLICATE,
    SERVER_STATUS_DISABLED,
    SERVER_ALREADY_ENABLE,

    NEED_ARGUMENT,
    INCORRECT_AUTHORIZATION,
    INVALID_SECRET_KEY,

    MALFORMED_EMAIL_AUTHENTICATION,
    UNAUTHENTICATED_EMAIL
}