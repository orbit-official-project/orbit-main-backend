package kr.codemons.orbitproject.web.controller.auth;

import jakarta.validation.Valid;
import kr.codemons.orbitproject.domain.dto.UserAuthSignUpDto;
import kr.codemons.orbitproject.domain.dto.UserAuthVerifyDto;
import kr.codemons.orbitproject.domain.entity.cache.EmailSession;
import kr.codemons.orbitproject.domain.exception.InvalidVerifyCodeException;
import kr.codemons.orbitproject.domain.service.EmailService;
import kr.codemons.orbitproject.domain.service.RedisEmailSessionService;
import kr.codemons.orbitproject.domain.service.UserAuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class UserAuthController {

    private final EmailService emailService;
    private final RedisEmailSessionService emailSessionService;
    private final UserAuthService userAuthService;


    /**
     * @name 이메일 인증 코드를 전송해주는 API
     * @usage localhost:8080/auth/certificate/test@naver.com
     *
     * @param email 보안 코드를 받을 이메일
     */
    @GetMapping("/certificate/{email}")
    public HttpEntity<?> sendCertificateCode (@PathVariable String email) {
        String code = emailService.sendCertificationMail(email);
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
     */
    @PostMapping("/verify")
    public HttpEntity<?> verifyCode (UserAuthVerifyDto verifyDto) {
        EmailSession findEmailSession = emailSessionService.get(verifyDto.getEmail())
                .orElseThrow(InvalidVerifyCodeException::new);

        //TODO 해야함


        return ResponseEntity.ok("verify!");
    }


    /**
     * 회원가입 컨트롤러
     * @param dto
     * @param bindingResult
     * @return
     */
    @PostMapping("/signup")
    public HttpEntity<?> signUp (@RequestBody @Valid UserAuthSignUpDto dto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.info(bindingResult.toString());
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
