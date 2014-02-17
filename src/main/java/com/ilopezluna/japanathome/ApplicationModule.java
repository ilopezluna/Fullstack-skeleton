package com.ilopezluna.japanathome;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import com.ilopezluna.japanathome.authenticators.BasicAuthenticator;
import com.ilopezluna.japanathome.configurations.ApplicationConfiguration;
import com.ilopezluna.japanathome.configurations.MongoConfiguration;
import com.ilopezluna.japanathome.entities.Element;
import com.ilopezluna.japanathome.entities.Subscriber;
import com.ilopezluna.japanathome.entities.User;
import com.ilopezluna.japanathome.services.GenericDAO;
import com.ilopezluna.japanathome.services.UserService;
import com.ilopezluna.japanathome.services.UserServiceImpl;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.yammer.dropwizard.auth.basic.BasicAuthProvider;
import com.yammer.dropwizard.config.Configuration;
import org.jongo.Jongo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.net.UnknownHostException;
import java.util.Properties;

public class ApplicationModule extends AbstractModule
{
	private static final Logger logger = LoggerFactory.getLogger(ApplicationModule.class);

	@Override
	protected void configure()
	{
		bind(UserService.class).to(UserServiceImpl.class);
	}

	@Provides
	@Singleton
	public ApplicationConfiguration configuration()
	{
		return new ApplicationConfiguration();
	}

	@Provides
	@Singleton
	public Jongo provideJongo(Configuration configuration)
	{
		MongoConfiguration mongoConfiguration = ( ( ApplicationConfiguration ) configuration ).getMongo();
		MongoClient mongoClient = null;
		try
		{
			mongoClient = new MongoClient( mongoConfiguration.getUri(), mongoConfiguration.getPort() );
		}
		catch (UnknownHostException e)
		{
			logger.error( e.getMessage(), e );
		}

		DB db = mongoClient.getDB( mongoConfiguration.getDatabase() );
		if ( !db.authenticate(mongoConfiguration.getUsername(), mongoConfiguration.getPassword().toCharArray()) )
		{
//			throw new RuntimeException("Authentication error!");
		}

		return new Jongo(db);
	}

	@Provides
	@Singleton
	public GenericDAO<Element> ElementDAO(Jongo jongo) {
		return new GenericDAO<Element>( jongo, Element.class, Element.COLLECTION_NAME );
	}

	@Provides
	@Singleton
	public GenericDAO<Subscriber> SubscriberDAO(Jongo jongo) {
		return new GenericDAO<Subscriber>( jongo, Subscriber.class, Subscriber.COLLECTION_NAME );
	}

	@Provides
	@Singleton
	public GenericDAO<User> UserDAO(Jongo jongo) {
		return new GenericDAO<User>( jongo, User.class, User.COLLECTION_NAME );
	}


	@Provides
	@Singleton
	public Properties provideProperties()
	{
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		return props;
	}

	@Provides
	@Singleton
	public BasicAuthProvider<User> basicAuthProvider(UserService userService)
	{
		return new BasicAuthProvider<User>(new BasicAuthenticator(userService),"realm");
	}

	@Provides
	@Singleton
	public Session provideMailSession(Configuration configuration, Properties properties)
	{
		final String username = ( (ApplicationConfiguration) configuration ).getMail().getUsername();
		final String password = ( (ApplicationConfiguration) configuration ).getMail().getPassword();

		Session session = Session.getInstance( properties,

				new javax.mail.Authenticator()
				{
					protected PasswordAuthentication getPasswordAuthentication()
					{
						return new PasswordAuthentication( username, password );
					}
				}
		);

		return session;
	}

	@Provides
	@Named("AWS_ACCESS_KEY")
	public String provideAWSAccessKey(Configuration configuration)
	{
		return ( (ApplicationConfiguration) configuration ).getAws().getAccessKey();
	}

	@Provides
	@Named("AWS_SECRET_KEY")
	public String provideAWSSecretKey(Configuration configuration)
	{
		return ( (ApplicationConfiguration) configuration ).getAws().getSecretKey();
	}

	@Provides
	@Named("IMAGES_BUCKET")
	public String provideImagesBucket(Configuration configuration)
	{
		return ( (ApplicationConfiguration) configuration ).getAws().getImagesBucket();
	}

	@Provides
	@Named("EMAIL")
	public String provideEmail(Configuration configuration)
	{
		return ( (ApplicationConfiguration) configuration ).getMail().getEmail();
	}

}
