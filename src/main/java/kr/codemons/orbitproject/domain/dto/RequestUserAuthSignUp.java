package kr.codemons.orbitproject.domain.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import kr.codemons.orbitproject.domain.entity.user.User;
import lombok.Getter;

@Getter
public class RequestUserAuthSignUp {
	
	@NotBlank
	private String handler;
	
	@NotBlank
	private String name;
	
	@NotBlank
	@Email
	private String email;
	
	@NotBlank
	private String password;

	public User toUserEntity() {
		return new User(this.handler, this.name, this.email, this.password, null);
	}
}
