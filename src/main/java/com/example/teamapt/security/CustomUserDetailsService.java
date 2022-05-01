package com.example.teamapt.security;

import com.example.teamapt.exception.NotFoundException;
import com.example.teamapt.model.UserAccount;
import com.example.teamapt.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * @author iModupsy
 * @created 18/03/2022
 */

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserAccountRepository userAccountDao;

	@Override

	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		UserAccount account = userAccountDao.findByEmail(username);

		if (account == null) {
			throw new NotFoundException("Invalid login credential");
		}
		else {
			String role = account.getRole();

			Set<GrantedAuthority> grantedAuthorities = new HashSet();
			grantedAuthorities.add(new SimpleGrantedAuthority(role));

			return new User(account.getEmail(), account.getPassword(),
					grantedAuthorities);
		}
	}

}
