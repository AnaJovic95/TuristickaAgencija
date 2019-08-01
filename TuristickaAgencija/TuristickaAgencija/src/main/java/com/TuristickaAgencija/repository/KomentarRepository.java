package com.TuristickaAgencija.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Komentar;

public interface KomentarRepository extends JpaRepository<Komentar, Integer>{
	
	/*@Query("select k from Ponuda p where p.destinacija= :destinacija")
	List<Ponuda> ponudeZaDestinaciju(@Param ("destinacija") Destinacija destinacija);*/

}
