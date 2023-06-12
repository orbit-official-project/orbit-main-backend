package kr.codemons.orbitproject.domain.service.server;

import kr.codemons.orbitproject.domain.dto.server.usermode.CreateServerDto;
import kr.codemons.orbitproject.domain.entity.server.EnableServer;
import kr.codemons.orbitproject.domain.entity.server.Server;
import kr.codemons.orbitproject.domain.exception.DuplicateHostNameException;
import kr.codemons.orbitproject.domain.exception.ServerNotFoundException;
import kr.codemons.orbitproject.domain.repository.EnableServerRepository;
import kr.codemons.orbitproject.domain.repository.ServerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServerService {

    private final ServerRepository readyServerRepository;
    private final EnableServerRepository enableServerRepository;

    public Server create (CreateServerDto dto) {
        if (isExistsHostName(dto.getName())) {
            throw new DuplicateHostNameException(); }
        
        return readyServerRepository.save(dto.toServerEntity());
    }

    public void enable (EnableServer enableServer) {
        enableServerRepository.save(enableServer);
    }

    public Server getServer (String host) {
        return readyServerRepository.findById(host).orElseThrow(ServerNotFoundException::new);
    }
    public List<Server> getServers () { return readyServerRepository.findAll(); }

    public EnableServer getServerDetail (String host) {
        Server findServer = getServer(host);
        return enableServerRepository.findByServer(findServer)
                .orElseThrow(ServerNotFoundException::new);
    }

    public boolean isExistsHostName (String hostName) {
        Optional<Server> findServer = readyServerRepository.findById(hostName);
        return findServer.isPresent();
    }

    public void modifyReadyServer(Server modified) {

    }

    public void modifyEnabledServer (EnableServer modified) {

    }
}
