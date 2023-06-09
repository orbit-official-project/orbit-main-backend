package kr.codemons.orbitproject.web.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/servers")
public class ServerController {
	
	@GetMapping
	public HttpEntity<?> getServers() {
		return ResponseEntity.ok("S");
	}
}
