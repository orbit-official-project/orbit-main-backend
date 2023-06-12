package kr.codemons.orbitproject.domain.service.server;

import kr.codemons.orbitproject.domain.dto.server.usermode.CreateServerDto;
import kr.codemons.orbitproject.domain.entity.server.Server;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ServerUserModeService {

    private final ServerService serverService;

    public Server create (CreateServerDto dto) {
        return serverService.create(dto);
    }

    public List<Server> getServers () {
        return serverService.getServers();
    }

    public List<Server> getEnableServers () {
        List<Server> servers = serverService.getServers();
        List<Server> enableServers = new ArrayList<>();
        servers.forEach(server -> {
            if (server.isEnable()) {
                enableServers.add(server);
            }
        });
        return enableServers;
    }
}
