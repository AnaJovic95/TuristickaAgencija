package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the destinacija database table.
 * 
 */
@Entity
@NamedQuery(name="Destinacija.findAll", query="SELECT d FROM Destinacija d")
public class Destinacija implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int iddestinacija;

	private String drzava;

	private String grad;

	//bi-directional many-to-one association to Ponuda
	@OneToMany(mappedBy="destinacija")
	private List<Ponuda> ponudas;

	public Destinacija() {
	}

	public int getIddestinacija() {
		return this.iddestinacija;
	}

	public void setIddestinacija(int iddestinacija) {
		this.iddestinacija = iddestinacija;
	}

	public String getDrzava() {
		return this.drzava;
	}

	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}

	public String getGrad() {
		return this.grad;
	}

	public void setGrad(String grad) {
		this.grad = grad;
	}

	public List<Ponuda> getPonudas() {
		return this.ponudas;
	}

	public void setPonudas(List<Ponuda> ponudas) {
		this.ponudas = ponudas;
	}

	public Ponuda addPonuda(Ponuda ponuda) {
		getPonudas().add(ponuda);
		ponuda.setDestinacija(this);

		return ponuda;
	}

	public Ponuda removePonuda(Ponuda ponuda) {
		getPonudas().remove(ponuda);
		ponuda.setDestinacija(null);

		return ponuda;
	}

}