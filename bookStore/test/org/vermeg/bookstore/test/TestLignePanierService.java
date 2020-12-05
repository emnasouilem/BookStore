package org.vermeg.bookstore.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.vermeg.bookstore.dao.LignePanierDAO;
import org.vermeg.bookstore.model.LignePanier;
import org.vermeg.bookstore.model.Livre;
import org.vermeg.bookstore.model.Panier;
import org.vermeg.bookstore.service.LignePanierService;

class TestLignePanierService {
	LignePanierService ligneService;
	LignePanierDAO ligneDao = mock(LignePanierDAO.class);
	
	@BeforeEach
	void setUp() throws Exception {
		
	}

	@Test
	void testGetAllLignePanier() {
		List<LignePanier> list=new ArrayList<LignePanier>();
		Panier pan= new Panier();
		Livre livre = new Livre(15,7,"emna2", "emna2", null, "livre emna 2",15);
		LignePanier ligne= new LignePanier(livre, pan, 15, 1);
		LignePanier ligne1= new LignePanier(livre, pan, 12, 15);
		list.add(ligne);
		list.add(ligne1);
		 when(ligneDao.getAllLignePanier(1)).thenReturn(list);
		 assertEquals(2,list.size());
		 assertEquals(15,list.get(0).getTotal());
	 assertEquals(15,list.get(1).getCode());
		 assertEquals(ligneDao.getAllLignePanier(1), list);
		
	}

	

	@Test
	void testAddLignePanier() {
		List<LignePanier> list=new ArrayList<LignePanier>();
		Panier pan= new Panier();
		Livre livre = new Livre(15,7,"emna2", "emna2", null, "livre emna 2",15);
		LignePanier ligne= new LignePanier(livre, pan, 15, 1);
		list.add(ligne);
		 when(ligneDao.getLignePanier(1)).thenReturn(ligne);
		 assertEquals(1,ligne.getCode());
		 assertTrue(ligneDao.getLignePanier(1)== ligne);
		
	}

	@Test
	void testUpdateLignePanier() { 
		Panier pan= new Panier();
		Livre livre = new Livre(15,7,"emna2", "emna2", null, "livre emna 2",15);
		LignePanier ligne= new LignePanier(livre, pan, 15, 1);
		ligneDao.updateLignePanier(ligne);
		verify(ligneDao,times(1)).updateLignePanier(ligne);}
		
	@Test
	void testDeleteLignePanier() {
		Panier pan= new Panier();
		Livre livre = new Livre(15,7,"emna2", "emna2", null, "livre emna 2",15);
		LignePanier ligne= new LignePanier(livre, pan, 15, 1);
		ligneDao.deleteLignePanier(1);
		verify(ligneDao,times(1)).deleteLignePanier(1);
	}

}
