package main;

import crud.IgracCrud;
import model.Igrac;

public class GlavniProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IgracCrud ic=new IgracCrud();
		Igrac i=new Igrac();
		
		i.setIgracIme("Ana");
		i.setIgracPrezime("Ivanovic");
		ic.insertIgrac(i);
		
		
		System.exit(0);

	}

}
