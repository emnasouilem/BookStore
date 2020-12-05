package org.vermeg.bookstore.test;



import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.vermeg.bookstore.controller.LivreController;
import org.vermeg.bookstore.model.Livre;
import org.vermeg.bookstore.service.LivreService;

class TestControllerLivre {
	@Autowired
	private MockMvc mockMvc;

	@Mock
	private LivreService livreService;

	@InjectMocks
	private LivreController livreController;
	
	@BeforeEach
	public void setup() throws Exception {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(livreController).build();
	}
	
	@Test
	void testGetLivres() throws Exception {
		List<Livre> livres = new ArrayList<>();
		livres.add(new Livre("test", 4));
		livres.add(new Livre("test", 4));
		when(livreService.getAllLivres()).thenReturn(livres);
		mockMvc.perform(get("/api/livre/getAllLivres"))
		.andExpect(status().isOk()).andDo(print());
	}

	@Test
	void testGetLivreById() throws Exception {
		 Livre livre1 = new Livre(1,7,"emna", "emna", null, "livre emna 1",
					15);
			 int id=livre1.getId();
		 when(livreService.getLivre(id)).thenReturn(livre1);
		 this.mockMvc.perform(get("/api/livre/getLivre/1"))
		 .andExpect(status().isOk()).andDo(print());
	}

	@Test
	void testAddLivre() throws Exception {
		 Livre livre1 = new Livre(1,7,"emna", "emna", null, "livre emna 1",
					15);
		 List<Livre> livres = new ArrayList<Livre>();
		 livres.add(livre1);
		 livreService.addLivre(livre1);
		 verify(livreService,times(1)).addLivre(livre1);
		 this.mockMvc.perform(post("/api/livre/addLivre"))
		 .andExpect(status().isOk()).andDo(print());
		 
	}

	@Test
	void testUpdateLivre() throws Exception {
		Livre livre1 = new Livre(1,7,"emna", "emna", null, "livre emna 1",
				15);
	 livreService.updateLivre(livre1);
	 verify(livreService,times(1)).updateLivre(livre1) ;
	 this.mockMvc.perform(get("/api/livre/updateLivre/1"))
	 .andExpect(status().isOk()).andDo(print());
	}

	@Test
	void testDeleteLivre() throws Exception {
		Livre livre1 = new Livre(1,7,"emna", "emna", null, "livre emna 1",
				15);
	 livreService.deleteLivre(livre1.getId());
	 verify(livreService,times(1)).deleteLivre(livre1.getId());
	 this.mockMvc.perform(get("/api/livre/deleteLivre/1"))
	 .andExpect(status().isOk()).andDo(print());
	}

}
