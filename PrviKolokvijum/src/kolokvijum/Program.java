package kolokvijum;

public class Program {

	public static void main(String[] args) {
		Glumac g=new Glumac(7, "Vin", "Diesel", 1967);
		
		DBF.unesiGlumca(g);
		
		if(DBF.izmeniHonorar(1, 83000.000))
			System.out.println("Uspesno smo izmenili honorar!");
		else
			System.out.println("Nismo uspesno izmenili honorar");
		
		if(DBF.obrisiFilm(5))
			System.out.println("Uspesno brisanje!");
		else
			System.out.println("Neuspesno brisanje!");
		
		DBF.prikaziFilm(4);
		
		
		DBConnection.closeConnection();

	}

}
