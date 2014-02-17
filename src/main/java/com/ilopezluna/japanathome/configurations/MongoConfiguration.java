package com.ilopezluna.japanathome.configurations;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.yammer.dropwizard.config.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

public class MongoConfiguration extends Configuration
{
	@NotEmpty
	@JsonProperty
	private String uri;

	@JsonProperty
	private int port;

	@NotEmpty
	@JsonProperty
	private String database;

	@JsonProperty
	private String username;

	@JsonProperty
	private String password;


	public String getUri()
	{
		return uri;
	}

	public int getPort()
	{
		return port;
	}

	public String getDatabase()
	{
		return database;
	}

	public String getUsername()
	{
		return username;
	}

	public String getPassword()
	{
		return password;
	}
}

