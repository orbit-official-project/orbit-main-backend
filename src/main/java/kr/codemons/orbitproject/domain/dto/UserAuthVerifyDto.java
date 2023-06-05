package kr.codemons.orbitproject.domain.dto;

import lombok.Getter;

@Getter
public class UserAuthVerifyDto {

    public UserAuthVerifyDto(String email, String code) {
        this.email = email;
        this.code = code;
    }

    private String email;
    private String code;
}
