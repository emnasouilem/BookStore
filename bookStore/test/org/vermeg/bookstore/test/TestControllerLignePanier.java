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
import org.vermeg.bookstore.controller.LignePanierController;
import org.vermeg.bookstore.controller.UtilisateurController;
import org.vermeg.bookstore.model.LignePanier;
import org.vermeg.bookstore.model.Livre;
import org.vermeg.bookstore.model.Panier;
import org.vermeg.bookstore.service.LignePanierService;
import org.vermeg.bookstore.service.UtilisateurService;

class TestControllerLignePanier {
	@Autowired
	private MockMvc mockMvc;
	@Mock
	private LignePanierService ligneService;
	@InjectMocks
	private LignePanierController ligneController;
	

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(ligneController).build();
	}

	@Test
	void testGetAllLignePanier() throws Exception {
		List<LignePanier> list=new ArrayList<LignePanier>();
		Panier pan= new Panier();
		Livre livre = new Livre(15,7,"emna2", "emna2", null, "livre emna 2",15);
		LignePanier ligne= new LignePanier(livre, pan, 15, 1);
		list.add(ligne);
		 when(ligneService.getAllLignePanier(1)).thenReturn(list);
		 mockMvc.perform(get("/api/LignePanier/getAllLignePanier/1"))
			.andExpect(status().isOk()).andDo(print());
	}

	
	@Test
	void testAddLignePanier() throws Exception {
		List<LignePanier> list=new ArrayList<LignePanier>();
		Panier pan= new Panier();
		Livre livre = new Livre(15,7,"emna2", "emna2", null, "livre emna 2",15);
		LignePanier ligne= new LignePanier(livre, pan, 15, 1);
		list.add(ligne);
		ligneService.addLignePanier(ligne);
		 verify(ligneService,times(1)).addLignePanier(ligne);;
		 mockMvc.perform(post("/api/LignePanier/addLignePanier"))
			.andExpect(status().isOk()).andDo(print());
	}

	@Test
	void testUpdatePanier() throws Exception {
		List<LignePanier> list=new ArrayList<LignePanier>();
		Panier pan= new Panier();
		Livre livre = new Livre(15,7,"emna2", "emna2", null, "livre emna 2",15);
		LignePanier ligne= new LignePanier(livre, pan, 15, 1);
		list.add(ligne);
		ligneService.updateLignePanier(ligne);
		 verify(ligneService,times(1)).updateLignePanier(ligne);;
		 mockMvc.perform(get("/api/LignePanier/updateLignePanier/1"))
			.andExpect(status().isOk()).andDo(print());
	}

	@Test
	void testDeleteLivre() throws Exception {
		List<LignePanier> list=new ArrayList<LignePanier>();
		Panier pan= new Panier();
		Livre livre = new Livre(15,7,"emna2", "emna2", null, "livre emna 2",15);
		LignePanier ligne= new LignePanier(livre, pan, 15, 1);
		list.add(ligne);
		ligneService.deleteLignePanier(1);
		 verify(ligneService,times(1)).deleteLignePanier(1);;
		 mockMvc.perform(get("/api/LignePanier/updateLignePanier/1"))
			.andExpect(status().isOk()).andDo(print());
	}

}
