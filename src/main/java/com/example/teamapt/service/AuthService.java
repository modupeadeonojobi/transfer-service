package com.example.teamapt.service;

import com.example.teamapt.dto.LoginDto;
import com.example.teamapt.dto.UserDetailsDto;

/**
 * @author iModupsy
 * @created 01/05/2022
 */
public interface AuthService {

	UserDetailsDto login(LoginDto loginDto);

}
