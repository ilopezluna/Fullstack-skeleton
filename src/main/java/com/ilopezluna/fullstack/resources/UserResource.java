package com.ilopezluna.fullstack.resources;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.ilopezluna.fullstack.entities.User;
import com.ilopezluna.fullstack.services.GenericDAO;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import static com.ilopezluna.fullstack.utils.Constants.USER_URI;

@Singleton
@Path( USER_URI )
@Produces( MediaType.APPLICATION_JSON )
public class UserResource extends AbstractResource<User> {

	@Inject
	public UserResource(GenericDAO<User> dao) {
		super(dao);
	}
}
