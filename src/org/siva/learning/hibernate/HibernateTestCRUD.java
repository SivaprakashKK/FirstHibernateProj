package org.siva.learning.hibernate;

import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.siva.learning.dto.UserDetailsCRUD;

public class HibernateTestCRUD {

	static List<UserDetailsCRUD> user;
	
	public static void main(String[] args) {
			
		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		
		// Explains the crud operation, Criteria, Projections and QueryByExample
		//crudOperation(session);

		//UserDetailsCRUD user1 =  (UserDetailsCRUD)session.get(UserDetailsCRUD.class,1);
		Query query =  session.createQuery("from UserDetailsCRUD user where userId = 1");
		query.setCacheable(true);
		List user =  query.list();
		
		
		session.getTransaction().commit();
		session.close();
		
		System.out.println("The user " + user.size());
		
		
		//Second level cache
		Session session2 = sessionFactory.openSession();
		session2.beginTransaction();
		
		//UserDetailsCRUD user2 =  (UserDetailsCRUD)session2.get(UserDetailsCRUD.class,1);
		
		Query query2 =  session2.createQuery("from UserDetailsCRUD user where userId = 1");
		query2.setCacheable(true);
		List user2 =  query2.list();
		
		session2.getTransaction().commit();
		session2.close();
		
		
		
		// Printing the list of users
//		for (UserDetailsCRUD userDetailsCRUD : user) {
//			System.out.println(userDetailsCRUD.getUserId() + "  Usernames " + userDetailsCRUD.getUserName());
//		}
		
	}

	private static void crudOperation(Session session) {
		/*	
		Query query =  session.createQuery("from UserDetailsCRUD where userId > 0");
		query.setFirstResult(3);
		query.setMaxResults(4);
*/
		
/*		Query query = session.getNamedQuery("UserDetails.byId");
		query.setInteger(0, 2);*/
/*		
		Query query = session.getNamedQuery("UserDetails.byName");
		query.setString(0,"User1");
*/
				
//		Criteria criteria = session.createCriteria(UserDetailsCRUD.class);
//		criteria.add(Restrictions.like("userName","User%"))
//				.add(Restrictions.gt("userId", 5));
		
/*		
		//Using or statement
		criteria.add(Restrictions.or(Restrictions.between("userId", 1, 3),Restrictions.between("userId", 7, 10)));
*/		
		
		// Example API
		UserDetailsCRUD exampleUser = new UserDetailsCRUD();
		//exampleUser.setUserId(4);
		exampleUser.setUserName("User%");
		
		Example example = Example.create(exampleUser).enableLike();
				
		// Projections
		Criteria criteria = session.createCriteria(UserDetailsCRUD.class)
							.add(example);
							//.setProjection(Projections.avg("userId"));
							//.addOrder(Order.desc("userName"));
		
		// Replace query and criteria with each other - save the persisted object
		user =  (List<UserDetailsCRUD>)criteria.list();
		//System.out.println("the user count from query is "+ user.size());
		//System.out.println(user.get(0));
		
		
		

/*
		// Insert
		for (int i = 0; i < 10; i++) {
			UserDetailsCRUD user = new UserDetailsCRUD();
			user.setUserName("User" + i);
			session.save(user);
		}
*/		
/*		
		// Fetch & Delete
		UserDetailsCRUD user = (UserDetailsCRUD) session.get(UserDetailsCRUD.class, 6);
		System.out.println("User name is  " +user.getUserName());
		session.delete(user);
*/		
/*		
		// Update
		UserDetailsCRUD user = (UserDetailsCRUD) session.get(UserDetailsCRUD.class, 5);
		user.setUserName("Updated userName");
		session.update(user);
*/		
		
	}

}
 