package com.ilopezluna.japanathome;

import com.hubspot.dropwizard.guice.GuiceBundle;
import com.ilopezluna.japanathome.authenticators.BasicAuthenticator;
import com.ilopezluna.japanathome.configurations.ApplicationConfiguration;
import com.ilopezluna.japanathome.entities.User;
import com.ilopezluna.japanathome.services.UserService;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.assets.AssetsBundle;
import com.yammer.dropwizard.auth.basic.BasicAuthProvider;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

public class ApplicationService extends Service<ApplicationConfiguration>
{
	private GuiceBundle guiceBundle;

	public static void main(String[] args) throws Exception
	{
		new ApplicationService().run(args);
	}

	@Override
	public void initialize(Bootstrap<ApplicationConfiguration> bootstrap)
	{
		bootstrap.setName("Japan At home!");
		bootstrap.addBundle(new AssetsBundle("/landing-page/","/","index.html"));
		bootstrap.addBundle(new AssetsBundle("/frontend/","/frontend","index.html"));

		guiceBundle = GuiceBundle.newBuilder()
				.addModule(new ApplicationModule())
				.enableAutoConfig(getClass().getPackage().getName())
				.build();
		bootstrap.addBundle(guiceBundle);
	}

	@Override
	public void run(ApplicationConfiguration configuration, Environment environment) throws Exception
	{
		final UserService userService = guiceBundle.getInjector().getInstance(UserService.class);
		environment.addProvider(new BasicAuthProvider<User>(
				new BasicAuthenticator(userService),"BasicUser")
		);
	}

}

