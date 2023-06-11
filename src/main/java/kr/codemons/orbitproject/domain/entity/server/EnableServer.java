package kr.codemons.orbitproject.domain.entity.server;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;

@Getter
@Entity
public class EnableServer {

    protected EnableServer () {}

    public EnableServer(Server server, String address, int port, boolean https) {
        this.server = server;
        this.address = address;
        this.port = port;
        this.https = https;
    }

    @Id
    @OneToOne
    @JoinColumn(name = "SERVER_NAME")
    private Server server;

    private String address;
    private int port;
    private boolean https;
}
