package com.ilopezluna.japanathome.entities;

public class Subscriber extends Basic {

	public static final String COLLECTION_NAME = "subscribers";

	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
