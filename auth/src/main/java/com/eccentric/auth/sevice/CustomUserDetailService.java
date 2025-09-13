package com.eccentric.auth.sevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.eccentric.auth.entity.User;
import com.eccentric.auth.repository.UserRepository;

@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(usernameOrEmail)
					.orElseGet(() -> userRepository.findByEmail(usernameOrEmail)
					.orElseThrow(() -> new UsernameNotFoundException("User not found : " + usernameOrEmail)));

		return org.springframework.security.core.userdetails.User
			.withUsername(user.getUsername())
			.password(user.getPassword())
			.roles(user.getRole())
			.build();
	}
}
