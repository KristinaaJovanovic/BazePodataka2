package model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the vrsta database table.
 * 
 */
@Entity
@NamedQuery(name="Vrsta.findAll", query="SELECT v FROM Vrsta v")
public class Vrsta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idv;

	private String nazv;

	//bi-directional many-to-one association to Proizvod
	@OneToMany(mappedBy="vrsta")
	private List<Proizvod> proizvods;

	public Vrsta() {
		this.proizvods=new ArrayList<Proizvod>();
	}

	public int getIdv() {
		return this.idv;
	}

	public void setIdv(int idv) {
		this.idv = idv;
	}

	public String getNazv() {
		return this.nazv;
	}

	public void setNazv(String nazv) {
		this.nazv = nazv;
	}

	public List<Proizvod> getProizvods() {
		return this.proizvods;
	}

	public void setProizvods(List<Proizvod> proizvods) {
		this.proizvods = proizvods;
	}

	public Proizvod addProizvod(Proizvod proizvod) {
		getProizvods().add(proizvod);
		proizvod.setVrsta(this);

		return proizvod;
	}

	public Proizvod removeProizvod(Proizvod proizvod) {
		getProizvods().remove(proizvod);
		proizvod.setVrsta(null);

		return proizvod;
	}

	@Override
	public String toString() {
		return "Vrsta [idv=" + idv + ", nazv=" + nazv + "]";
	}
	
	

}