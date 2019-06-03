package com.clc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.clc.entity.EmployeeEntity;

@Service("serviceSecurity")
public class EmployeeDaoServiceSecurity implements UserDetailsService {

	@Autowired
	private EmployeeDao daoImpl;

	public void setDaoImpl(EmployeeDao daoImpl) {
		this.daoImpl = new EmployeeDaoImpl();
	}

	public EmployeeDaoServiceSecurity() {

		super();

	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		EmployeeEntity user = daoImpl.fetchByuserName(username);
		UserBuilder builder = null;
		if (user != null) {
			builder = org.springframework.security.core.userdetails.User.withUsername(username);
			builder.password(user.getPassword());
			builder.authorities(user.getRole());
		} else {
			throw new UsernameNotFoundException("User not found.");
		}
		return builder.build();
	}

}
