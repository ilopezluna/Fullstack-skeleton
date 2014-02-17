package com.ilopezluna.japanathome.resources;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.ilopezluna.japanathome.authenticators.BasicAuthenticator;
import com.ilopezluna.japanathome.entities.User;
import com.ilopezluna.japanathome.services.GenericDAO;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import static com.ilopezluna.japanathome.utils.Constants.USER_URI;

@Singleton
@Path( USER_URI )
@Produces( MediaType.APPLICATION_JSON )
public class UserResource extends AbstractResource<User> {

	@Inject
	public UserResource(GenericDAO<User> dao, BasicAuthenticator authenticator) {
		super(dao);
	}
}
