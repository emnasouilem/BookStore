package org.vermeg.bookstore.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.vermeg.bookstore.controller.UtilisateurController;
import org.vermeg.bookstore.model.Panier;
import org.vermeg.bookstore.model.Utilisateur;
import org.vermeg.bookstore.service.UtilisateurService;

class TestControllerUtilisateur {
	
	@Autowired
	private MockMvc mockMvc;
	@Mock
	private UtilisateurService utilisateurService;
	@InjectMocks
	private UtilisateurController utilisateurController;
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(utilisateurController).build();
	}

	@Test
	void testGetUsers() throws Exception {
		List<Panier> pan=  new ArrayList<Panier>();
		Utilisateur user=new  Utilisateur(13, "emnas", "emna",pan);
		Utilisateur user1= new  Utilisateur(12, "emnas", "emna",pan);
		List<Utilisateur> list=  new ArrayList<Utilisateur>();
		list.add(user);
		list.add(user1);
		when(utilisateurService.getAllUsers()).thenReturn(list);
		mockMvc.perform(get("/api/user/getAllUsers"))
		.andExpect(status().isOk()).andDo(print());
	}

	@Test
	void testGetUserByNum() throws Exception {
		List<Panier> pan=  new ArrayList<Panier>();
		Utilisateur user=new  Utilisateur(13, "emnas", "emna",pan);
		when(utilisateurService.getUser(13)).thenReturn(user);
		mockMvc.perform(get("/api/user/getUser/13"))
		.andExpect(status().isOk()).andDo(print());
	}

	@Test
	void testAddUser() throws Exception {
		List<Panier> pan=  new ArrayList<Panier>();
		Utilisateur user=new  Utilisateur(13, "emnas", "emna",pan);
		List<Utilisateur> list=  new ArrayList<Utilisateur>();
		list.add(user);
		utilisateurService.addUser(user);
		 verify(utilisateurService,times(1)).addUser(user);
		mockMvc.perform(post("/api/user/addUser"))
		.andExpect(status().isOk()).andDo(print());
	
	}

	@Test
	void testUpdateUser() throws Exception {
		List<Panier> pan=  new ArrayList<Panier>();
		Utilisateur user=new  Utilisateur(13, "emnas", "emna",pan);
		utilisateurService.updateUser(user);
		verify(utilisateurService,times(1)).updateUser(user);
		mockMvc.perform(get("/api/user/updateUser/13"))
		.andExpect(status().isOk()).andDo(print());
	}

	@Test
	void testDeleteuser() throws Exception {
		List<Panier> pan=  new ArrayList<Panier>();
		Utilisateur user=new  Utilisateur(13, "emnas", "emna",pan);
		utilisateurService.deleteUser(13);
		verify(utilisateurService,times(1)).deleteUser(13);
		mockMvc.perform(get("/api/user/deleteUser/13"))
		.andExpect(status().isOk()).andDo(print());
	}

}
