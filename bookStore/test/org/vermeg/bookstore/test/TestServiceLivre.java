package org.vermeg.bookstore.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.vermeg.bookstore.dao.LivreDAO;
import org.vermeg.bookstore.model.Livre;
import org.vermeg.bookstore.service.LivreService;

class TestServiceLivre {

	Livre livre1 ;
	LivreService livreService;
	LivreDAO livreDao = mock(LivreDAO.class);
	 
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testgetAllLivres() {
	 List<Livre> livres= new ArrayList<Livre>();
	Livre livre1 = new Livre(01,7,"emna", "emna", null, "livre emna 1",
			15);
	Livre livre2 = new Livre(01,7,"titre2", "emna", null, "livre emna 2",15);
	 livres.add(livre1);
	 livres.add(livre2);
	 when(livreDao.getAllLivres()).thenReturn(livres);
	 assertEquals(2,livres.size());
	 assertEquals("emna",livres.get(0).getTitre());
	 assertEquals("titre2",livres.get(1).getTitre());
	 assertEquals(livreDao.getAllLivres() , livres);
	}
	@Test
	void testgetLivre() {
	 livre1 = new Livre(1,7,"emna", "emna", null, "livre emna 1",
			15);
	 int id=livre1.getId();
	 when(livreDao.getLivre(id)).thenReturn(livre1);
	 assertEquals(1,livre1.getId());
	 assertTrue(livreDao.getLivre(id) == livre1);
	}
	
	@Test
	void testaddLivre() {
	List<Livre> livres= new ArrayList<Livre>();
	Livre livre1 = new Livre(01,7,"emna", "emna", null, "livre emna 1",
			15);
	 int size=livres.size();
	 livres.add(livre1);
	 livreDao.addLivre(livre1);
		verify(livreDao,times(1)).addLivre(livre1);

	}
	
	@Test
	void testupdateLivre() {
	Livre livre1 = new Livre(01,7,"emna", "emna", null, "livre emna 1",
			15);
	 livreDao.updateLivre(livre1);
	verify(livreDao,times(1)).updateLivre(livre1);
	}
	
	@Test
	void testDeleteLivre() {

	Livre livre1 = new Livre(01,7,"emna", "emna", null, "livre emna 1",
			15);
	 livreDao.deleteLivre(livre1.getId());
	verify(livreDao,times(1)).deleteLivre(livre1.getId());
	}
}
