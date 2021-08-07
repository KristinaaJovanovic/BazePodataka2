package model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the glumac database table.
 * 
 */
@Entity
@NamedQuery(name="Glumac.findAll", query="SELECT g FROM Glumac g")
public class Glumac implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idg;

	private int godinaRodjenja;

	private String ime;

	private String prezime;

	//bi-directional many-to-many association to Fiilm
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
		name="glumi"
		, joinColumns={
			@JoinColumn(name="idg")
			}
		, inverseJoinColumns={
			@JoinColumn(name="sifra")
			}
		)
	private List<Fiilm> fiilms;

	public Glumac() {
		fiilms=new ArrayList<Fiilm>();
	}

	public int getIdg() {
		return this.idg;
	}

	public void setIdg(int idg) {
		this.idg = idg;
	}

	public int getGodinaRodjenja() {
		return this.godinaRodjenja;
	}

	public void setGodinaRodjenja(int godinaRodjenja) {
		this.godinaRodjenja = godinaRodjenja;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return this.prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public List<Fiilm> getFiilms() {
		return this.fiilms;
	}

	public void setFiilms(List<Fiilm> fiilms) {
		this.fiilms = fiilms;
	}

	@Override
	public String toString() {
		return "Glumac [idg=" + idg + ", godinaRodjenja=" + godinaRodjenja + ", ime=" + ime + ", prezime=" + prezime
				+ "]";
	}
	
	

}