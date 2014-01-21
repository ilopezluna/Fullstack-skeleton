package com.ilopezluna.fullstack.authenticators;

import com.google.common.base.Optional;
import com.ilopezluna.fullstack.entities.User;
import com.yammer.dropwizard.auth.AuthenticationException;
import com.yammer.dropwizard.auth.Authenticator;
import com.yammer.dropwizard.auth.basic.BasicCredentials;

public class BasicAuthenticator implements Authenticator<BasicCredentials, User>
{
	@Override
	public Optional<User> authenticate(BasicCredentials credentials) throws AuthenticationException
	{
		//TODO If exists an user with username and password...
		if ("secret".equals(credentials.getPassword()))
		{
			return Optional.of(new User());
		}
		return Optional.absent();
	}


}
