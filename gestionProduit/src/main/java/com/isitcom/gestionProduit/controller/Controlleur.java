package com.isitcom.gestionProduit.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.isitcom.gestionProduit.entity.Categorie;
import com.isitcom.gestionProduit.entity.DTO;
import com.isitcom.gestionProduit.entity.LoginDto;
import com.isitcom.gestionProduit.entity.Produit;
import com.isitcom.gestionProduit.repository.Categorierepo;
import com.isitcom.gestionProduit.repository.Produitrepo;
import com.isitcom.gestionProduit.response.LoginResponse;
import com.isitcom.gestionProduit.service.UserService;


@Controller
public class Controlleur {
	@Autowired
	Produitrepo Pr;
	
	@Autowired
	Categorierepo Cr;

	@GetMapping(value={"/products"})
	public String Affiche_tous(Model m)
	{
		m.addAttribute("liste",Pr.findAll());
		m.addAttribute("categorie",Cr.findAll());
		System.out.println("ok");
		
		return "index";//n'accepte que index
	}
	
	// j'ajoute un produit je vais dans la section form ajout
	@PostMapping("/add")
	//public String ajouterprod(Model m,@ModelAttribute
	//Produit p,int ca)=>meme chose int ca
	//Categorie c=Cr.getcategorieparid(ca);
	public String ajouterprod(
			Model m,
			@ModelAttribute Produit p,
			@RequestParam(value="ca")int idc
	){
		Categorie c=Cr.findById(idc).get();
		p.setCategorie(c);Pr.save(p);
		m.addAttribute("liste",Pr.findAll());
		m.addAttribute("categorie",Cr.findAll());
		
		return "redirect:/products";
	}
	
	@GetMapping("/delete")
	public String supprimerprod(int id)
	{
		Pr.deleteById(id);
		
		return "redirect:/products";
	}
	
	
	
	@GetMapping("/prodpmotcle")
	public String rechercheparmotcle(String mc, Model m)
	{
		List<Produit>li=Pr.findByNomContains(mc);
		m.addAttribute("liste",li);
		
		return "index";
	}
	
	@Autowired
    private UserService us;
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}

    
    
    @PostMapping("")
    public String login(@RequestParam String email,@RequestParam String password,Model model)
    {	
    	LoginDto logindto = new LoginDto(email, password);
    	LoginResponse loginresponse = us.loginUser(logindto);
    	if(loginresponse.getMessage().equals("Login success"))
    	{
    		return "index";
    	}
    	else {
    		model.addAttribute("errorMessage", "Invalid credentials");
            return "login";
    	}
    }
    @PostMapping("/signup")
    public String signup(@RequestParam String username,@RequestParam String email,@RequestParam String password) {
    	DTO newUserDto=new DTO(username,email,password);
    	us.addUser(newUserDto);
    	return "redirect:/login";
    	
    }
    
}
