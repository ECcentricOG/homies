package com.eccentric.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eccentric.auth.dto.LoginRequest;
import com.eccentric.auth.dto.RegisterRequest;
import com.eccentric.auth.dto.UserResponse;
import com.eccentric.auth.sevice.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private AuthService authService;

	@PostMapping("/register")
	public ResponseEntity<UserResponse> register(@RequestBody RegisterRequest req) {
		UserResponse resp = authService.register(req);
		if (resp == null) {
			throw new RuntimeException("Failed to register");
		}
		return new ResponseEntity<>(resp, HttpStatus.CREATED);
	}

	public ResponseEntity<UserResponse> login(@RequestBody LoginRequest req) {
		UserResponse resp = authService.login(req);
		if (resp == null) {
			throw new RuntimeException("Failed to register");
		}
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}
}
