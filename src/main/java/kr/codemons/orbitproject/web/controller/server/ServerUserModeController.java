package kr.codemons.orbitproject.web.controller.server;

import kr.codemons.orbitproject.domain.dto.CreateServerDto;
import kr.codemons.orbitproject.domain.service.server.ServerUserModeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usermode")
@RequiredArgsConstructor
public class ServerUserModeController {

    private final ServerUserModeService serverService;

    @GetMapping("/server")
    public HttpEntity<?> getServers () {
        return ResponseEntity.ok("S");
    }

    @PostMapping("/server")
    public HttpEntity<?> createServer (@RequestBody CreateServerDto dto) {
        serverService.create(dto);
        return ResponseEntity.ok("create");
    }
}
