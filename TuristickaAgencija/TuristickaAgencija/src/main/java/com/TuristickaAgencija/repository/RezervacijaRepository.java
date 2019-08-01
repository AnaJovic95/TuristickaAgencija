package com.TuristickaAgencija.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Korisnik;
import model.Rezervacija;

public interface RezervacijaRepository extends JpaRepository<Rezervacija, Integer> {

	
	@Query("select r from Rezervacija r where r.korisnik = :korisnik")
	List<Rezervacija> sveRezervacijeKorisnika(@Param("korisnik") Korisnik korisnik);

}
