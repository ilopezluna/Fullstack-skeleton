package com.ilopezluna.fullstack.resources;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.ilopezluna.fullstack.entities.Element;
import com.ilopezluna.fullstack.services.GenericDAO;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import static com.ilopezluna.fullstack.utils.Constants.ELEMENT_URI;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Singleton
@Path( ELEMENT_URI )
@Produces( APPLICATION_JSON )
public class ElementResource extends AbstractResource<Element>
{

	@Inject
	public ElementResource(GenericDAO<Element> dao) {
		super(dao);
	}
}

