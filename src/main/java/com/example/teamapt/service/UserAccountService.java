package com.example.teamapt.service;

import com.example.teamapt.dto.UserRequestDto;
import com.example.teamapt.model.UserAccount;

/**
 * @author iModupsy
 * @created 18/03/2022
 */
public interface UserAccountService {

    UserAccount create(UserRequestDto dto);
}
