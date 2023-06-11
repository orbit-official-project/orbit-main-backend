package kr.codemons.orbitproject.domain.dto;

import kr.codemons.orbitproject.domain.entity.server.Server;
import lombok.Getter;

@Getter
public class CreateServerDto {

    public CreateServerDto(String name, String title, String description) {
        this.name = name;
        this.title = title;
        this.description = description;
    }

    private String name;
    private String title;
    private String description;

    public Server toServerEntity () {
        return new Server(name, title, description);
    }
}
