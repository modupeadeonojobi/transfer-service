package com.example.teamapt.service.impl;

import com.example.teamapt.dto.UserRequestDto;
import com.example.teamapt.model.UserAccount;
import com.example.teamapt.repository.UserAccountRepository;
import com.example.teamapt.service.UserAccountService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author iModupsy
 * @created 18/03/2022
 */

@Service
@AllArgsConstructor
public class UserAccountServiceImpl implements UserAccountService {

	private UserAccountRepository userAccountRepository;

	private PasswordEncoder passwordEncoder;

	@Override
	public UserAccount create(UserRequestDto dto) {
		UserAccount user = new UserAccount();
		user.setEmail(dto.getEmail());
		user.setRole(dto.getRole());
		user.setPassword(passwordEncoder.encode(dto.getPassword()));
		return userAccountRepository.save(user);
	}

}
