package org.vermeg.bookstore.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vermeg.bookstore.dao.PanierDAO;
import org.vermeg.bookstore.model.Livre;
import org.vermeg.bookstore.model.Panier;

@Service("PanierService")
public class PanierService {
	@Autowired
	PanierDAO panierDAO;
	
	@Transactional
	public List<Panier> getAllPanier(int id) {
		return panierDAO.getAllPanier(id);
	}

	@Transactional
	public Panier getPanier(int id) {
		return panierDAO.getPanier(id);
	}

	@Transactional
	public void addPanier(Panier panier) {
		panierDAO.addPanier(panier);
	}

	@Transactional
	public void updatePanier(Panier panier) {
		panierDAO.updatePanier(panier);

	}

	@Transactional
	public void deletePanier(int id) {
	panierDAO.deletePanier(id);
}

}
