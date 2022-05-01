package com.example.teamapt.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @author iModupsy
 * @created 18/03/2022
 */

@Entity
@Data
public class UserAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false, unique = true)
	private String email;

	private String password;

	private String role;

}
