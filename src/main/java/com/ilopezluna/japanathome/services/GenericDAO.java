package com.ilopezluna.japanathome.services;

import com.google.inject.Inject;
import com.ilopezluna.japanathome.entities.Basic;
import org.bson.types.ObjectId;
import org.jongo.Jongo;
import org.jongo.MongoCollection;

import java.util.Collection;
import java.util.HashSet;

public class GenericDAO <T extends Basic> {

	private final Class<T> clazz;

	private final MongoCollection collection;

	@Inject
	public GenericDAO (Jongo jongo, Class<T> clazz, String collection) {
		this.clazz = clazz;
		this.collection = jongo.getCollection(collection);
	}

	public Collection<T> fetchAll() {
		Collection<T> result = new HashSet<T>();
		Iterable<T> iterable = collection.find().as( clazz ); //Why an iterator?
		for (T basic : iterable)
		{
			result.add( basic );
		}
		return result;
	}

	public T saveOrUpdate( T basic ) {
		collection.save( basic );
		return basic;
	}

	public T fetch(String id) {
		return collection.findOne( new ObjectId( id ) ).as( clazz );
	}

	public void remove(String id) {
		collection.remove( new ObjectId( id ) );
	}



}
