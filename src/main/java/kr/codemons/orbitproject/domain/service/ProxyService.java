package kr.codemons.orbitproject.domain.service;

import kr.codemons.orbitproject.domain.dto.ServerCreateDto;
import kr.codemons.orbitproject.domain.repository.ServerRepository;
import kr.codemons.orbitproject.domain.utils.proxy.Host;
import kr.codemons.orbitproject.domain.utils.proxy.ProxyManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProxyService {

    private final ProxyManager proxyManager;
    private final ServerRepository serverRepository;

    public void create (ServerCreateDto dto) {
        
    }
}
