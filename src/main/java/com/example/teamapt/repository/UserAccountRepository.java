package com.example.teamapt.repository;

import com.example.teamapt.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author iModupsy
 * @created 18/03/2022
 */

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

	UserAccount findByEmail(String name);

}
