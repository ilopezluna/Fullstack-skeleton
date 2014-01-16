package com.ilopezluna.fullstack.configurations;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yammer.dropwizard.config.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

public class AWSConfiguration extends Configuration
{
	@NotEmpty
	@JsonProperty
	private String accessKey;

	@NotEmpty
	@JsonProperty
	private String secretKey;

	@NotEmpty
	@JsonProperty
	private String imagesBucket;

	public String getAccessKey()
	{
		return accessKey;
	}

	public String getSecretKey()
	{
		return secretKey;
	}

	public String getImagesBucket()
	{
		return imagesBucket;
	}
}
