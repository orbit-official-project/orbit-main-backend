package kr.codemons.orbitproject.domain.dto.response;

import kr.codemons.orbitproject.domain.entity.user.Avatar;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResponseUserProfile {
    private String token;
    private String email;
    private String handler;
    private Avatar avatar;
}
