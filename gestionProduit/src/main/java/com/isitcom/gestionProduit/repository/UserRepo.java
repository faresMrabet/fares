package com.isitcom.gestionProduit.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.isitcom.gestionProduit.entity.*;

@EnableJpaRepositories
@Repository

public interface UserRepo extends JpaRepository<User,Integer>{

	User findByEmail(String email) ;

	 
}
