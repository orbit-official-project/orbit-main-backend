package kr.codemons.orbitproject.domain.utils.proxy;

import lombok.Getter;

@Getter
public class Host {

    public Host(String ip, Integer port, boolean ssl, String name, boolean enable) {
        this.ip = ip;
        this.port = port;
        this.ssl = ssl;
        this.name = name;
        this.enable = enable;
    }

    private String ip;
    private Integer port;
    private boolean ssl;
    private boolean enable;
    private String name;
}
