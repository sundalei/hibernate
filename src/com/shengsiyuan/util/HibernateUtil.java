package com.shengsiyuan.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	
	static {
		try {
			//sessionFactory = new Configuration().configure().buildSessionFactory();
			// http://stackoverflow.com/questions/8621906/is-buildsessionfactory-deprecated-in-hibernate-4
			Configuration configuration = new Configuration();
		    configuration.configure();
		    ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
		            configuration.getProperties()). buildServiceRegistry();
		    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	public static Session openSession() {
		Session session = sessionFactory.openSession();
		return session;
	}
	
	public static void close(Session session) {
		if(null != session) {
			session.close();
		}
	}
}
