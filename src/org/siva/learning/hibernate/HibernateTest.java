package org.siva.learning.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.siva.learning.dto.Address;
import org.siva.learning.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {

		UserDetails user = new UserDetails();
		UserDetails user2 = new UserDetails();
		Address addr = new Address();
		Address addr2 = new Address();
		
		//user.setUserId(1);
		user.setUserName("First Users");
		//user.setAddress("address");
		
		addr.setStreet("street");
		addr.setCity("city");
		addr.setPincode("pincode");
		addr.setState("state");
		
		addr2.setStreet("office street");
		addr2.setCity("office  city");
		addr2.setPincode("office  pincode");
		addr2.setState("office state");
		
		user.setAddress(addr);
		user.setOfficeAddress(addr2);
		user.setJoinedDate(new Date());
		user.setDescription("Description goes here");
		
		user2.setUserName("userName2");
		
		// Configure the Hibernate to create the session factory
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		// Create a Session object
		Session session  = sessionFactory.openSession();
	
		// Save the model object
		
		// Begin the transaction
		session.beginTransaction();
		session.save(user); //save
		session.save(user2);
		
		session.getTransaction().commit(); //Commit
		
		// Close the session -  Always at finally
		session.close();
		
		//Retrieval of data
		user = null;
		
		session =  sessionFactory.openSession();
		user = (UserDetails)session.get(UserDetails.class, 1);
		System.out.println(user.getUserId() +" with name " + user.getUserName());

		

	}

}
