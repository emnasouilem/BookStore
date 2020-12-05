package org.vermeg.bookstore.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.vermeg.bookstore.dao.UtilisateurDAO;
import org.vermeg.bookstore.model.Livre;
import org.vermeg.bookstore.model.Panier;
import org.vermeg.bookstore.model.Utilisateur;
import org.vermeg.bookstore.service.UtilisateurService;

class TestServiceUtilisateur {

	
	UtilisateurService utilisateurService;
	UtilisateurDAO utilisateurDao = mock(UtilisateurDAO.class);
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testGetAllUsers() {
		List<Panier> pan=  new ArrayList<Panier>();
		List<Utilisateur> list=  new ArrayList<Utilisateur>();
		Utilisateur user1= new  Utilisateur(12, "emnas", "emna",pan);
		Utilisateur user=new  Utilisateur(13, "emnas", "emna",pan);
		list.add(user);
		list.add(user1);
		when(utilisateurDao.getAllUsers()).thenReturn(list);
		 assertEquals(2,list.size());
		 assertEquals("emnas",list.get(0).getPseudo());
		 assertEquals("emna",list.get(1).getMotpasse());
		 assertEquals(utilisateurDao.getAllUsers() , list);
	}

	@Test
	void testGetUser() {
		List<Panier> pan=  new ArrayList<Panier>();
		Utilisateur user1= new  Utilisateur(12, "emnas", "emna",pan);
		when(utilisateurDao.getUser(user1.getNumU())).thenReturn(user1);
		assertEquals(12,user1.getNumU());
		 assertTrue(utilisateurDao.getUser(12) == user1);
	}

	@Test
	void testAddUser() {
		List<Panier> pan=  new ArrayList<Panier>();
		Utilisateur user=new  Utilisateur(13, "emnas", "emna",pan);
		Utilisateur user1= new  Utilisateur(12, "emnas", "emna",pan);
		List<Utilisateur> list=  new ArrayList<Utilisateur>();
		list.add(user1);
		list.add(user);
		utilisateurDao.addUser(user1);
		utilisateurDao.addUser(user);
		verify(	utilisateurDao,times(1)).addUser(user1);
		verify(	utilisateurDao,times(1)).addUser(user);

		
	}

	@Test
	void testUpdateUser() {
		List<Panier> pan=  new ArrayList<Panier>();
		Utilisateur user=new  Utilisateur(13, "emnas", "emna",pan);
		utilisateurDao.updateUser(user);
		verify(	utilisateurDao,times(1)).updateUser(user);
	}

	@Test
	void testDeleteUser() {
		List<Panier> pan=  new ArrayList<Panier>();
		Utilisateur user=new  Utilisateur(13, "emnas", "emna",pan);
		utilisateurDao.deleteUser(13);
		verify(	utilisateurDao,times(1)).deleteUser(13);
	}

}
