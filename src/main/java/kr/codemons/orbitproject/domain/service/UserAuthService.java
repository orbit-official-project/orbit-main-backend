package kr.codemons.orbitproject.domain.service;

import kr.codemons.orbitproject.domain.dto.RequestEmailAuthentication;
import kr.codemons.orbitproject.domain.dto.RequestUserAuthSignIn;
import kr.codemons.orbitproject.domain.dto.RequestUserAuthSignUp;
import kr.codemons.orbitproject.domain.dto.response.ResponseUserProfile;

public interface UserAuthService {

	ResponseUserProfile login (RequestUserAuthSignIn dto);

	void join(RequestUserAuthSignUp dto);

	boolean validateUserToken(String token);
	
	boolean isExistEmail(String email);

	void emailAuthenticate (RequestEmailAuthentication authentication);
}
