package org.vermeg.bookstore.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.vermeg.bookstore.model.LignePanier;
import org.vermeg.bookstore.model.Utilisateur;

@Repository
public class LignePanierDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<LignePanier> getAllLignePanier(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		List<LignePanier> lpList = session.createQuery("from LignePanier where code = '" + id +"'" ).list();
		
		for (LignePanier lp:lpList) {
			System.out.print(lp.toString());
		}
		
		return lpList;
	}

	public LignePanier getLignePanier(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		LignePanier lp = (LignePanier) session.get(LignePanier.class, new Integer(id));
		return lp;
	}

	public LignePanier addLignePanier(LignePanier lp) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(lp);
		return lp;
	}

	public void updateLignePanier(LignePanier lp) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(lp);
	}

	public void deleteLignePanier(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		LignePanier lp = (LignePanier) session.load(LignePanier.class, new Integer(id));
		if (null != lp) {
			session.delete(lp);
		}
	}	
}
