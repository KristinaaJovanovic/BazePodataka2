package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the mec database table.
 * 
 */
@Entity
@NamedQuery(name="Mec.findAll", query="SELECT m FROM Mec m")
public class Mec implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int mecId;

	private String datum;

	private String rezultat;

	private String vreme;

	//bi-directional many-to-one association to Igrac
	@ManyToOne
	private Igrac igrac1;

	//bi-directional many-to-one association to Igrac
	@ManyToOne
	private Igrac igrac2;

	public Mec() {
	}

	public int getMecId() {
		return this.mecId;
	}

	public void setMecId(int mecId) {
		this.mecId = mecId;
	}

	public String getDatum() {
		return this.datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

	public String getRezultat() {
		return this.rezultat;
	}

	public void setRezultat(String rezultat) {
		this.rezultat = rezultat;
	}

	public String getVreme() {
		return this.vreme;
	}

	public void setVreme(String vreme) {
		this.vreme = vreme;
	}

	public Igrac getIgrac1() {
		return this.igrac1;
	}

	public void setIgrac1(Igrac igrac1) {
		this.igrac1 = igrac1;
	}

	public Igrac getIgrac2() {
		return this.igrac2;
	}

	public void setIgrac2(Igrac igrac2) {
		this.igrac2 = igrac2;
	}

	@Override
	public String toString() {
		return "Mec [mecId=" + mecId + ", datum=" + datum + ", rezultat=" + rezultat + ", vreme=" + vreme + "]";
	}
	
	

}