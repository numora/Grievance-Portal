package testing;


import java.util.Date;

import org.hibernate.Session;

import com.grievance.web.healthcare.newmodel.Address;
import com.grievance.web.healthcare.newmodel.User;

public class TestCode {
	public static void main(String[] args) {
		 
        System.out.println("Hibernate one to one (Annotation)");
	Session session = HibernateUtil.buildSessionFactory().openSession();
 
	session.beginTransaction();
 
	Address address = new Address();
	address.setAddress_id(3);
	address.setAddress_line_1("4425 Bidwell Dr");
	address.setAddress_line_2("APT 6112");
	address.setCity("Fremont");
	address.setPo_box("94538");
	address.setState("CA");
	address.setZip("94538");
	session.save(address);
 
    User user = new User();
    user.setUser_id(1000);
    user.setEmail_id("rarumalla@nisum.com");
    user.setPassword("hellork");
    user.setCreated_date(new Date());
    user.setLast_modified_date(new Date());
    user.setLogin_name("rarumalla");
    user.setLanguage("English");
    user.setRole_id(1);
    user.setVerified(0);
    user.setAddress(address);    

    session.save(user);
 
	session.getTransaction().commit();
	System.out.println("Done");
	}
}
