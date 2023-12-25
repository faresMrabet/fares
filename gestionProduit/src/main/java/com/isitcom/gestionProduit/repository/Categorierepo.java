package com.isitcom.gestionProduit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.isitcom.gestionProduit.entity.Categorie;

public interface Categorierepo extends JpaRepository<Categorie, Integer> {

}
