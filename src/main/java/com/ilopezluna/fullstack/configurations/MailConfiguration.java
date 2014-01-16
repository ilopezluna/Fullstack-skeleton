package com.ilopezluna.fullstack.configurations;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yammer.dropwizard.config.Configuration;

public class MailConfiguration extends Configuration
{
	@JsonProperty
	private String email;

	@JsonProperty
	private String username;

	@JsonProperty
	private String password;

	public String getUsername()
	{
		return username;
	}

	public String getPassword()
	{
		return password;
	}

	public String getEmail()
	{
		return email;
	}
}
