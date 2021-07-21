package kolokvijum;

public class Film {
	private int sifra;
	private String naziv;
	private int godina;
	private String zanr;
	
	public Film() {
		
	}

	public Film(int sifra, String naziv, int godina, String zanr) {
		super();
		this.sifra = sifra;
		this.naziv = naziv;
		this.godina = godina;
		this.zanr = zanr;
	}

	public int getSifra() {
		return sifra;
	}

	public void setSifra(int sifra) {
		this.sifra = sifra;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public int getGodina() {
		return godina;
	}

	public void setGodina(int godina) {
		this.godina = godina;
	}

	public String getZanr() {
		return zanr;
	}

	public void setZanr(String zanr) {
		this.zanr = zanr;
	}
	
	

}
