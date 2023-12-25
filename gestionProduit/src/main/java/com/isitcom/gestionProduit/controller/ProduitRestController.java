package com.isitcom.gestionProduit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isitcom.gestionProduit.entity.DTO;
import com.isitcom.gestionProduit.entity.LoginDto;
import com.isitcom.gestionProduit.entity.Produit;
import com.isitcom.gestionProduit.repository.Produitrepo;
import com.isitcom.gestionProduit.response.LoginResponse;
import com.isitcom.gestionProduit.service.UserService;

import lombok.AllArgsConstructor;


@RestController
@AllArgsConstructor
@RequestMapping("api")
public class ProduitRestController
{
	private Produitrepo produitRepository;
	
	@GetMapping(path="/produits")
	public List<Produit>listeproduit()
	{
		return produitRepository.findAll();
	}
	
	@GetMapping(path="/produits/{id}")
	public Produit getProduit(@PathVariable int id)
	{
		return produitRepository.findById(id).get();
	}
	
	@PostMapping(path="/produits")
	public Produit save(@RequestBody Produit produit) {
		return produitRepository.save(produit);
	}
	
	@PutMapping(path="/produits/{id}")
	public Produit update(@PathVariable int id, @RequestBody Produit produit) {
		produit.setId(id);//pour affecter au produit son id
		
		return produitRepository.save(produit);
	}
	
	@DeleteMapping(path="/produits/{id}")
	public void delete(@PathVariable int id) {
		produitRepository.deleteById(id);
	}
	
	@Autowired(required=true)
	private	UserService userService;
	
	@PostMapping("/save")
	public String saveUser(@RequestBody DTO userDTO) {
		String id= userService.addUser(userDTO);
		
		return id;
		
	}
	@PostMapping(path="/login")
	public ResponseEntity<?>loginUser(@RequestBody LoginDto loginDto)
	{
		LoginResponse loginResponse =userService.loginUser(loginDto);
		return ResponseEntity.ok(loginResponse);
	}
}
