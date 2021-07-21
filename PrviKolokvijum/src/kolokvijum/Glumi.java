package kolokvijum;

public class Glumi {
	private int idg;
	private int sifra;
	private String uloga;
	private double honorar;
	
	public Glumi() {
		
	}

	public Glumi(int idg, int sifra, String uloga, double honorar) {
		super();
		this.idg = idg;
		this.sifra = sifra;
		this.uloga = uloga;
		this.honorar = honorar;
	}

	public int getIdg() {
		return idg;
	}

	public void setIdg(int idg) {
		this.idg = idg;
	}

	public int getSifra() {
		return sifra;
	}

	public void setSifra(int sifra) {
		this.sifra = sifra;
	}

	public String getUloga() {
		return uloga;
	}

	public void setUloga(String uloga) {
		this.uloga = uloga;
	}

	public double getHonorar() {
		return honorar;
	}

	public void setHonorar(double honorar) {
		this.honorar = honorar;
	}
	
	

}
