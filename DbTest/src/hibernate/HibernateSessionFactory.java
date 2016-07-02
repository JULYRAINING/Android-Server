package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {

	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory(){
		if(sessionFactory==null){
			Configuration config = new Configuration().configure();
			sessionFactory = config.buildSessionFactory();
			return sessionFactory;
		}else{
			return sessionFactory;
		}
	
		
	}
	public static Session getSession(){
		return getSessionFactory().getCurrentSession();
	}	
}
