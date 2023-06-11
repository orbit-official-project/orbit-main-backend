package kr.codemons.orbitproject.domain.entity.server;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import kr.codemons.orbitproject.domain.utils.SecurityProvider;
import lombok.Getter;

@Getter
@Entity
public class Server {

    protected Server() {}

    public Server(String name, String title, String description) {
        this.name = name;
        this.title = title;
        this.description = description;
        this.secret = SecurityProvider.generateSecretKey();
        this.code = "ORBIT_PROJECT_IS... HA..";
    }

    @Id
    private String name;

    private String title;
    private String description;

    private String code;
    private String secret;
}
