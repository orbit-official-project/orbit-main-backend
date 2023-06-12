package kr.codemons.orbitproject.domain.dto.server;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserProfileDto {

    private String name;
    private String handler;
    private String email;

}
