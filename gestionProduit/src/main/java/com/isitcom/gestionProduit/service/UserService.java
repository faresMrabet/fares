package com.isitcom.gestionProduit.service;

import com.isitcom.gestionProduit.*;
import com.isitcom.gestionProduit.entity.DTO;
import com.isitcom.gestionProduit.entity.LoginDto;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import com.isitcom.gestionProduit.response.*;

	
public interface UserService  {

	String addUser(DTO userDTO) ;

	LoginResponse loginUser(LoginDto loginDto) ;
	

}
