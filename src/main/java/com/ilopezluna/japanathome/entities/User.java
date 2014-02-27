package com.ilopezluna.japanathome.entities;

public class User extends Basic
{
	public static final String COLLECTION_NAME = "users";

	private Role role;

	private String password;

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}