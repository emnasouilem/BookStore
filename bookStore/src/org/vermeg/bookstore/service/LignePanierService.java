package org.vermeg.bookstore.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vermeg.bookstore.dao.LignePanierDAO;
import org.vermeg.bookstore.model.LignePanier;
import org.vermeg.bookstore.model.Panier;

@Service("LignePanierService")
public class LignePanierService {

	@Autowired
	LignePanierDAO lignepanierDAO;
	
	@Transactional
	public List<LignePanier> getAllLignePanier(int id) {
		return lignepanierDAO.getAllLignePanier(id);
	}

	@Transactional
	public LignePanier getPanier(int id) {
		return lignepanierDAO.getLignePanier(id);
	}

	@Transactional
	public void addLignePanier(LignePanier lpanier) {
		lignepanierDAO.addLignePanier(lpanier);
	}

	@Transactional
	public void updateLignePanier(LignePanier lpanier) {
		lignepanierDAO.updateLignePanier(lpanier);

	}

	@Transactional
	public void deleteLignePanier (int id) {
	lignepanierDAO.deleteLignePanier(id);
}
	@Transactional
	public double calculLignePanier (List<LignePanier> lpanier) {
		double s=0;
		int i=0;
		do {
			s=s+lpanier.get(i).getTotal();
			i++;
		}while (i< lpanier.size());
		return s;
		

	
}

}


