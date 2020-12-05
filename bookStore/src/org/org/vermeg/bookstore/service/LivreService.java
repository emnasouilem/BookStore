package org.vermeg.bookstore.service;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vermeg.bookstore.dao.LivreDAO;
import org.vermeg.bookstore.model.Livre;

@Service("LivreService")
public class LivreService {
	
	@Autowired
	LivreDAO livreDao;
	
	@Transactional
	public List<Livre> getAllLivres() {
		return livreDao.getAllLivres();
	}

	@Transactional
	public Livre getLivre(int id) {
		return livreDao.getLivre(id);
	}

	@Transactional
	public void addLivre(Livre livre) {
		livreDao.addLivre(livre);
	}

	@Transactional
	public void updateLivre(Livre livre) {
		livreDao.updateLivre(livre);

	}

	@Transactional
	public void deleteLivre(int id) {
		livreDao.deleteLivre(id);
	}

}
