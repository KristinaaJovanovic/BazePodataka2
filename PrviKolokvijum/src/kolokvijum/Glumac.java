package kolokvijum;

public class Glumac {
	private int idg;
	private String ime;
	private String prezime;
	private int godinaRodjenja;
	
	public Glumac() {
		
	}

	public Glumac(int idg, String ime, String prezime, int godinaRodjenja) {
		super();
		this.idg = idg;
		this.ime = ime;
		this.prezime = prezime;
		this.godinaRodjenja = godinaRodjenja;
	}

	public int getIdg() {
		return idg;
	}

	public void setIdg(int idg) {
		this.idg = idg;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public int getGodinaRodjenja() {
		return godinaRodjenja;
	}

	public void setGodinaRodjenja(int godinaRodjenja) {
		this.godinaRodjenja = godinaRodjenja;
	}
	
	

}
