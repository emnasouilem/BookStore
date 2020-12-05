package org.vermeg.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.vermeg.bookstore.model.Livre;
import org.vermeg.bookstore.model.Panier;
import org.vermeg.bookstore.service.LivreService;
import org.vermeg.bookstore.service.PanierService;

@RestController
@RequestMapping("/api/panier")
public class PanierController {

	@Autowired
	PanierService panierService;
	
	@RequestMapping(value = "/getAllPanier", method = RequestMethod.GET, produces = "application/json")
	public List<Panier> getPanier(int id) {
		
		List<Panier> listOfpaniers = panierService.getAllPanier(id);
		
		return listOfpaniers;
	}

	@RequestMapping(value = "/getPanier/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Panier getPanierById(@PathVariable int id) {
		return panierService.getPanier(id);
	}

	@RequestMapping(value = "/addPanier", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addPanier(@ModelAttribute("panier") Panier panier) {	
		if(panier.getId()== 0)
		{
			panierService.addPanier(panier);
		}
		else
		{	
			panierService.updatePanier(panier);
		}
		
		return "redirect:/getAllPanier";
	}

	@RequestMapping(value = "/updatePanier/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String updatePanier(@PathVariable("id") int id,@ModelAttribute("panier")Panier panier,Model model) {
		if(panierService.getPanier(id)==null)
		{
			System.out.print( " n'existe pas");
		}
		else
		{
			panierService.updatePanier(panier);
			System.out.print( "modification avec succées");
		}
		return "redirect:/getAllPanier";
	}

	@RequestMapping(value = "/deletPanier/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String deleteLivre(@PathVariable("id") int id) {
		panierService.deletePanier(id);
		 return "redirect:/getAllLivres";

	}	
}
