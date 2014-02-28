package com.ilopezluna.japanathome.resources;

import com.ilopezluna.japanathome.entities.Basic;
import com.ilopezluna.japanathome.entities.User;
import com.ilopezluna.japanathome.exceptions.ValidationException;
import com.ilopezluna.japanathome.services.GenericDAO;
import com.yammer.dropwizard.auth.Auth;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;

import static com.ilopezluna.japanathome.utils.Constants.PATH_ID;
import static com.ilopezluna.japanathome.utils.Constants.PATH_ID_PARAM;

public abstract class AbstractResource  <T extends Basic> {

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
		try
		{
			return dao.saveOrUpdate(basic);
		}
		catch (ValidationException e)
		{
			throw new RuntimeException( e.getMessage() );
		}
	}

	@POST
	@Path( PATH_ID )
	@Consumes( MediaType.APPLICATION_JSON )
	public T update( @PathParam(PATH_ID_PARAM) String id, T basic )
	{
		try
		{
			return dao.saveOrUpdate(basic);
		}
		catch (ValidationException e)
		{
			throw new RuntimeException( e.getMessage() );
		}
	}

	@DELETE
	@Path( PATH_ID )
	public Response delete(@Auth User user, @PathParam(PATH_ID_PARAM) String id)
	{
		dao.remove( id );
		return Response.ok().build();
	}

}
