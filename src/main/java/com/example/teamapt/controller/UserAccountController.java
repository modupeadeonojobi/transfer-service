package com.example.teamapt.controller;

import com.example.teamapt.dto.UserRequestDto;
import com.example.teamapt.service.UserAccountService;
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
@RequestMapping("/api")
@AllArgsConstructor
public class UserAccountController {

    private UserAccountService userAccountService;

    @PostMapping("/signUp")
    public ResponseEntity<?> signUp(@RequestBody UserRequestDto dto) {
        return new ResponseEntity<>(userAccountService.create(dto), HttpStatus.CREATED);
    }

    @GetMapping("/secured-endpoint")
    public ResponseEntity<?> securedAPI() {
        return new ResponseEntity<>("This is a secured API", HttpStatus.OK);
    }
}
