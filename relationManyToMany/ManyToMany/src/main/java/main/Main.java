package main;

import crud.FiilmCrud;
import crud.GlumacCrud;
import model.Fiilm;
import model.Glumac;

public class Main {

	public static void main(String[] args) {
		
		FiilmCrud fc=new FiilmCrud();
		GlumacCrud gc=new GlumacCrud();
		
		/*Glumac g=new Glumac();
		g.setIme("Vin");
		g.setPrezime("Diesel");
		g.setGodinaRodjenja(1967);
		
		Fiilm f=new Fiilm();
		f.setNaziv("The Fast & Furious");
		f.setGodina(2021);
		f.setZanr("akcija");
		
		//inserting in database
		fc.insertFilm(f);
		gc.insertGlumac(g);
		*/
		
		Glumac g=gc.findGlumac(7);
		Fiilm f=fc.findFilm(7);
		
		gc.poveziGlumcaIFilm(g, f); //now, they appear in table glumi
		
		gc.deleteGlumac(g);
		

	}

}
