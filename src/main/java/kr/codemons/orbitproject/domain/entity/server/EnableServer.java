package kr.codemons.orbitproject.domain.entity.server;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "E_SERVER")
public class EnableServer {

    protected EnableServer () {}

    public EnableServer(Server server, String address, int port, boolean https) {
        this.server = server;
        this.address = address;
        this.port = port;
        this.https = https;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "SERVER_NAME")
    private Server server;

    private String address;
    private int port;
    private boolean https;
}
