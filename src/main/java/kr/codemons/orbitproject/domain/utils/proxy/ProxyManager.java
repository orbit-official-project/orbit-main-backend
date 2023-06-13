package kr.codemons.orbitproject.domain.utils.proxy;

import kr.codemons.orbitproject.domain.exception.user.DuplicateHostNameException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Slf4j
@Component
public class ProxyManager {

    @Value("${proxyServer.sites-enabled}") private String enabledPath;

    public synchronized void create (Host host) {
        if (isExists(host.getName())) {
            throw new DuplicateHostNameException();
        }

        String protocol = host.isSsl() ? "https://" : "http://";
        String address = protocol + host.getIp() + "orbitx.kr";

        try {
            String cmd = getCreateProxyRouteShellPath() + " "
                    + host.getName() + " "
                    + address + " "
                    + enabledPath;

            Process shellProcess = Runtime.getRuntime().exec("powershell.exe " + cmd);
            shellProcess.waitFor();
        }
        catch (Exception ignored) { }
    }

    public void delete (String hostName) {

    }

    public Optional<Host> get (String hostName) {
        return Optional.empty();
    }

    private boolean isExists (String hostName) {
        return new File(hostName).exists();
    }

    private String getCreateProxyRouteShellPath () {
        Resource resource = new ClassPathResource("scripts/createProxyRoute.ps1");
        try { return resource.getFile().getAbsolutePath(); }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
