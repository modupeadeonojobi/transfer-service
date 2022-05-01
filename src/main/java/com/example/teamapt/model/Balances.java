package com.example.teamapt.model;

import javax.persistence.*;

@Entity
@Table(name = "balances")
public class Balances {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "account_nr")
	private long account;

	@Column(name = "balance")
	private double balance;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getAccount() {
		return account;
	}

	public void setAccount(long account) {
		this.account = account;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Balances{" + "id=" + id + ", account=" + account + ", balance=" + balance
				+ '}';
	}

}
