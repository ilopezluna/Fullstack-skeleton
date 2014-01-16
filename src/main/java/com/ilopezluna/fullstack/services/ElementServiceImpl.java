package com.ilopezluna.fullstack.services;

import com.google.inject.Inject;
import com.ilopezluna.fullstack.entities.Element;
import org.bson.types.ObjectId;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.HashSet;

public class ElementServiceImpl implements ElementService {

	private final Logger logger = LoggerFactory.getLogger(ElementServiceImpl.class);

	private final MongoCollection collection;

	@Inject
	public ElementServiceImpl(Jongo jongo)
	{
		this.collection = jongo.getCollection( Element.COLLECTION_NAME );
	}

	@Inject

	@Override
	public Collection<Element> fetchAll() {
		Collection<Element> result = new HashSet<Element>();

		Iterable<Element> elements = collection.find().as( Element.class );
		for ( Element element : elements ) {
			result.add( element );
		}
		return result;
	}

	@Override
	public Element saveOrUpdate(Element element) {
		collection.save(element);
		return element;
	}

	@Override
	public Element fetch(String id) {
		return collection.findOne( new ObjectId( id ) ).as( Element.class );
	}

	@Override
	public void remove(String id) {
		collection.remove( new ObjectId( id ) );
	}
}
