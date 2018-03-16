package org.siva.learning.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.siva.learning.dto.FourWheeler;
import org.siva.learning.dto.TwoWheeler;
import org.siva.learning.dto.VehicleInh;

public class HibernateTestInh {

	public static void main(String[] args) {

		VehicleInh vehicle = new VehicleInh();
		vehicle.setVehicleName("Car");

		TwoWheeler bike = new TwoWheeler();
		bike.setVehicleName("Bike");
		bike.setSteeringHandle("steeringHandle");

		FourWheeler car = new FourWheeler();
		car.setVehicleName("Porsche");
		car.setSteeringWheel("steeringWheel");

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(vehicle);
		session.save(car);
		session.save(bike);

		session.getTransaction().commit();

	}
}
