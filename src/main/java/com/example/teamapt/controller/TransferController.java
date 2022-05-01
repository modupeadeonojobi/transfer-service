package com.example.teamapt.controller;

import com.example.teamapt.model.Balances;
import com.example.teamapt.model.Transactions;
import com.example.teamapt.model.TransferRequest;
import com.example.teamapt.repository.BalancesRepository;
import com.example.teamapt.repository.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
public class TransferController {

	@Autowired
	BalancesRepository balancesRepository;

	@Autowired
	TransactionsRepository transactionsRepository;

	@Transactional
	@PostMapping("transfer")
	public ResponseEntity<?> transfer(@RequestBody TransferRequest transferRequest) {

		long tempAccountFrom = transferRequest.getFrom();
		long tempAccountTo = transferRequest.getTo();
		double amount = transferRequest.getAmount();
		if (!balancesRepository.existsByAccount(tempAccountFrom)) {
			return new ResponseEntity<>("Account: " + tempAccountFrom + " not found",
					HttpStatus.BAD_REQUEST);
		}
		if (!balancesRepository.existsByAccount(tempAccountTo)) {
			return new ResponseEntity<>("Account: " + tempAccountTo + " not found",
					HttpStatus.BAD_REQUEST);
		}

		Balances fromAccount = balancesRepository.findByAccount(tempAccountFrom);
		Balances toAccount = balancesRepository.findByAccount(tempAccountTo);

		if (fromAccount.getBalance() < amount) {
			return new ResponseEntity<>("Insufficient fund", HttpStatus.FORBIDDEN);
		}
		else {
			double balance = fromAccount.getBalance();
			double newBalance = balance - amount;
			fromAccount.setBalance(newBalance);
			Balances savedFrom = balancesRepository.save(fromAccount);

			balance = toAccount.getBalance();
			newBalance = balance + amount;
			toAccount.setBalance(newBalance);
			Balances savedTo = balancesRepository.save(toAccount);

			Transactions newAccount = new Transactions();
			newAccount.setAccount(tempAccountFrom);
			newAccount.setAmount(amount);
			transactionsRepository.save(newAccount);

			if (savedFrom != null && savedTo != null) {
				return new ResponseEntity<>("Transfer Successful", HttpStatus.OK);
			}

		}

		return new ResponseEntity<>("transaction failed", HttpStatus.FORBIDDEN);
	}

}
