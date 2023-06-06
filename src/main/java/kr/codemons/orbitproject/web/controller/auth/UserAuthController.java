package kr.codemons.orbitproject.web.controller.auth;

import jakarta.validation.Valid;
import kr.codemons.orbitproject.domain.dto.UserAuthSignUpDto;
import kr.codemons.orbitproject.domain.dto.UserAuthVerifyDto;
import kr.codemons.orbitproject.domain.entity.cache.EmailSession;
import kr.codemons.orbitproject.domain.entity.user.User;
import kr.codemons.orbitproject.domain.exception.InvalidVerifyCodeException;
import kr.codemons.orbitproject.domain.service.EmailService;
import kr.codemons.orbitproject.domain.service.RedisEmailSessionService;
import kr.codemons.orbitproject.domain.service.UserAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class UserAuthController {
    private final EmailService emailService;
    private final RedisEmailSessionService emailSessionService;
    private final UserAuthService userAuthService;
    
    /**
     * @name 이메일 인증 코드를 전송해주는 API
     * @usage localhost:8080/auth/certification/test@naver.com
     *
     * @param email 보안 코드를 받을 이메일
     */
    @GetMapping("/certificate/{email}")
    public HttpEntity<?> sendCertificationCode (@PathVariable String email) {
        emailService.sendCertificationMail(email);
        return ResponseEntity.ok("DONE");
    }
    
    
    /**
     * 이메일 인증 코드가 유효한지 확인하는 API
     * ex) localhost:8080/auth/verify
     * [Body]
     *  {
     *      code: string
     *      email: string
     *  }
     * @param verifyDto 이메일과 보안코드가 담긴 DTO
     * @return
     */
    @PostMapping("/verify")
    public HttpEntity<?> verifyCode (UserAuthVerifyDto verifyDto) {
        EmailSession findEmailSession = emailSessionService.get(verifyDto.getEmail())
                .orElseThrow(InvalidVerifyCodeException::new);

        //TODO 해야함

        return ResponseEntity.ok("verify!");
    }
    
    @PostMapping("/signup")
    public HttpEntity<?> signUp (@Valid UserAuthSignUpDto dto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new RuntimeException(); // TODO 커스텀 익셉션 추가
        }
        
        userAuthService.join(dto);
        
        return ResponseEntity.ok("JOIN");
    }

    @PostMapping("/login")
    public HttpEntity<?> login () {
        return ResponseEntity.ok("LOGIN");
    }
}
