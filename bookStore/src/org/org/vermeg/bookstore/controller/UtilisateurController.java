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
import org.vermeg.bookstore.model.Utilisateur;
import org.vermeg.bookstore.service.LivreService;
import org.vermeg.bookstore.service.UtilisateurService;
@RestController
@RequestMapping("/api/user")
public class UtilisateurController {
	@Autowired
	UtilisateurService utilisateurService;
	

	
	@RequestMapping(value = "/getAllUsers", method = RequestMethod.GET, produces = "application/json")
	public List<Utilisateur> getUsers() {
		
		List<Utilisateur> listOfUsers = utilisateurService.getAllUsers();
		
		return listOfUsers;
	}

	@RequestMapping(value = "/getUser/{numU}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Utilisateur getUserByNum(@PathVariable int numU) {
		return utilisateurService.getUser(numU);
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addUser(@ModelAttribute("Utilisateur") Utilisateur user) {	
		if(user.getNumU()==0)
		{
			utilisateurService.addUser(user);
		}
		else
		{	
			utilisateurService.updateUser(user);
		}
		
		return "redirect:/getAllLivres";
	}

	@RequestMapping(value = "/updateUser/{numU}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String updateUser(@PathVariable("numU") int numU,@ModelAttribute("Utilisateur") Utilisateur user ,Model model) {
		if(utilisateurService.getUser(numU)==null)
		{
			System.out.print( " n'existe pas");
		}
		else
		{
			utilisateurService.updateUser(user);
			System.out.print( "modification avec succées");
		}
		return "redirect:/getAllUsers";
	}

	@RequestMapping(value = "/deleteUser/{numU}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String deleteuser(@PathVariable("numU") int numU) {
		utilisateurService.deleteUser(numU);
		 return "redirect:/getAllUsers";

	}	

}
