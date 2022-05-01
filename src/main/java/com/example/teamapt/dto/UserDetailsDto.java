package com.example.teamapt.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDetailsDto {

	private Long userId;

	private String email;

	private String token;

	private String fullName;

	private String phone;

}
