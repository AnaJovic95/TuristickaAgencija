package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the rezervacija database table.
 * 
 */
@Entity
@NamedQuery(name="Rezervacija.findAll", query="SELECT r FROM Rezervacija r")
public class Rezervacija implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idrezervacija;

	//bi-directional many-to-one association to Korisnik
	@ManyToOne
	@JoinColumn(name="idKorisnik")
	private Korisnik korisnik;

	//bi-directional many-to-one association to Ponuda
	@ManyToOne
	@JoinColumn(name="idPon")
	private Ponuda ponuda;

	public Rezervacija() {
	}

	public int getIdrezervacija() {
		return this.idrezervacija;
	}

	public void setIdrezervacija(int idrezervacija) {
		this.idrezervacija = idrezervacija;
	}

	public Korisnik getKorisnik() {
		return this.korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	public Ponuda getPonuda() {
		return this.ponuda;
	}

	public void setPonuda(Ponuda ponuda) {
		this.ponuda = ponuda;
	}

}