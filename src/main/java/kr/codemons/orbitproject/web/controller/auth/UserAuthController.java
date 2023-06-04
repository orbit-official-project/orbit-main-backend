package kr.codemons.orbitproject.web.controller.auth;

import kr.codemons.orbitproject.domain.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class UserAuthController {

    private final EmailService emailService;

    @GetMapping("/certification/{target}")
    public HttpEntity<?> sendCertificationCode (@PathVariable("target") String email) {
        emailService.sendCertificationMail(email);
        return ResponseEntity.ok("DONE");
    }
}
