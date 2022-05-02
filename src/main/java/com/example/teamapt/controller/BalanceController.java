package com.example.teamapt.controller;

import com.example.teamapt.model.Balances;
import com.example.teamapt.repository.BalancesRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class BalanceController {

	private BalancesRepository balancesRepository;

	@PostMapping("/create-balance/{account}/{balance}")
	public ResponseEntity<?> createBalance(@PathVariable long account,
			@PathVariable double balance) {
		if (String.valueOf(account).length() != 10) {
			return new ResponseEntity<>(
					"Account number should not be more than or less than 10 digits ",
					HttpStatus.BAD_REQUEST);
		}

		if (balancesRepository.existsByAccount(account)) {
			return new ResponseEntity<>("Account already exists", HttpStatus.CONFLICT);
		}

		Balances newAccBalance = new Balances();
		newAccBalance.setBalance(balance);
		newAccBalance.setAccount(account);
		Balances balances = balancesRepository.save(newAccBalance);
		balances.toString();

		if (balances != null) {
			return new ResponseEntity<>(balances, HttpStatus.OK);
		}

		return new ResponseEntity<>("Unable to save...", HttpStatus.NO_CONTENT);
	}

	@GetMapping("/view-balance/{account}")
	public ResponseEntity<?> getBalance(@PathVariable long account) {
		if (!balancesRepository.existsByAccount(account)) {
			return new ResponseEntity<>("Account does not exist", HttpStatus.NOT_FOUND);
		}

		double balances = balancesRepository.findByAccount(account).getBalance();
		return new ResponseEntity<>(balances, HttpStatus.OK);
	}

}
