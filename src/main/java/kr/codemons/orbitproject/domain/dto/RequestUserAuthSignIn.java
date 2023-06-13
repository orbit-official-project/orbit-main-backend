package kr.codemons.orbitproject.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RequestUserAuthSignIn {
	
	private String email;
	private String password;

}
