package kr.codemons.orbitproject.domain.service;

import kr.codemons.orbitproject.domain.dto.UserAuthSignUpDto;

public interface UserAuthService {

    void join (UserAuthSignUpDto dto);
    void delete (String token);
    boolean validateUserToken (String token);

    boolean isExistsEmail(String email);

}
