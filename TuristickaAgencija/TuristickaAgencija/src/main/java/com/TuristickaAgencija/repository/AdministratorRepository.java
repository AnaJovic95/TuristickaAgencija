package com.TuristickaAgencija.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Administrator;

public interface AdministratorRepository extends JpaRepository<Administrator,Integer> {

	
	@Query("select a from Administrator a where a.email = :email and a.lozinka = :lozinka")
	Administrator login(@Param("email") String email, @Param("lozinka") String lozinka);
}
