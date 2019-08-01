package com.TuristickaAgencija.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Korisnik;

public interface KorisnikRepository extends JpaRepository<Korisnik, Integer> {


	@Query("select k from Korisnik k where k.email = :email and k.lozinka = :lozinka")
	Korisnik login(@Param("email") String email, @Param("lozinka") String lozinka);



}
