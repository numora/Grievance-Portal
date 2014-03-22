package testing;
 
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.grievance.web.healthcare.newmodel.Address;
import com.grievance.web.healthcare.newmodel.User;
 
public class HibernateUtil {
 
	private static final SessionFactory sessionFactory =null;
 
	public static SessionFactory buildSessionFactory() {
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			
			SessionFactory sessionFactory = new AnnotationConfiguration().addPackage("com.grievance.web.healthcare.newmodel").addAnnotatedClass(User.class).addAnnotatedClass(Address.class).configure().buildSessionFactory();
			return sessionFactory;
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
 
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
 
	public static void shutdown() {
		// Close caches and connection pools
		getSessionFactory().close();
	}
 
}