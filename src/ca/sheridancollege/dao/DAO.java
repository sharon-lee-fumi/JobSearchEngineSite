package ca.sheridancollege.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ca.sheridancollege.beans.Employer;

public class DAO {
	
	SessionFactory sessionFactory = new Configuration()
			.configure("ca/sheridancollege/config/hibernate.cfg.xml")
			.buildSessionFactory();
	
	public DAO()
	{
		super();
	}

	public void saveEmployer(Employer employer) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.saveOrUpdate(employer);
		
		session.getTransaction().commit();
		session.close();
		
	}

	
	public List<Employer> getEmployerList() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Query query = session.createNamedQuery("Employer.getEmployerList");
		List<Employer> employerList = query.getResultList();
		
		session.getTransaction().commit();
		session.close();
		
		return employerList;
		
	}
	
	public List<Employer> getEmployer(Long id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Query query = session.createNamedQuery("Employer.getEmployer");
		query.setParameter("id", id);
		List<Employer> employerList = query.getResultList();
		
		session.getTransaction().commit();
		session.close();
		
		return employerList;
		
	}
	
	public void deleteEmployer(Long id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Employer toDelete = session.get(Employer.class, id);
		session.delete(toDelete);
		
		session.getTransaction().commit();
		session.close();

	}
	
	public Employer getEmployerById(Long id) {
		return (Employer) sessionFactory.openSession()
				.getNamedQuery("Employer.getEmployerById")
				.setParameter("id", id)
				.getSingleResult();
		}
	
	public List<Employer> searchItemList(String word) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Query query = session.createNamedQuery("Employer.searchItemList");
		query.setParameter("word", "%" + word + "%");
		List<Employer> itemList = query.getResultList();
		
		session.getTransaction().commit();
		session.close();
		
		return itemList;
	}
}
