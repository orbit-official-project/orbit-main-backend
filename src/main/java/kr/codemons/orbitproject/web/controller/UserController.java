package kr.codemons.orbitproject.web.controller;

import kr.codemons.orbitproject.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profile")
@RequiredArgsConstructor
public class UserController {
	private final UserService userService;
	
	@GetMapping("{handler}")
	public HttpEntity<?> getUserProfileByHandler(@PathVariable String handler) {
		return ResponseEntity.ok(userService.findByHandler(handler));
	}
}