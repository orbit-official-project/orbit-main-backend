package kr.codemons.orbitproject.domain.entity.user;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "MEMBER")
public class User {
	
	protected User() {
	}
	
	public User(String handler, String name, String email, String password, Avatar avatar) {
		this.handler = handler;
		this.name = name;
		this.email = email;
		this.password = password;
		this.avatar = avatar;
	}
	
	@Id
	private String handler;
	private String name;
	
	private String email;
	private String password;
	
	@OneToOne
	@JoinColumn(name = "AVATAR_ID")
	private Avatar avatar;
}
