package com.TuristickaAgencija.controller;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.TuristickaAgencija.repository.AdministratorRepository;
import com.TuristickaAgencija.repository.DestinacijaRepository;
import com.TuristickaAgencija.repository.KomentarRepository;
import com.TuristickaAgencija.repository.KorisnikRepository;
import com.TuristickaAgencija.repository.OcenaRepository;
import com.TuristickaAgencija.repository.PonudaRepository;
import com.TuristickaAgencija.repository.RezervacijaRepository;

import model.Administrator;
import model.Destinacija;
import model.Komentar;
import model.Korisnik;
import model.Ocena;
import model.Ponuda;
import model.Rezervacija;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
@RequestMapping(value="/administrator")
public class AdministratorController {
	
	Administrator administrator;
	
	@Autowired
	AdministratorRepository adminrepo;
	
	@Autowired
	DestinacijaRepository destinacijarepo;
	
	@Autowired
	PonudaRepository ponudarepo;
	
	@Autowired
	OcenaRepository orepo;
	
	@Autowired
	KomentarRepository komrepo;
	
	@Autowired
	RezervacijaRepository rezrepo;
	
	@Autowired
	KorisnikRepository korrepo;
	
	
	@RequestMapping(value="/login", method={RequestMethod.POST,RequestMethod.GET}) 
	public String login(String email,String lozinka,Model m,HttpServletRequest request){
		administrator = adminrepo.login(email, lozinka);
		
		if(administrator != null){
			request.getSession().setAttribute("administrator", administrator);
			return "/ulogovanAdmin";
		}else{
			request.setAttribute("administrator", administrator);
			m.addAttribute("porukaLogin", "Uneli ste pogresan podatak");
			return "/loginAdmin";
		}
		
	}
	
	@RequestMapping(value="dodajDestinaciju",method={RequestMethod.POST,RequestMethod.GET})
	public String dodajDogadjaj(HttpServletRequest request,Destinacija d){
		d=destinacijarepo.save(d);
		if(d != null){
			return "/ulogovanAdmin";
		}else{
			return "/dodajDestinaciju";
		}
	}
	
	@RequestMapping(value="dodajPonudu",method={RequestMethod.POST,RequestMethod.GET})
	public String dodajDogadjaj(HttpServletRequest request,Ponuda p){
		p=ponudarepo.save(p);
		if(p != null){
			return "/ulogovanAdmin";
		}else{
			return "/dodajPonudu";
		}
	}
	
	@RequestMapping(value="sveDestinacije",method={RequestMethod.POST,RequestMethod.GET})
	public String sveDestinacije(HttpServletRequest request){
		List<Destinacija> destinacije =destinacijarepo.findAll();
		request.getSession().setAttribute("destinacije", destinacije);
		return "/dodajPonudu";
	}
	
	@RequestMapping(value="svePonude",method={RequestMethod.POST,RequestMethod.GET})
	public String svePonude(HttpServletRequest request){
		List<Ponuda> ponude =ponudarepo.findAll();
		request.getSession().setAttribute("ponude", ponude);
		return "/pregledPonudaAdmin";
	}
	
	@RequestMapping(value="sveOcene",method={RequestMethod.POST,RequestMethod.GET})
	public String sveOcene(HttpServletRequest request){
		List<Ocena> ocene =orepo.findAll();
		request.getSession().setAttribute("ocene", ocene);
		return "/pregledOcenaAdmin";
	}
	
	@RequestMapping(value="sviKomentari",method={RequestMethod.POST,RequestMethod.GET})
	public String sviKomentari(HttpServletRequest request){
		List<Komentar> komentari =komrepo.findAll();
		request.getSession().setAttribute("komentari", komentari);
		return "/pregledKomentaraAdmin";
	}
	
	@RequestMapping(value="/sveRezervacijeKorisnikAdmin",method={RequestMethod.POST,RequestMethod.GET})
	public String sveRezervacijeKorisnikAdmin(HttpServletRequest request,Korisnik korisnik,Model m){
		List<Rezervacija> rez =rezrepo.sveRezervacijeKorisnika(korisnik);
		m.addAttribute("rez", rez);
		return "/pregledRezervacijaKorisnikaAdmin";
	}

	@RequestMapping(value="sviKorisnici", method={RequestMethod.POST,RequestMethod.GET}) 
	public String sviKorisnici(HttpServletRequest request) { 
		List<Korisnik> korisnici =korrepo.findAll();
		request.getSession().setAttribute("korisnici", korisnici);
		return "/pregledRezervacijaKorisnikaAdmin";
	}
	
	@RequestMapping(value="generisiIzvestajSviKorisnici", method=RequestMethod.GET) 
	public void generisiIzvestajKorisnici(HttpServletRequest request, HttpServletResponse response) throws Exception { 
		List<Korisnik> korisnici = korrepo.findAll();
		response.setContentType("text/html");
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(korisnici);
		InputStream inputStream = this.getClass().getResourceAsStream("/jasperreports/rpt_korisnici.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
		Map<String, Object> params = new HashMap<String, Object>();
		String k="";
			k=korisnici.get(0).getIdkorisnik()+" "+korisnici.get(0).getIme()+" "+korisnici.get(0).getPrezime()+" "+korisnici.get(0).getEmail();
			
		if(korisnici!=null && korisnici.size()>0)
			params.put("k", k);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource);
		inputStream.close();
		
		response.setContentType("application/x-download");
		response.addHeader("Content-disposition", "attachment; filename=Korisnici.pdf");
		OutputStream out = response.getOutputStream();
		JasperExportManager.exportReportToPdfStream(jasperPrint,out);
	}
	
	@RequestMapping(value="generisiIzvestajSvePonudeZaDestinacije", method=RequestMethod.GET) 
	public void generisiIzvestajSvePonudeZaDestinacije(HttpServletRequest request, HttpServletResponse response, Destinacija destinacija) throws Exception { 
		List<Ponuda> ponude = ponudarepo.ponudeZaDestinaciju(destinacija);
		response.setContentType("text/html");
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(ponude);
		InputStream inputStream = this.getClass().getResourceAsStream("/jasperreports/rpt_ponude.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
		Map<String, Object> params = new HashMap<String, Object>();
		String p="";
			p=ponude.get(0).getSmestaj()+" "+ponude.get(0).getPrevoz()+" "+ponude.get(0).getCena()+" "+ponude.get(0).getDatumOd()+" "+ponude.get(0).getDatumDo();
			
		if(ponude!=null && ponude.size()>0)
			params.put("p", p);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource);
		inputStream.close();
		
		response.setContentType("application/x-download");
		response.addHeader("Content-disposition", "attachment; filename=Ponude.pdf");
		OutputStream out = response.getOutputStream();
		JasperExportManager.exportReportToPdfStream(jasperPrint,out);
	}
	
	@RequestMapping(value="sveDestinacijeZaIzvestaj",method={RequestMethod.POST,RequestMethod.GET})
	public String sveDestinacijeZaIzvestaj(HttpServletRequest request){
		List<Destinacija> destinacije =destinacijarepo.findAll();
		request.getSession().setAttribute("destinacije", destinacije);
		return "/sveDestinacijeZaIzvestaj";
	}





}
