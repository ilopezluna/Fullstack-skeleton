package com.ilopezluna.japanathome.resources;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.ilopezluna.japanathome.entities.Subscriber;
import com.ilopezluna.japanathome.services.GenericDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;

import static com.ilopezluna.japanathome.utils.Constants.SUBSCRIBER_URI;
import static com.ilopezluna.japanathome.utils.Validators.isValidEmailAddress;

@Singleton
@Path( SUBSCRIBER_URI )
@Produces( MediaType.APPLICATION_JSON )
public class SubscriberResource  {

	private final GenericDAO<Subscriber> dao;

	@Inject
	public SubscriberResource(GenericDAO<Subscriber> dao) {

		this.dao = dao;
	}

	@GET
	public Collection<Subscriber> fetchAll()
	{
		return dao.fetchAll();
	}

	@POST
	@Consumes( MediaType.APPLICATION_JSON )
	public Response save(Subscriber subscriber) {
		String email = subscriber.getEmail();
		if ( isValidEmailAddress(email) ) {
			dao.saveOrUpdate(subscriber);
			return Response.ok().header("Access-Control-Allow-Origin", "*").build();
		}
		else  {
			return Response.status(Response.Status.PRECONDITION_FAILED).build();
		}
	}

}
