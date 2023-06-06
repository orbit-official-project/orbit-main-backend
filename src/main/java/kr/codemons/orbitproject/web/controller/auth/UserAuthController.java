package kr.codemons.orbitproject.web.controller.auth;

import kr.codemons.orbitproject.domain.dto.UserAuthVerifyDto;
import kr.codemons.orbitproject.domain.entity.cache.EmailSession;
import kr.codemons.orbitproject.domain.entity.user.User;
import kr.codemons.orbitproject.domain.exception.InvalidVerifyCodeException;
import kr.codemons.orbitproject.domain.service.EmailService;
import kr.codemons.orbitproject.domain.service.RedisEmailSessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class UserAuthController {
    private final EmailService emailService;
    private final RedisEmailSessionService emailSessionService;

    @GetMapping("/certification/{target}")
    public HttpEntity<?> sendCertificationCode (@PathVariable("target") String email) {
        emailService.sendCertificationMail(email);
        return ResponseEntity.ok("DONE");
    }

    @PostMapping("/verify")
    public HttpEntity<?> verifyCode (UserAuthVerifyDto verifyDto) {
        EmailSession findEmailSession = emailSessionService.get(verifyDto.getEmail())
                .orElseThrow(InvalidVerifyCodeException::new);

        //TODO 해야함

        return ResponseEntity.ok("verify!");
    }

    @PostMapping("/register")
    public HttpEntity<?> join () {


        return ResponseEntity.ok("JOIN");
    }

    @PostMapping("/login")
    public HttpEntity<?> login () {
        return ResponseEntity.ok("LOGIN");
    }
}
