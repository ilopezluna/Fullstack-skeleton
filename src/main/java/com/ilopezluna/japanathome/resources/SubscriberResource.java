package com.ilopezluna.japanathome.resources;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.ilopezluna.japanathome.entities.Subscriber;
import com.ilopezluna.japanathome.services.GenericDAO;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static com.ilopezluna.japanathome.utils.Constants.PATH_ID_PARAM;
import static com.ilopezluna.japanathome.utils.Constants.SUBSCRIBER_URI;
import static com.ilopezluna.japanathome.utils.Validators.isValidEmailAddress;

@Singleton
@Path( SUBSCRIBER_URI )
@Produces( MediaType.APPLICATION_JSON )
public class SubscriberResource extends AbstractResource<Subscriber> {

	@Inject
	public SubscriberResource(GenericDAO<Subscriber> dao) {
		super(dao);
	}

	@Override
	public Subscriber fetch(@PathParam(PATH_ID_PARAM) String id) {
		return null;
	}

	@Override
	public Subscriber save(Subscriber subscriber) {
		String email = subscriber.getEmail();
		if ( isValidEmailAddress(email) ) {
			return super.save(subscriber);
		}
		else {
			throw new RuntimeException("Invalid email");
		}
	}

	@Override
	public Response delete(@PathParam(PATH_ID_PARAM) String id) {
		return Response.ok().build();
	}
}
