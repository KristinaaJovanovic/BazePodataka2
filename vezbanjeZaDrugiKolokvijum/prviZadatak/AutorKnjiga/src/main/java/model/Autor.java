package model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the autor database table.
 * 
 */
@Entity
@NamedQuery(name="Autor.findAll", query="SELECT a FROM Autor a")
public class Autor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int autorId;

	private String autorIme;

	private String autorPrezime;

	//bi-directional many-to-one association to Knjiga
	@OneToMany(mappedBy="autor")
	private List<Knjiga> knjigas;

	public Autor() {
		this.knjigas=new ArrayList<Knjiga>();
	}

	public int getAutorId() {
		return this.autorId;
	}

	public void setAutorId(int autorId) {
		this.autorId = autorId;
	}

	public String getAutorIme() {
		return this.autorIme;
	}

	public void setAutorIme(String autorIme) {
		this.autorIme = autorIme;
	}

	public String getAutorPrezime() {
		return this.autorPrezime;
	}

	public void setAutorPrezime(String autorPrezime) {
		this.autorPrezime = autorPrezime;
	}

	public List<Knjiga> getKnjigas() {
		return this.knjigas;
	}

	public void setKnjigas(List<Knjiga> knjigas) {
		this.knjigas = knjigas;
	}

	public Knjiga addKnjiga(Knjiga knjiga) {
		getKnjigas().add(knjiga);
		knjiga.setAutor(this);

		return knjiga;
	}

	public Knjiga removeKnjiga(Knjiga knjiga) {
		getKnjigas().remove(knjiga);
		knjiga.setAutor(null);

		return knjiga;
	}

	@Override
	public String toString() {
		return "Autor [autorId=" + autorId + ", autorIme=" + autorIme + ", autorPrezime=" + autorPrezime + "]";
	}
	
	

}