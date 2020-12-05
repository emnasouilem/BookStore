package org.vermeg.bookstore.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.vermeg.bookstore.model.Livre;
import org.vermeg.bookstore.model.Panier;

@Repository
public class PanierDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public List<Panier> getAllPanier(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Panier> panierList = session.createQuery("from Panier where numU="+id).list();
		
		for (Panier p:panierList) {
			System.out.println(p.toString());
		}
		
		return panierList;
	}

	public Panier getPanier(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Panier panier = (Panier) session.get(Panier.class, new Integer(id));
		return panier;
	}

	public Panier addPanier(Panier panier) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(panier);
		return panier;
	}

	public void updatePanier(Panier panier) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(panier);
	}

	public void deletePanier(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Panier p = (Panier) session.load(Panier.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
	}	
	
}
