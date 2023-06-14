package kr.codemons.orbitproject.web.controller.auth;

import jakarta.validation.Valid;
import kr.codemons.orbitproject.domain.dto.RequestEmailAuthentication;
import kr.codemons.orbitproject.domain.dto.RequestUserAuthSignIn;
import kr.codemons.orbitproject.domain.dto.RequestUserAuthSignUp;
import kr.codemons.orbitproject.domain.dto.response.ResponseUserProfile;
import kr.codemons.orbitproject.domain.exception.MissingParameterException;
import kr.codemons.orbitproject.domain.service.EmailService;
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
    private final UserAuthService userAuthService;


    /**
     * @name 이메일 인증 코드를 전송해주는 API
     * @usage /auth/cert/test@naver.com
     *
     * @param email 보안 코드를 받을 이메일
     */
    @GetMapping("/cert/{email}")
    public HttpEntity<?> sendCertificatedCode (@PathVariable String email) {
        String code = emailService.sendCertificatedMail(email);
        return ResponseEntity.ok("DONE");
    }
    
    
    /**
     * 이메일 인증 코드가 유효한지 확인하는 API
     * ex) /auth/validate/email
     * [Body]
     *  {
     *      code: string
     *      email: string
     *  }
     * @param authentication 이메일과 보안코드가 담긴 DTO
     */
    @PostMapping("/validate/email")
    public HttpEntity<?> checkEmail (@RequestBody RequestEmailAuthentication authentication) {
        userAuthService.emailAuthenticate(authentication);
        return ResponseEntity.ok("OK");

    }

    /**
     * 회원가입 API
     * @param dto
     * @param bindingResult
     * @return
     */
    @PostMapping("/signup")
    public HttpEntity<?> signUp (@RequestBody @Valid RequestUserAuthSignUp dto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new MissingParameterException();
        }

        userAuthService.join(dto);
        return ResponseEntity.ok("JOIN");
    }

    /**
     * 로그인 API
     * @return
     */
    @PostMapping("/signIn")
    public HttpEntity<ResponseUserProfile> signIn (@RequestBody RequestUserAuthSignIn signInDto) {
        ResponseUserProfile loginUser = userAuthService.login(signInDto);
        return ResponseEntity.ok(loginUser);
    }
}
