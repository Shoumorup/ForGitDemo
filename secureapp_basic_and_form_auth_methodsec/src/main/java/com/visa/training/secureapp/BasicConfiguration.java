package com.visa.training.secureapp;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
	@EnableWebSecurity
	@Order(Ordered.HIGHEST_PRECEDENCE)
	public class BasicConfiguration extends WebSecurityConfigurerAdapter {
	 
	    @Override
	    protected void configure(AuthenticationManagerBuilder auth)
	      throws Exception {
	        auth
	          .inMemoryAuthentication()//Not stored in the DB 
	          .withUser("user")//USERNAME - "user"
	            .password("{noop}password")//PASSWORD - "password" (should not be stored in clear text- noop Encoder(does nothing) is used for testing.)
	            .roles("USER")//ROLE- "USER"
	            .and()
	          .withUser("admin")
	            .password("{noop}admin")
	            .roles("USER", "ADMIN");
	    }
	 
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	    	 http.csrf().disable();
	         http.antMatcher("/api/**") 
	             .authorizeRequests()
	             .anyRequest()
	             .authenticated() 
	             .and() 
	             .httpBasic();
	    }
	}

