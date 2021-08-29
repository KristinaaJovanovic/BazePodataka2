package model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the proizvod database table.
 * 
 */
@Entity
@NamedQuery(name="Proizvod.findAll", query="SELECT p FROM Proizvod p")
public class Proizvod implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int sifp;

	private double cena;

	private String naziv;

	//bi-directional many-to-one association to Prodaja
	@OneToMany(mappedBy="proizvod")
	private List<Prodaja> prodajas;

	//bi-directional many-to-one association to Vrsta
	@ManyToOne
	@JoinColumn(name="idv")
	private Vrsta vrsta;

	public Proizvod() {
		this.prodajas=new ArrayList<Prodaja>();
	}

	public int getSifp() {
		return this.sifp;
	}

	public void setSifp(int sifp) {
		this.sifp = sifp;
	}

	public double getCena() {
		return this.cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<Prodaja> getProdajas() {
		return this.prodajas;
	}

	public void setProdajas(List<Prodaja> prodajas) {
		this.prodajas = prodajas;
	}

	public Prodaja addProdaja(Prodaja prodaja) {
		getProdajas().add(prodaja);
		prodaja.setProizvod(this);

		return prodaja;
	}

	public Prodaja removeProdaja(Prodaja prodaja) {
		getProdajas().remove(prodaja);
		prodaja.setProizvod(null);

		return prodaja;
	}

	public Vrsta getVrsta() {
		return this.vrsta;
	}

	public void setVrsta(Vrsta vrsta) {
		this.vrsta = vrsta;
	}

	@Override
	public String toString() {
		return "Proizvod [sifp=" + sifp + ", cena=" + cena + ", naziv=" + naziv + ", vrsta=" + vrsta + "]";
	}
	
	

}