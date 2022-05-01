package com.example.teamapt.service.impl;

import com.example.teamapt.dto.LoginDto;
import com.example.teamapt.dto.UserDetailsDto;
import com.example.teamapt.model.UserAccount;
import com.example.teamapt.repository.UserAccountRepository;
import com.example.teamapt.security.JwtTokenProvider;
import com.example.teamapt.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * @author iModupsy
 * @created 01/05/2022
 */
@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

	AuthenticationManager authenticationManager;

	UserAccountRepository userAccountDao;

	JwtTokenProvider tokenProvider;

	@Override
	public UserDetailsDto login(LoginDto loginDto) {
		final Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getEmail(),
						loginDto.getPassword()));

		UserAccount acct = userAccountDao.findByEmail(loginDto.getEmail());

		SecurityContextHolder.getContext().setAuthentication(authentication);
		final String token = tokenProvider.generateToken(authentication);

		UserDetailsDto dto = new UserDetailsDto();
		dto.setUserId(acct.getId());
		dto.setToken(token);
		dto.setEmail(acct.getEmail());
		return dto;

	}

}
