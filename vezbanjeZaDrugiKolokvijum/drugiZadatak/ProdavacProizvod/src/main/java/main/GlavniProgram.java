package main;

import crud.ProdavacCrud;
import model.Prodavac;

public class GlavniProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProdavacCrud pc=new ProdavacCrud();
		Prodavac p=new Prodavac();
		
		p.setIme("Kristina");
		p.setPrezime("Jovanovic");
		p.setAdresa("Vucak BB");
		pc.insertProdavac(p);
		
		
		

	}

}
