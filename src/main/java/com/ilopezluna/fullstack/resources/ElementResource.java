package com.ilopezluna.fullstack.resources;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.ilopezluna.fullstack.entities.Element;
import com.ilopezluna.fullstack.services.ElementService;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.Collection;

import static com.ilopezluna.fullstack.utils.Constants.*;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Singleton
@Path( ELEMENT_URI )
@Produces( APPLICATION_JSON )
public class ElementResource
{
	private final ElementService elementService;

	@Inject
	public ElementResource(ElementService elementService)
	{
		this.elementService = elementService;
	}

	@GET
	public Collection<Element> fetchAll()
	{
		return elementService.fetchAll();
	}

	@GET
	@Path( PATH_ID )
	public Element fetch( @PathParam( PATH_ID_PARAM ) String id )
	{
		return elementService.fetch( id );
	}

	@POST
	@Consumes( APPLICATION_JSON )
	public Element create(Element element)
	{
		return elementService.saveOrUpdate( element );
	}

	@POST
	public Element save( Element element )
	{
		return elementService.saveOrUpdate( element );
	}

	@POST
	@Path( PATH_ID )
	public Element update( Element element )
	{
		return save( element );
	}

	@DELETE
	@Path( PATH_ID )
	public Response delete( @PathParam( PATH_ID_PARAM ) String id )
	{
		elementService.remove(id);
		return Response.ok().build();
	}

}

