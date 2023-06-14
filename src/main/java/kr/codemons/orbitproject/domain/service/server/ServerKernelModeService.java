package kr.codemons.orbitproject.domain.service.server;

import kr.codemons.orbitproject.domain.dto.server.kernelmode.EnableServerDto;
import kr.codemons.orbitproject.domain.entity.server.EnableServer;
import kr.codemons.orbitproject.domain.entity.server.Server;
import kr.codemons.orbitproject.domain.exception.server.InvalidSecretKeyException;
import kr.codemons.orbitproject.domain.exception.server.ServerAlreadyEnabledException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServerKernelModeService {

    private final ServerService serverService;

    public void enableServer (EnableServerDto dto) {
        Server findServer = serverService.getServer(dto.getName());

        validateServerSecretKey(dto.getSecret(), findServer);

        if (findServer.isEnable()) {
            throw new ServerAlreadyEnabledException(); }

        serverService.enable(new EnableServer(findServer, dto.getIp(), dto.getPort(), dto.isSsl()));
    }

    public void disableServer (String host, String secret) {
        Server findServer = serverService.getServer(host);
        validateServerSecretKey(secret, findServer);

//        활성화된 서버가 아니라면
        if (!findServer.isEnable()) {
//            TODO 예외
        }
    }

    public void deleteServer (String host, String secret) {

    }

    private void validateServerSecretKey (String key, Server server) {
        if (!server.getSecret().equals(key)) {
            throw new InvalidSecretKeyException(); }
    }
}
