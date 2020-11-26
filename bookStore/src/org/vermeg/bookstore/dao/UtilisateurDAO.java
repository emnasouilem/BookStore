package org.vermeg.bookstore.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.vermeg.bookstore.model.Livre;
import org.vermeg.bookstore.model.Utilisateur;

@Repository
public class UtilisateurDAO {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public List<Utilisateur> getAllUsers() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Utilisateur> userList = session.createQuery("from Utilisateur").list();
		
		for (Utilisateur u:userList) {
			System.out.print(u.toString());
		}
		
		return userList;
	}
	
	public Utilisateur getUser(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Utilisateur user = (Utilisateur) session.get(Utilisateur.class, new Integer(id));
		return user;
	}

	public Utilisateur addUser(Utilisateur user) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(user);
		return user;
	}

	public void updateUser(Utilisateur user) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(user);
	}

	public void deleteUser(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Utilisateur p = (Utilisateur) session.load(Utilisateur.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
	}	
}

