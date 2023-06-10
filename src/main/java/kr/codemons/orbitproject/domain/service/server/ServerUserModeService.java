package kr.codemons.orbitproject.domain.service.server;

import kr.codemons.orbitproject.domain.dto.ServerCreateDto;
import kr.codemons.orbitproject.domain.repository.ServerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServerUserModeService {

    private final ServerRepository serverRepository;

    public void create (ServerCreateDto dto) {

    }
}
