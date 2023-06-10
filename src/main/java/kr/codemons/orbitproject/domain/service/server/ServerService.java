package kr.codemons.orbitproject.domain.service.server;

import kr.codemons.orbitproject.domain.dto.ServerCreateDto;
import kr.codemons.orbitproject.domain.entity.server.Server;
import kr.codemons.orbitproject.domain.exception.DuplicateHostNameException;
import kr.codemons.orbitproject.domain.repository.ServerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServerService {

    private final ServerRepository serverRepository;

    public void create (ServerCreateDto dto) {
        if (isExistsHostName(dto.getName())) {
            throw new DuplicateHostNameException();
        }
        
        serverRepository.save(dto.toServerEntity());
    }

    private boolean isExistsHostName (String hostName) {
        Optional<Server> findServer = serverRepository.findById(hostName);
        return findServer.isPresent();
    }
}
