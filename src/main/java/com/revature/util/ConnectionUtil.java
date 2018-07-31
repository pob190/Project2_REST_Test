package com.revature.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class ConnectionUtil {
	private static SessionFactory sessionFactory;

	static {
		System.out.println("Creating Session");
		Configuration config = new Configuration();
		config.configure();
		StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder()
				.applySettings(config.getProperties());
		sessionFactory = config.buildSessionFactory(ssrb.build());
	}

	public static Session getSession() {
		System.out.println("Getting Session");
		return sessionFactory.openSession();

	}

	public static void closeFactory() {

		sessionFactory.close();

	}
}