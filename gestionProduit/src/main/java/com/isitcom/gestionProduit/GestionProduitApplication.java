package com.isitcom.gestionProduit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

import com.isitcom.gestionProduit.entity.Categorie;
import com.isitcom.gestionProduit.entity.Produit;
import com.isitcom.gestionProduit.repository.Categorierepo;
import com.isitcom.gestionProduit.repository.Produitrepo;

@SpringBootApplication(exclude= {UserDetailsServiceAutoConfiguration.class})
public class GestionProduitApplication implements CommandLineRunner {
	@Autowired
	Produitrepo Pr;
	
	@Autowired
	Categorierepo Cr;
	

	public static void main(String[] args) {
		
		SpringApplication.run(GestionProduitApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		/*Categorie c1=new Categorie("informatique");
		Categorie c2=new Categorie("Electromenager");
		Cr.save(c1);
		Cr.save(c2);
		Produit p1=new Produit("Ecran",250.20);
		p1.setCategorie(c1);
		Produit p2=new Produit("TV",2500.80);
		p2.setCategorie(c2);
		Pr.save(p1);
		Pr.save(p2);*/
		// System.out.println(p1);
		//je veux afficher tous les produits
		//Pr.findAll().forEach(p->System.out.println(p.getNom()));
	}

}
