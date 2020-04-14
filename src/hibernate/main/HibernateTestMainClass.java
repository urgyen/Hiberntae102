package hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.model.Address;
import hibernate.model.UserDetails;

public class HibernateTestMainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		UserDetails u1= new UserDetails();
		u1.setUser_id(1);
		u1.setUser_name("Urgyen");
		
		Address address1= new Address();
		address1.setCity("BKT");
		address1.setCountry("Nepal");
		address1.setPincode("4800");
		address1.setState("Bagmati");
		address1.setStreet_name("Inacho");
		
		Address address2= new Address();
		address2.setCity("Pkr");
		address2.setCountry("Nepal");
		address2.setPincode("44700");
		address2.setState("Gandaki");
		address2.setStreet_name("Pritivi Road");
		
		u1.getListOfAddresses().add(address2);
		u1.getListOfAddresses().add(address1);
			
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Session session= sessionFactory.openSession();
		session.beginTransaction();
		session.save(u1);
		session.getTransaction().commit();
		
		u1= null;
		session= sessionFactory.openSession();
		u1= (UserDetails) session.get(UserDetails.class, 1);
		u1.getListOfAddresses();
		
		
	}

}
