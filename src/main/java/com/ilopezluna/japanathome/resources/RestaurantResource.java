package com.ilopezluna.japanathome.resources;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.ilopezluna.japanathome.entities.Restaurant;
import com.ilopezluna.japanathome.services.GenericDAO;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import static com.ilopezluna.japanathome.utils.Constants.ELEMENT_URI;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Singleton
@Path( ELEMENT_URI )
@Produces( APPLICATION_JSON )
public class RestaurantResource extends AbstractResource<Restaurant>
{

	@Inject
	public RestaurantResource(GenericDAO<Restaurant> dao) {
		super(dao);
	}
}

