package com.clc.entity;

public class EmployeeBean {
	private int id;
	private String name;

	private String password;

	private String role;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "EmployeeBean [id=" + id + ", name=" + name + ", password=" + password + ", role=" + role + "]";
	}

	public EmployeeBean(int id, String name, String password, String role) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.role = role;
	}

	
	public EmployeeBean(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public EmployeeBean() {
		super();
		// TODO Auto-generated constructor stub
	}

}
