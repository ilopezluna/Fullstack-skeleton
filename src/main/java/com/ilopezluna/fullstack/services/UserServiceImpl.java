package com.ilopezluna.fullstack.services;

import com.google.inject.Inject;
import com.ilopezluna.fullstack.entities.User;
import org.bson.types.ObjectId;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.Collection;
import java.util.HashSet;

import static org.jongo.Oid.withOid;

public class UserServiceImpl implements UserService
{
	private final Logger logger = LoggerFactory.getLogger( UserServiceImpl.class );

	private final MongoCollection collection;

	@Inject
	public UserServiceImpl(Jongo jongo)
	{
		collection = jongo.getCollection(User.COLLECTION_NAME);
	}

	@Override
	public Collection<User> fetchAll()
	{
		Collection<User> result = new HashSet<User>();

		Iterable<User> users = collection.find().as(User.class);
		for ( User user : users )
		{
			result.add( user );
		}

		return result;
	}

	@Override
	public User saveOrUpdate(User user)
	{
		collection.save(user); //id has been set in user
		return user;
	}

	@Override
	public User fetch(String id)
	{
		return collection.findOne( withOid(id) ).as(User.class);
	}

	@Override
	public void remove(String id)
	{
		collection.remove( new ObjectId( id ) );
	}

	@Override
	public void addImage(User user, InputStream uploadedInputStream) {
		//To change body of implemented methods use File | Settings | File Templates.
	}
}
