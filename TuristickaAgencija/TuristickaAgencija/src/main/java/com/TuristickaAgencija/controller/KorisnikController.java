package com.TuristickaAgencija.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.TuristickaAgencija.repository.DestinacijaRepository;
import com.TuristickaAgencija.repository.KomentarRepository;
import com.TuristickaAgencija.repository.KorisnikRepository;
import com.TuristickaAgencija.repository.OcenaRepository;
import com.TuristickaAgencija.repository.PonudaRepository;
import com.TuristickaAgencija.repository.RezervacijaRepository;

import model.Destinacija;
import model.Komentar;
import model.Korisnik;
import model.Ocena;
import model.Ponuda;
import model.Rezervacija;

@Controller
@RequestMapping(value="/korisnik")
public class KorisnikController {

	
	@Autowired
	KorisnikRepository krepo;
	
	@Autowired
	DestinacijaRepository drepo;
	
	@Autowired
	PonudaRepository prepo;
	
	@Autowired
	RezervacijaRepository rezervacijaRepo;
	
	@Autowired
	KomentarRepository komentarrepo;
	
	@Autowired
	OcenaRepository orepo;
	
	Korisnik korisnik;
	
	@GetMapping(value="sveDestinacije")
	public String sveDestinacije(HttpServletRequest request){
		List<Destinacija> destinacije =drepo.findAll();
		request.getSession().setAttribute("destinacije", destinacije);
		return "/sveDestinacije";
	}
	
	
	@RequestMapping(value="/login", method={RequestMethod.POST,RequestMethod.GET}) 
	public String login(String email,String lozinka,Model m,HttpServletRequest request){
		korisnik = krepo.login(email, lozinka);
		
		if(korisnik != null){
			request.getSession().setAttribute("korisnik", korisnik);
			return "/ulogovaniKorisnik";
		}else{
			request.setAttribute("korisnik", korisnik);
			m.addAttribute("porukaLogin", "Uneli ste pogresan podatak");
			return "/loginKorisnik";
		}
		
	}
	
	@PostMapping(value="registracija")
	public String registracija(Korisnik ko ,HttpServletRequest request){
		Korisnik registrovan;
		try{
			registrovan= krepo.save(ko);
			if(registrovan != null){
				request.getSession().setAttribute("porukaR", "Uspesno ste registrovani.");
				return "/ulogovaniKorisnik";
			}else{
				request.getSession().setAttribute("porukaR", "Greska prilikom registracije");
				return "/registracija"; 
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return "/registracija";	
	}
	
	
	@GetMapping(value="svePonude")
	public String svePonude(HttpServletRequest request, Destinacija d,Model m){
		List<Ponuda> ponude =prepo.ponudeZaDestinaciju(d);
		m.addAttribute("ponude", ponude);
		return "/svePonude";
	}
	
	@GetMapping(value="sveDestinacijePonuda")
	public String sveDestinacijePonuda(HttpServletRequest request){
		List<Destinacija> destinacije =drepo.findAll();
		request.getSession().setAttribute("destinacije", destinacije);
		return "/svePonude";
	}
	@RequestMapping(value="rezervisi",method={RequestMethod.POST,RequestMethod.GET})
	public String rezervisi(HttpServletRequest request,Rezervacija r){
		r.setKorisnik(korisnik);
		r=rezervacijaRepo.save(r);
		if(r!=null){
			return "/ulogovaniKorisnik";
		}else{
			return "/svePonude";
		}
	} 
	
	@RequestMapping(value="dodajKomentarZaPonudu",method={RequestMethod.POST,RequestMethod.GET})
	public String dodajKomentarZaPonudu(HttpServletRequest request,Komentar k ){
		k.setKorisnik(korisnik);
		k=komentarrepo.save(k);
		if(k != null){
			return "/ulogovaniKorisnik";
		}else{
			return "/dodajKomentarZaPonudu";
		}
	}
	
	@GetMapping(value="svePonudeZaKomentar")
	public String svePonudeZaKomentar(HttpServletRequest request, Komentar k ,Model m){
		List<Ponuda> ponude =prepo.findAll();
		m.addAttribute("ponude", ponude);
		return "/dodajKomentarZaPonudu";
	}
	
	@GetMapping(value="svePonudeZaOcenu")
	public String svePonudeZaOcenu(HttpServletRequest request, Ocena o ,Model m){
		List<Ponuda> ponude =prepo.findAll();
		m.addAttribute("ponude", ponude);
		return "/dodajOcenuZaPonudu";
	}
	
	@RequestMapping(value="dodajOcenuZaPonudu",method={RequestMethod.POST,RequestMethod.GET})
	public String dodajOcenuZaPonudu(HttpServletRequest request,Ocena o ){
		o=orepo.save(o);
		if(o != null){
			return "/ulogovaniKorisnik";
		}else{
			return "/dodajOcenuZaPonudu";
		}
	}
	
	@RequestMapping(value="/sveRezervacijeKorisnika",method={RequestMethod.POST,RequestMethod.GET})
	public String sveRezervacijeKorisnika(HttpServletRequest request){
		List<Rezervacija> rezervacije = rezervacijaRepo.sveRezervacijeKorisnika(korisnik);
		request.getSession().setAttribute("rezervacije", rezervacije);
		return "/sveRezervacijeKorisnika";
	}
	
	@RequestMapping(value="/promenaLozinke", method={RequestMethod.POST,RequestMethod.GET})
	public String promenaLozinke(HttpServletRequest request, String novaLozinka, Korisnik k, Model m){
		boolean promenio=false;
		if(korisnik.getLozinka().equals(request.getParameter("staraLozinka"))){
			if(request.getParameter("novaLozinka").equals(request.getParameter("novaLozinka2"))){
				korisnik.setLozinka(novaLozinka);
				k=krepo.save(korisnik);	
				promenio=true;
				}
		}
		if(promenio == true){
			return "/ulogovaniKorisnik";
		}else{
			return "/promenaLozinke"; 
		}
		
	}
	
	@RequestMapping(value="/otkaziRezervaciju",method={RequestMethod.POST,RequestMethod.GET})
	public String otkaziRezervaciju(HttpServletRequest request, Rezervacija r){
		rezervacijaRepo.delete(r);
		return "/ulogovaniKorisnik";
	}

}
