package kr.codemons.orbitproject.domain.service;

import kr.codemons.orbitproject.domain.dto.UserAuthJoinDto;

public interface UserAuthService {

    void join (UserAuthJoinDto dto);
    void delete (String token);
    boolean validateUserToken (String token);

}
