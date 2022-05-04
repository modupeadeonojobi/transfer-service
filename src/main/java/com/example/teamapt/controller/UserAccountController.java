package com.example.teamapt.controller;

import com.example.teamapt.constant.ApiRoute;
import com.example.teamapt.dto.UserRequestDto;
import com.example.teamapt.service.UserAccountService;
import com.example.teamapt.util.JsonResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author iModupsy
 * @created 18/03/2022
 */

@RestController
@CrossOrigin
@RequestMapping(value = ApiRoute.API)
@AllArgsConstructor
public class UserAccountController {

	private UserAccountService userAccountService;

	@PostMapping(value = ApiRoute.REGISTER)
	public ResponseEntity<?> signUp(@RequestBody UserRequestDto dto) {
		userAccountService.create(dto);
		return new ResponseEntity<>(new JsonResponse(HttpStatus.CREATED, true,
				"User registered successfully"), HttpStatus.CREATED);
	}

	@GetMapping(value = ApiRoute.AUTH + ApiRoute.SECURED_ENDPOINT)
	public ResponseEntity<?> securedAPI() {
		return new ResponseEntity<>(
				new JsonResponse(HttpStatus.CREATED, true, "This is a secured API"),
				HttpStatus.OK);
	}

}
