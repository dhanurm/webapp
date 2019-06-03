package com.clc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.clc.dao.EmployeeDaoServiceSecurity;


// 
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
// 
//	@Autowired
//	  private UserDetailsService userDetailsService;
//	
//	
//	  
//	  public SecurityConfig(UserDetailsService userDetailsService) {
//		super();
//		this.userDetailsService = new EmployeeDaoServiceSecurity();
//	}
//
//	@Bean
//	  public BCryptPasswordEncoder passwordEncoder() {
//	    return new BCryptPasswordEncoder();
//	  };
//	  
//	  @Override
//	  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		  
////	    auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//		  
//		  auth.inMemoryAuthentication()
//          .withUser("admin").password(passwordEncoder().encode("admin123")).roles("admin");
//	  }
//
//	  @Override
//	  protected void configure(HttpSecurity http) throws Exception {
//	    http.authorizeRequests().anyRequest().hasAnyRole("admin")
//	    .and()
//	    .authorizeRequests().antMatchers("/login**").permitAll()
//	    .and()
//	    .formLogin().permitAll()
//	    .and()
//	    .logout().logoutSuccessUrl("/login").permitAll()
//	    .and()
//	    .csrf().disable();
//	    
//	  }
//	}