package kr.codemons.orbitproject.domain.service;

import kr.codemons.orbitproject.domain.dto.UserAuthJoinDto;

public interface UserAuthService {

    void join (UserAuthJoinDto dto);
    boolean validateUserToken (String token);

}
