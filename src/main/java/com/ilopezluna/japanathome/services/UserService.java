package com.ilopezluna.japanathome.services;

import com.ilopezluna.japanathome.entities.User;
import com.yammer.dropwizard.auth.basic.BasicCredentials;

public interface UserService {

	User getFromCredentials(BasicCredentials credentials);

	boolean isAdmin(User user);
}
