package com.eccentric.auth.sevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.eccentric.auth.dto.LoginRequest;
import com.eccentric.auth.dto.RegisterRequest;
import com.eccentric.auth.dto.UserResponse;
import com.eccentric.auth.entity.User;
import com.eccentric.auth.repository.UserRepository;
import com.eccentric.auth.util.JwtUtil;

@Service
public class AuthService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private JwtUtil jwt;

	public UserResponse register(RegisterRequest req) {
		User user = new User();
		user.setUsername(req.getUsername());
		user.setEmail(req.getEmail());
		user.setPassword(encoder.encode(req.getPassword()));
		user.setRole("USER");
		User usr = userRepository.save(user);
		String token = jwt.generateToken(user.getUsername(), user.getRole());
		return new UserResponse(usr.getId(), usr.getUsername(), usr.getEmail(), usr.getRole(), token);
	}

	public UserResponse login(LoginRequest req) {
		User user = userRepository.findByUsername(req.getUsernameOrEmail())
					.orElseGet(() -> userRepository.findByEmail(req.getUsernameOrEmail())
					.orElseThrow(() -> new RuntimeException("User not found: " + req.getUsernameOrEmail())));
		if(!encoder.matches(req.getPassword(), user.getPassword())) {
			throw new RuntimeException("Invalid Credentials");
		}
		String token = jwt.generateToken(user.getUsername(), user.getRole());
		return new UserResponse(user.getId(), user.getUsername(), user.getEmail(), user.getRole(), token);
	}
}
