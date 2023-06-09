package kr.codemons.orbitproject.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserAuthSignInDto {
	
	private String email;
	private String name;
	private String password;
}
