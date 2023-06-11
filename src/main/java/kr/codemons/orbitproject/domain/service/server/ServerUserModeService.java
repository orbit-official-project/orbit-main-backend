package kr.codemons.orbitproject.domain.service.server;

import kr.codemons.orbitproject.domain.dto.CreateServerDto;
import kr.codemons.orbitproject.domain.entity.server.Server;
import kr.codemons.orbitproject.domain.repository.ServerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ServerUserModeService {

    private final ServerRepository serverRepository;
    private final ServerService serverService;

    public void create (CreateServerDto dto) {
        serverService.create(dto);
    }

    public List<Server> getEnableServer () {
        return new ArrayList<>();
    }
}
