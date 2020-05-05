package com.capg.otms.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

	@GetMapping("/admin/message")
	public String getMessage() {
		return "Security Message";
	}
}
