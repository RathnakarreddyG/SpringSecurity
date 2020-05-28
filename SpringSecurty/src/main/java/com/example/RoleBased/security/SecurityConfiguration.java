package com.example.RoleBased.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService principleUserService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

//		auth.userDetailsService(principleUserService).passwordEncoder(passworEncoder()).
//		auth.authenticationProvider(authenticationProvider());
		auth.userDetailsService(principleUserService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
//		.csrf().disable().authorizeRequests().antMatchers("/pronix/user_registration").permitAll().and().formLogin();
				.authorizeRequests().antMatchers("/pronix/**").permitAll().and().csrf().disable();
//				.defaultSuccessUrl("/pronix/getAllRoles");
	}

//	@Bean
//	DaoAuthenticationProvider authenticationProvider() {
//		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//		provider.setPasswordEncoder(passworEncoder());
//		provider.setUserDetailsService(this.principleUserService);
//		return provider;
//	}

//	@Bean
//	PasswordEncoder passworEncoder() {
//		return new BCryptPasswordEncoder();
//	}
	@Bean
	public PasswordEncoder passworEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
