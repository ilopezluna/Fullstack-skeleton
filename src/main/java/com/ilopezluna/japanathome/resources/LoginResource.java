package com.ilopezluna.japanathome.resources;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.ilopezluna.japanathome.entities.User;
import com.ilopezluna.japanathome.services.UserService;
import com.yammer.dropwizard.auth.Auth;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import static com.ilopezluna.japanathome.utils.Constants.LOGIN_URI;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Singleton
@Path( LOGIN_URI )
@Produces( APPLICATION_JSON )
public class LoginResource
{
	private final UserService userService;

	@Inject
	public LoginResource(UserService userService) {
		this.userService = userService;
	}

	@POST
	public Response login(@Auth User user)
	{
		return Response.ok().build();
	}
}
