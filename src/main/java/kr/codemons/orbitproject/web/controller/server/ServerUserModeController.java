package kr.codemons.orbitproject.web.controller.server;

import jakarta.validation.Valid;
import kr.codemons.orbitproject.domain.dto.server.usermode.CreateServerDto;
import kr.codemons.orbitproject.domain.entity.server.Server;
import kr.codemons.orbitproject.domain.service.server.ServerUserModeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usermode")
@RequiredArgsConstructor
public class ServerUserModeController {

    private final ServerUserModeService serverService;

    @GetMapping("/ready_server")
    public List<Server> getReadyServers () {
        return serverService.getServers();
    }

    @GetMapping("/enable_server")
    public List<Server> getEnableServers () {
        return serverService.getEnableServers();
    }

    @PostMapping("/server")
    public HttpEntity<?> createServer (@Valid @RequestBody CreateServerDto dto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new IllegalStateException();
        }

        Server server = serverService.create(dto);
        return ResponseEntity.ok(server.getSecret());
    }
}
