package com.ilopezluna.japanathome.resources;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.ilopezluna.japanathome.entities.Role;
import com.ilopezluna.japanathome.services.GenericDAO;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import static com.ilopezluna.japanathome.utils.Constants.ROLE_URI;

@Singleton
@Path( ROLE_URI )
@Produces( MediaType.APPLICATION_JSON )
public class RoleResource extends AbstractResource<Role> {

	@Inject
	public RoleResource(GenericDAO<Role> dao) {
		super(dao);
	}
}
