package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the komentar database table.
 * 
 */
@Entity
@NamedQuery(name="Komentar.findAll", query="SELECT k FROM Komentar k")
public class Komentar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idkomentar;

	private String tekst;

	//bi-directional many-to-one association to Korisnik
	@ManyToOne
	@JoinColumn(name="idKorisnika")
	private Korisnik korisnik;

	//bi-directional many-to-one association to Ponuda
	@ManyToOne
	@JoinColumn(name="idPonude")
	private Ponuda ponuda;

	public Komentar() {
	}

	public int getIdkomentar() {
		return this.idkomentar;
	}

	public void setIdkomentar(int idkomentar) {
		this.idkomentar = idkomentar;
	}

	public String getTekst() {
		return this.tekst;
	}

	public void setTekst(String tekst) {
		this.tekst = tekst;
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