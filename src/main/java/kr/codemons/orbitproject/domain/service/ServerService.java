package kr.codemons.orbitproject.domain.service;

import kr.codemons.orbitproject.domain.dto.ServerCreateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServerService {

    private final ProxyService proxyService;

    public void create (ServerCreateDto dto) {

    }
}
