package kr.codemons.orbitproject.domain.dto;

import kr.codemons.orbitproject.domain.entity.server.Server;
import lombok.Getter;

import java.util.UUID;

@Getter
public class ServerCreateDto {

    private String name;
    private String description;
    private boolean ssl;

    public Server toServerEntity () {
        String code = UUID.randomUUID().toString();
        return new Server(name, code, description);
    }
}
