package com.ilopezluna.fullstack.resources;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.ilopezluna.fullstack.entities.User;
import com.ilopezluna.fullstack.services.UserService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;

import static com.ilopezluna.fullstack.utils.Constants.*;

@Singleton
@Path( USER_URI )
@Produces( MediaType.APPLICATION_JSON )
public class UserResource
{
	private final UserService userService;

	@Inject
	public UserResource( UserService userService )
	{
		this.userService = userService;
	}

	@GET
	public Collection<User> fetchAll()
	{
		return userService.fetchAll();
	}

	@GET
	@Path( PATH_ID )
	public User fetch( @PathParam( PATH_ID_PARAM ) String id )
	{
		return userService.fetch( id );
	}

	@POST
	@Consumes( MediaType.APPLICATION_JSON )
	public User create(User user)
	{
		return userService.saveOrUpdate( user );
	}

	@POST
	@Path( PATH_ID )
	public User update( @PathParam( PATH_ID_PARAM ) String id, User user )
	{
		return userService.saveOrUpdate(user);
	}

	@DELETE
	@Path( PATH_ID )
	public Response delete( @PathParam( PATH_ID_PARAM ) String id )
	{
		userService.remove(id);
		return Response.ok().build();
	}
}
