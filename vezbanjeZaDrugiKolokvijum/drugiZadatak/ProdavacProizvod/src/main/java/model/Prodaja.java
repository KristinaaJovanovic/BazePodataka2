package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the prodaja database table.
 * 
 */
@Entity
@NamedQuery(name="Prodaja.findAll", query="SELECT p FROM Prodaja p")
public class Prodaja implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ProdajaPK id;

	private String datum;

	private double kolicina;

	//bi-directional many-to-one association to Prodavac
	@ManyToOne
	@JoinColumn(name="idp")
	@MapsId("idp") 
	private Prodavac prodavac;

	//bi-directional many-to-one association to Proizvod
	@ManyToOne
	@JoinColumn(name="sifp")
	@MapsId("sifp")
	private Proizvod proizvod;

	public Prodaja() {
	}

	public ProdajaPK getId() {
		return this.id;
	}

	public void setId(ProdajaPK id) {
		this.id = id;
	}

	public String getDatum() {
		return this.datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

	public double getKolicina() {
		return this.kolicina;
	}

	public void setKolicina(double kolicina) {
		this.kolicina = kolicina;
	}

	public Prodavac getProdavac() {
		return this.prodavac;
	}

	public void setProdavac(Prodavac prodavac) {
		this.prodavac = prodavac;
	}

	public Proizvod getProizvod() {
		return this.proizvod;
	}

	public void setProizvod(Proizvod proizvod) {
		this.proizvod = proizvod;
	}

}