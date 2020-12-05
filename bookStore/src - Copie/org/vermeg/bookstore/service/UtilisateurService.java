package org.vermeg.bookstore.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vermeg.bookstore.dao.UtilisateurDAO;
import org.vermeg.bookstore.model.Livre;
import org.vermeg.bookstore.model.Utilisateur;

@Service("UtilisateurService")
public class UtilisateurService {
	
	@Autowired
	UtilisateurDAO utilisateurDAO;
	
	@Transactional
	public List<Utilisateur> getAllUsers() {
		return utilisateurDAO.getAllUsers();
	}

	@Transactional
	public Utilisateur getUser(int id) {
		return utilisateurDAO.getUser(id);
	}

	@Transactional
	public void addUser(Utilisateur user) {
		utilisateurDAO.addUser(user);
	}

	@Transactional
	public void updateUser(Utilisateur user) {
		utilisateurDAO.updateUser(user);

	}

	@Transactional
	public void deleteUser(int id) {
		utilisateurDAO.deleteUser(id);
	}

}
