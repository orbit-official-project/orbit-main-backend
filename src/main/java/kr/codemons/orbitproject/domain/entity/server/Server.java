package kr.codemons.orbitproject.domain.entity.server;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

@Getter
@Entity
public class Server {

    protected Server() {}

    public Server(String name, String code, String address, int port, String description) {
        this.name = name;
        this.code = code;
        this.address = address;
        this.port = port;
        this.description = description;
    }

    public Server(String name, String code, String description) {
        this.name = name;
        this.code = code;
        this.description = description;
    }

    @Id
    private String name;
    private String code;
    private String address;
    private int port;
    private String description;
    private String secret;
}
