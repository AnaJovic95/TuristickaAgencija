package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ponuda database table.
 * 
 */
@Entity
@NamedQuery(name="Ponuda.findAll", query="SELECT p FROM Ponuda p")
public class Ponuda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idponuda;

	private String cena;

	private String datumDo;

	private String datumOd;

	private String prevoz;

	private String smestaj;

	//bi-directional many-to-one association to Komentar
	@OneToMany(mappedBy="ponuda")
	private List<Komentar> komentars;

	//bi-directional many-to-one association to Ocena
	@OneToMany(mappedBy="ponuda")
	private List<Ocena> ocenas;

	//bi-directional many-to-one association to Destinacija
	@ManyToOne
	@JoinColumn(name="idDestinacije")
	private Destinacija destinacija;

	//bi-directional many-to-one association to Rezervacija
	@OneToMany(mappedBy="ponuda")
	private List<Rezervacija> rezervacijas;

	public Ponuda() {
	}

	public int getIdponuda() {
		return this.idponuda;
	}

	public void setIdponuda(int idponuda) {
		this.idponuda = idponuda;
	}

	public String getCena() {
		return this.cena;
	}

	public void setCena(String cena) {
		this.cena = cena;
	}

	public String getDatumDo() {
		return this.datumDo;
	}

	public void setDatumDo(String datumDo) {
		this.datumDo = datumDo;
	}

	public String getDatumOd() {
		return this.datumOd;
	}

	public void setDatumOd(String datumOd) {
		this.datumOd = datumOd;
	}

	public String getPrevoz() {
		return this.prevoz;
	}

	public void setPrevoz(String prevoz) {
		this.prevoz = prevoz;
	}

	public String getSmestaj() {
		return this.smestaj;
	}

	public void setSmestaj(String smestaj) {
		this.smestaj = smestaj;
	}

	public List<Komentar> getKomentars() {
		return this.komentars;
	}

	public void setKomentars(List<Komentar> komentars) {
		this.komentars = komentars;
	}

	public Komentar addKomentar(Komentar komentar) {
		getKomentars().add(komentar);
		komentar.setPonuda(this);

		return komentar;
	}

	public Komentar removeKomentar(Komentar komentar) {
		getKomentars().remove(komentar);
		komentar.setPonuda(null);

		return komentar;
	}

	public List<Ocena> getOcenas() {
		return this.ocenas;
	}

	public void setOcenas(List<Ocena> ocenas) {
		this.ocenas = ocenas;
	}

	public Ocena addOcena(Ocena ocena) {
		getOcenas().add(ocena);
		ocena.setPonuda(this);

		return ocena;
	}

	public Ocena removeOcena(Ocena ocena) {
		getOcenas().remove(ocena);
		ocena.setPonuda(null);

		return ocena;
	}

	public Destinacija getDestinacija() {
		return this.destinacija;
	}

	public void setDestinacija(Destinacija destinacija) {
		this.destinacija = destinacija;
	}

	public List<Rezervacija> getRezervacijas() {
		return this.rezervacijas;
	}

	public void setRezervacijas(List<Rezervacija> rezervacijas) {
		this.rezervacijas = rezervacijas;
	}

	public Rezervacija addRezervacija(Rezervacija rezervacija) {
		getRezervacijas().add(rezervacija);
		rezervacija.setPonuda(this);

		return rezervacija;
	}

	public Rezervacija removeRezervacija(Rezervacija rezervacija) {
		getRezervacijas().remove(rezervacija);
		rezervacija.setPonuda(null);

		return rezervacija;
	}

}