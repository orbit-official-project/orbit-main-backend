package kr.codemons.orbitproject.web.controller.server;

import jakarta.validation.Valid;
import kr.codemons.orbitproject.domain.dto.server.kernelmode.EnableServerDto;
import kr.codemons.orbitproject.domain.service.server.ServerKernelModeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/mode/kernel")
@RequiredArgsConstructor
public class ServerKernelModeController {

    private final ServerKernelModeService kernelModeService;
    
    @PostMapping("/enable")
    public void enableServer (@Valid @RequestBody EnableServerDto dto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new IllegalStateException();
        }
        kernelModeService.enableServer(dto);
    }

    @PostMapping("/disable")
    public void disableServer () {

    }
}
