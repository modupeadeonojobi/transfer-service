package com.example.teamapt.controller;

import com.example.teamapt.constant.ApiRoute;
import com.example.teamapt.dto.LoginDto;
import com.example.teamapt.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author iModupsy
 * @created 01/05/2022
 */
@RestController
@CrossOrigin
@RequestMapping(value = ApiRoute.API)
@AllArgsConstructor
public class AuthController {

	private AuthService authService;

	@PostMapping(value = ApiRoute.LOGIN)
	public ResponseEntity<?> login(@RequestBody @Valid LoginDto loginDto) {
		return new ResponseEntity<>(authService.login(loginDto), HttpStatus.OK);

	}

}
