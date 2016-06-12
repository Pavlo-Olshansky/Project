package com.cooking.app.configuration.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	CustomSuccessHandler customSuccessHandler;

	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("Андрій").password("андрій123").roles("USER");
		auth.inMemoryAuthentication().withUser("Паша").password("паша123").roles("USER");
		auth.inMemoryAuthentication().withUser("Ваньок").password("ваньок123").roles("ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests()
				.antMatchers("/", "/home", "/user/**").access("hasRole('USER')")
				.antMatchers("/admin/**").access("hasRole('ADMIN')")
				.antMatchers("/api/**").access("hasAnyRole('USER','ADMIN')")
				.and().formLogin().loginPage("/login").successHandler(customSuccessHandler)
				.usernameParameter("username").passwordParameter("password").and().exceptionHandling()
				.accessDeniedPage("/Access_Denied");
	}

}
