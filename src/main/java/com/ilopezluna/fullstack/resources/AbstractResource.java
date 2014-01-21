package com.ilopezluna.fullstack.resources;

import com.ilopezluna.fullstack.entities.Basic;
import com.ilopezluna.fullstack.entities.User;
import com.ilopezluna.fullstack.services.GenericDAO;
import com.yammer.dropwizard.auth.Auth;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;

import static com.ilopezluna.fullstack.utils.Constants.PATH_ID;
import static com.ilopezluna.fullstack.utils.Constants.PATH_ID_PARAM;

public abstract  class AbstractResource  <T extends Basic> {

	protected final GenericDAO<T> dao;

	public AbstractResource( GenericDAO<T> dao )
	{
		this.dao = dao;
	}

	@GET
	@Path( PATH_ID )
	public T fetch( @PathParam( PATH_ID_PARAM) String id )
	{
		return dao.fetch( id );
	}

	@GET
	public Collection<T> fetchAll()
	{
		return dao.fetchAll();
	}

	@POST
	@Consumes( MediaType.APPLICATION_JSON )
	public T save( T basic )
	{
		return dao.saveOrUpdate(basic);
	}

	@POST
	@Path( PATH_ID )
	@Consumes( MediaType.APPLICATION_JSON )
	public T update( @Auth(required = false) User user, @PathParam(PATH_ID_PARAM) String id, T basic )
	{
		if (user == null)
			System.out.println("User isn't authenticated");
		return dao.saveOrUpdate( basic );
	}

	@DELETE
	@Path( PATH_ID )
	public Response delete(@PathParam(PATH_ID_PARAM) String id)
	{
		dao.remove( id );
		return Response.ok().build();
	}

}
