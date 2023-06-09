package kr.codemons.orbitproject.domain.utils.proxy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
class ProxyManagerTest {

    @Value("${proxyServer.scripts.path}") private String path;

    @Test
    void createRoute () {
        ProxyManager proxyManager = new ProxyManager();
        Host host = new Host("127.0.0.1", 4522, false, "joyoujngjun", true);
        proxyManager.create(host);
    }

    @Test
    void deleteRoute () {
        ProxyManager proxyManager = new ProxyManager();
        proxyManager.delete("joyoungjun");
    }
}