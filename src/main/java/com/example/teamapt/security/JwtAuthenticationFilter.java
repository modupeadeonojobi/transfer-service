package com.example.teamapt.security;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author iModupsy
 * @created 03/03/2022
 */
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Autowired
	private JwtTokenProvider jwtTokenUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res,
			FilterChain chain) throws IOException, ServletException {

		String header = req.getHeader("Authorization");
		String username = null;
		String authToken = null;

		if (header != null && header.startsWith("Bearer ")) {
			authToken = header.replace("Bearer ", "");
			try {
				username = jwtTokenUtil.getUsernameFromToken(authToken);
			}
			catch (IllegalArgumentException e) {
				logger.error("an error occurred during getting username from token", e);
			}
			catch (ExpiredJwtException e) {
				logger.warn("the token is expired and not valid anymore", e);
			}
			catch (SignatureException e) {
				logger.error("Authentication Failed. Username or Password not valid.");
			}
		}
		else {
			logger.warn("couldn't find bearer string, will ignore the header");
		}
		if (username != null
				&& SecurityContextHolder.getContext().getAuthentication() == null) {

			UserDetails userDetails = customUserDetailsService
					.loadUserByUsername(username);

			if (jwtTokenUtil.validateToken(authToken, userDetails)) {
				UsernamePasswordAuthenticationToken authentication = jwtTokenUtil
						.getAuthentication(authToken,
								SecurityContextHolder.getContext().getAuthentication(),
								userDetails);

				authentication.setDetails(
						new WebAuthenticationDetailsSource().buildDetails(req));
				logger.info(
						"authenticated user " + username + ", setting security context");
				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
		}

		chain.doFilter(req, res);
	}

}
