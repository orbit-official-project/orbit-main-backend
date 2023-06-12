package kr.codemons.orbitproject.domain.dto.server.usermode;

import kr.codemons.orbitproject.domain.dto.server.UserProfileDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResponseReadyServerDto {
    private String name;
    private String title;
    private String description;
    private UserProfileDto user_profile;
}
