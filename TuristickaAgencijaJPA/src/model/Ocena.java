package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ocena database table.
 * 
 */
@Entity
@NamedQuery(name="Ocena.findAll", query="SELECT o FROM Ocena o")
public class Ocena implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idocena;

	private String ocena;

	//bi-directional many-to-one association to Ponuda
	@ManyToOne
	@JoinColumn(name="idPonuda")
	private Ponuda ponuda;

	public Ocena() {
	}

	public int getIdocena() {
		return this.idocena;
	}

	public void setIdocena(int idocena) {
		this.idocena = idocena;
	}

	public String getOcena() {
		return this.ocena;
	}

	public void setOcena(String ocena) {
		this.ocena = ocena;
	}

	public Ponuda getPonuda() {
		return this.ponuda;
	}

	public void setPonuda(Ponuda ponuda) {
		this.ponuda = ponuda;
	}

}