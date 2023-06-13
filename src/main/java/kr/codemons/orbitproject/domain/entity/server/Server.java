package kr.codemons.orbitproject.domain.entity.server;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import kr.codemons.orbitproject.domain.entity.user.User;
import kr.codemons.orbitproject.domain.utils.SecurityProvider;
import lombok.Getter;

@Getter
@Entity
public class Server {

    protected Server() {}

    public Server(String name, String title, String description, User creator) {
        this.name = name;
        this.title = title;
        this.description = description;
        this.secret = SecurityProvider.generateSecretKey();
        this.code = "ORBIT_PROJECT_IS... HA..";
        this.enable = false;
        this.creator = creator;
    }

    @Id
    private String name;

    private String title;
    private String description;

    private String code;
    private String secret;
    private boolean enable;

    @OneToOne
    @JoinColumn(name = "USER")
    private User creator;
}
