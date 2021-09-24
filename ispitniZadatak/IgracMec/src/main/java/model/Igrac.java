package model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the igrac database table.
 * 
 */
@Entity
@NamedQuery(name="Igrac.findAll", query="SELECT i FROM Igrac i")
public class Igrac implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int igracId;

	private String igracIme;

	private String igracPrezime;

	//bi-directional many-to-one association to Mec
	@OneToMany(mappedBy="igrac1")
	private List<Mec> mecs1;

	//bi-directional many-to-one association to Mec
	@OneToMany(mappedBy="igrac2")
	private List<Mec> mecs2;

	public Igrac() {
		this.mecs1=new ArrayList<Mec>();
		this.mecs2=new ArrayList<Mec>();
	}

	public int getIgracId() {
		return this.igracId;
	}

	public void setIgracId(int igracId) {
		this.igracId = igracId;
	}

	public String getIgracIme() {
		return this.igracIme;
	}

	public void setIgracIme(String igracIme) {
		this.igracIme = igracIme;
	}

	public String getIgracPrezime() {
		return this.igracPrezime;
	}

	public void setIgracPrezime(String igracPrezime) {
		this.igracPrezime = igracPrezime;
	}

	public List<Mec> getMecs1() {
		return this.mecs1;
	}

	public void setMecs1(List<Mec> mecs1) {
		this.mecs1 = mecs1;
	}

	public Mec addMecs1(Mec mecs1) {
		getMecs1().add(mecs1);
		mecs1.setIgrac1(this);

		return mecs1;
	}

	public Mec removeMecs1(Mec mecs1) {
		getMecs1().remove(mecs1);
		mecs1.setIgrac1(null);

		return mecs1;
	}

	public List<Mec> getMecs2() {
		return this.mecs2;
	}

	public void setMecs2(List<Mec> mecs2) {
		this.mecs2 = mecs2;
	}

	public Mec addMecs2(Mec mecs2) {
		getMecs2().add(mecs2);
		mecs2.setIgrac2(this);

		return mecs2;
	}

	public Mec removeMecs2(Mec mecs2) {
		getMecs2().remove(mecs2);
		mecs2.setIgrac2(null);

		return mecs2;
	}

	@Override
	public String toString() {
		return "Igrac [igracId=" + igracId + ", igracIme=" + igracIme + ", igracPrezime=" + igracPrezime + "]";
	}
	
	

}