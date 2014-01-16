package com.ilopezluna.fullstack.services;

import com.ilopezluna.fullstack.entities.User;

import java.io.InputStream;
import java.util.Collection;

public interface UserService
{
	Collection<User> fetchAll();

	User saveOrUpdate(User user);

	User fetch(String id);

	void remove(String id);

	void addImage(User user, InputStream uploadedInputStream);
}
