package com.ilopezluna.japanathome.services;

import com.google.inject.Inject;
import com.ilopezluna.japanathome.entities.User;
import com.yammer.dropwizard.auth.basic.BasicCredentials;
import org.jongo.Jongo;
import org.jongo.MongoCollection;

public class UserServiceImpl implements UserService {

	private final MongoCollection collection;
	@Inject
	public UserServiceImpl(Jongo jongo)
	{
		this.collection = jongo.getCollection( User.COLLECTION_NAME );
	}

	@Override
	public User getFromCredentials(BasicCredentials credentials)
	{
		return collection.findOne("" +
				"{name: '" + credentials.getUsername() + "'}, " +
				"{password: '" + credentials.getPassword() + "'}")
				.as(User.class);
	}

	@Override
	public boolean isAdmin(User user) {
		return true;
	}
}
