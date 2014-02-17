package com.ilopezluna.japanathome.authenticators;

import com.google.common.base.Optional;
import com.google.inject.Inject;
import com.ilopezluna.japanathome.entities.User;
import com.ilopezluna.japanathome.services.UserService;
import com.yammer.dropwizard.auth.AuthenticationException;
import com.yammer.dropwizard.auth.Authenticator;
import com.yammer.dropwizard.auth.basic.BasicCredentials;

public class BasicAuthenticator implements Authenticator<BasicCredentials, User>
{
	private final UserService userService;

	@Inject
	public BasicAuthenticator(UserService userService) {
		this.userService = userService;
	}

	@Override
	public Optional<User> authenticate(BasicCredentials credentials) throws AuthenticationException
	{
		User user = userService.getFromCredentials(credentials);
		//TODO If exists an user with username and password...
		if (user != null && userService.isAdmin(user))
		{
			return Optional.of(user);
		}
		return Optional.absent();
	}


}
