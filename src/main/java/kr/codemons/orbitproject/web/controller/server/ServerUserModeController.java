package kr.codemons.orbitproject.web.controller.server;

import kr.codemons.orbitproject.domain.service.server.ServerUserModeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/servers")
@RequiredArgsConstructor
public class ServerUserModeController {

    private final ServerUserModeService serverService;

    @GetMapping
    public HttpEntity<?> getServers () {
        return ResponseEntity.ok("S");
    }

    @PostMapping
    public HttpEntity<?> createServer () {

        return ResponseEntity.ok("create");
    }
}
