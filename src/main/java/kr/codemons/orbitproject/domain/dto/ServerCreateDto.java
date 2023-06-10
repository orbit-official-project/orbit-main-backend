package kr.codemons.orbitproject.domain.dto;

import kr.codemons.orbitproject.domain.entity.server.Server;
import kr.codemons.orbitproject.domain.utils.SecurityProvider;
import lombok.Getter;

import java.util.UUID;

@Getter
public class ServerCreateDto {

    private String name;
    private String description;
    private boolean ssl;

    public Server toServerEntity () {
        String code = UUID.randomUUID().toString();
        String secret = SecurityProvider.generateSecretKey();
        return new Server(name, code, description, secret);
    }
}