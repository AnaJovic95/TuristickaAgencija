package com.TuristickaAgencija.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Destinacija;
import model.Ponuda;

public interface PonudaRepository extends JpaRepository<Ponuda, Integer>{
	
	@Query("select p from Ponuda p where p.destinacija= :destinacija")
	List<Ponuda> ponudeZaDestinaciju(@Param ("destinacija") Destinacija destinacija);
	
	

}
