package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {

	private static SessionFactory factory;

	private HibernateUtility(){
		configurar();
	}
	
	private void configurar(){
		
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Session getSession() {
		
		if(factory == null){
			new HibernateUtility();
		}
		return factory.openSession();
	}

}
