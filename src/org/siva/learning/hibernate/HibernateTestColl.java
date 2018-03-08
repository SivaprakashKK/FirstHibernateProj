package org.siva.learning.hibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.siva.learning.dto.Address;
import org.siva.learning.dto.UserDetailsColl;
import org.siva.learning.dto.Vehicle;

public class HibernateTestColl {
	public static void main(String[] args) {
		UserDetailsColl user = new UserDetailsColl();
		Address addr = new Address();
		Address addr2 = new Address();
		
		Vehicle vehicle = new Vehicle();
		Vehicle vehicle2 = new Vehicle();
		vehicle.setVehicleName("Car");
		vehicle2.setVehicleName("Bike");
		
		addr.setStreet("First street");
		addr.setCity("First city");
		addr.setPincode("First pincode");
		addr.setState("First state");
		
		addr2.setStreet("Second street");
		addr2.setCity("Second  city");
		addr2.setPincode("Second  pincode");
		addr2.setState("Second state");
		
		user.setUserName("First Name");
//		user.getListOfAddresses().add(addr);
//		user.getListOfAddresses().add(addr2);
		
		//One to one
		user.setVehicle(vehicle);
		
		//One to many
		user.getVehicles().add(vehicle);
		user.getVehicles().add(vehicle2);

		//Many to one - Adding a user to a vehicle
		vehicle.setUser(user);
		vehicle2.setUser(user);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.save(vehicle);
		session.save(vehicle2);
		session.getTransaction().commit();
		
		session.close();
	
	/*	// Retrieval of collection
		user = null;
		
		session = sessionFactory.openSession();
		user = (UserDetailsColl)session.get(UserDetailsColl.class, 1);
		System.out.println(user);
		System.out.println(user.getListOfAddresses());*/
	}

}
