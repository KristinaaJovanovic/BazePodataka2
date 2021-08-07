package model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the fiilm database table.
 * 
 */
@Entity
@NamedQuery(name="Fiilm.findAll", query="SELECT f FROM Fiilm f")
public class Fiilm implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int sifra;

	private int godina;

	private String naziv;

	private String zanr;

	//bi-directional many-to-many association to Glumac
	@ManyToMany(mappedBy="fiilms", fetch=FetchType.EAGER)
	private List<Glumac> glumacs;

	public Fiilm() {
		glumacs=new ArrayList<Glumac>();
	}

	public int getSifra() {
		return this.sifra;
	}

	public void setSifra(int sifra) {
		this.sifra = sifra;
	}

	public int getGodina() {
		return this.godina;
	}

	public void setGodina(int godina) {
		this.godina = godina;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getZanr() {
		return this.zanr;
	}

	public void setZanr(String zanr) {
		this.zanr = zanr;
	}

	public List<Glumac> getGlumacs() {
		return this.glumacs;
	}

	public void setGlumacs(List<Glumac> glumacs) {
		this.glumacs = glumacs;
	}

	@Override
	public String toString() {
		return "Fiilm [sifra=" + sifra + ", godina=" + godina + ", naziv=" + naziv + ", zanr=" + zanr + "]";
	}
	
	

}