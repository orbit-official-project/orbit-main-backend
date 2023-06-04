package kr.codemons.orbitproject.domain.dto;

import kr.codemons.orbitproject.domain.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserAuthJoinDto {
    private String email;
    private String name;
    private String password;

    public User toUserEntity () {
        return new User(this.name, this.email, this.password);
    }
}
