package com.isitcom.gestionProduit.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Categorie {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nom;
	@JsonManagedReference
	@OneToMany(mappedBy="categorie", fetch = FetchType.EAGER)
	private List<Produit>liste=new ArrayList<Produit>();
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public List<Produit> getListe() {
		return liste;
	}
	
	public void setListe(List<Produit> liste) {
		this.liste = liste;
	}
	
	public Categorie(String nom) {
		super();
		this.nom = nom;
	}
	
	public Categorie(String nom, List<Produit> liste) {
		this.nom = nom;
		this.liste = liste;
	}
	
	public Categorie(int id, String nom, List<Produit> liste) {
		this.id = id;
		this.nom = nom;
		this.liste = liste;
	}
	
	public Categorie() {
	}
	
	@Override
	public String toString() {
		return "Categorie [id=" + id + ", nom=" + nom + ", liste=" + liste + "]";
	}
}
