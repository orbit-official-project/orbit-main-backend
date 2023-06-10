package kr.codemons.orbitproject.web.controller;

import kr.codemons.orbitproject.domain.service.ServerService;
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
public class ServerController {

    private final ServerService serverService;

    @GetMapping
    public HttpEntity<?> getServers () {
        return ResponseEntity.ok("S");
    }

    @PostMapping
    public HttpEntity<?> createServer () {

        return ResponseEntity.ok("create");
    }
}
