package org.vermeg.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.vermeg.bookstore.model.LignePanier;
import org.vermeg.bookstore.model.Panier;
import org.vermeg.bookstore.service.LignePanierService;
import org.vermeg.bookstore.service.PanierService;

@RestController
@RequestMapping("/api/LignePanier")
public class LignePanierController {

	@Autowired
	LignePanierService lignepanierService;
	
	@RequestMapping(value = "/getAllLignePanier", method = RequestMethod.GET, produces = "application/json")
	public List<LignePanier> getPanier(int id) {
		
		List<LignePanier> listOfLignepaniers = lignepanierService.getAllLignePanier(id);
		lignepanierService.calculLignePanier(listOfLignepaniers);
		return listOfLignepaniers;
	}

	@RequestMapping(value = "/getLignePanier/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public LignePanier getLignePanierById(@PathVariable int id) {
		return lignepanierService.getPanier(id);
	}

	@RequestMapping(value = "/addLignePanier", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addPanier(@ModelAttribute("panier") LignePanier lpanier) {	
		if(lpanier.getCode()== 0 )
		{
			lignepanierService.addLignePanier(lpanier);
		}
		else
		{	
			lignepanierService.updateLignePanier(lpanier);
		}
		
		return "redirect:/getAllPanier";
	}

	@RequestMapping(value = "/updateLignePanier/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String updatePanier(@PathVariable("id") int id,@ModelAttribute("lignepanier")LignePanier lpanier,Model model) {
		if(lignepanierService.getPanier(id)==null)
		{
			System.out.print( " n'existe pas");
		}
		else
		{
			lignepanierService.updateLignePanier(lpanier);
			System.out.print( "modification avec succées");
		}
		return "redirect:/getAllPanier";
	}

	@RequestMapping(value = "/deletLignePanier/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String deleteLivre(@PathVariable("id") int id) {
		lignepanierService.deleteLignePanier(id);
		 return "redirect:/getAllLivres";

	}	
}
