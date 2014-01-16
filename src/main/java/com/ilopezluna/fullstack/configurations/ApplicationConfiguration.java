package com.ilopezluna.fullstack.configurations;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yammer.dropwizard.config.Configuration;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class ApplicationConfiguration  extends Configuration
{

	@Valid
	@NotNull
	@JsonProperty
	private MongoConfiguration mongo = new MongoConfiguration();

	@Valid
	@NotNull
	@JsonProperty
	private MailConfiguration mail = new MailConfiguration();

	@Valid
	@NotNull
	@JsonProperty
	private AWSConfiguration aws = new AWSConfiguration();

	public MongoConfiguration getMongo()
	{
		return mongo;
	}

	public MailConfiguration getMail()
	{
		return mail;
	}

	public AWSConfiguration getAws()
	{
		return aws;
	}
}
