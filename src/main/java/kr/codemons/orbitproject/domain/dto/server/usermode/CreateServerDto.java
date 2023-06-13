package kr.codemons.orbitproject.domain.dto.server.usermode;

import jakarta.validation.constraints.NotBlank;
import kr.codemons.orbitproject.domain.entity.server.Server;
import lombok.Getter;

@Getter
public class CreateServerDto {

    public CreateServerDto (String name, String title, String description) {
        this.name = name;
        this.title = title;
        this.description = description;
    }

    @NotBlank private String name;
    @NotBlank private String title;
    @NotBlank private String description;

    public Server toServerEntity () {
        return new Server(name, title, description, null);
    }
}
