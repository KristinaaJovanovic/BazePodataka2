package model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the oblast database table.
 * 
 */
@Entity
@NamedQuery(name="Oblast.findAll", query="SELECT o FROM Oblast o")
public class Oblast implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int oblastId;

	private String oblastNaziv;

	//bi-directional many-to-many association to Knjiga
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
		name="pripada"
		, joinColumns={
			@JoinColumn(name="oblastId")
			}
		, inverseJoinColumns={
			@JoinColumn(name="knjigaId")
			}
		)
	private List<Knjiga> knjigas;

	public Oblast() {
		this.knjigas=new ArrayList<Knjiga>();
	}

	public int getOblastId() {
		return this.oblastId;
	}

	public void setOblastId(int oblastId) {
		this.oblastId = oblastId;
	}

	public String getOblastNaziv() {
		return this.oblastNaziv;
	}

	public void setOblastNaziv(String oblastNaziv) {
		this.oblastNaziv = oblastNaziv;
	}

	public List<Knjiga> getKnjigas() {
		return this.knjigas;
	}

	public void setKnjigas(List<Knjiga> knjigas) {
		this.knjigas = knjigas;
	}

}