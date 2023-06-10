package kr.codemons.orbitproject.web.controller.auth;

import kr.codemons.orbitproject.domain.service.UserAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/validate")
public class ValidationController {
	
	private final UserAuthService userAuthService;
	
	@GetMapping("/email/{email}")
	public boolean isExistsEmail(@PathVariable String email) {
		return userAuthService.isExistsEmail(email);
	}
}
