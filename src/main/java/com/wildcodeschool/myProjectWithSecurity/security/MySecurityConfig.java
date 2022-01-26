package com.wildcodeschool.myProjectWithSecurity.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
			.authorizeRequests()
//				.anyRequest().authenticated() //Pour n'importe quelle requête, on doit être authentifié
				.antMatchers("/avengers/assemble").hasRole("CHAMPION")
				.antMatchers("/secret-base").hasRole("DIRECTOR").and() //authorise uniquement le role admin à avoir accès à cette page
			.formLogin().and()	//formulaire de connexion
			.httpBasic();		//authentification de type basique http
	}
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{

		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		auth.inMemoryAuthentication()
			.withUser("Steve")
				.password(encoder.encode("motdepasse"))
					.roles("CHAMPION").and()
			.withUser("Nick")
				.password(encoder.encode("flerken"))
					.roles("DIRECTOR");
	}
	

}
