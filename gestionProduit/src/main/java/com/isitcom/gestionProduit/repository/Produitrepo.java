package com.isitcom.gestionProduit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.isitcom.gestionProduit.entity.Produit;

public interface Produitrepo extends JpaRepository<Produit, Integer> {
	public List<Produit> findByNomContains(String mc);
	
	@Query("SELECT p FROM Produit p WHERE p.nom = :nom")
	public List<Produit> getProduitParNom(@Param("nom") String nom);
}
