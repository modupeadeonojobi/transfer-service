package com.example.teamapt.repository;

import com.example.teamapt.model.Balances;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BalancesRepository extends JpaRepository<Balances, Long> {

	boolean existsByAccount(long account);

	Balances findByAccount(long balance);

}
