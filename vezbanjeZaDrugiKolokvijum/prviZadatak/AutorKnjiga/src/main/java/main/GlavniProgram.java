package main;

import java.util.List;

import crud.AutorCrud;
import crud.KnjigaCrud;
import model.Autor;
import model.Knjiga;

public class GlavniProgram {

	public static void main(String[] args) {
		KnjigaCrud kc=new KnjigaCrud();
		AutorCrud ac=new AutorCrud();
		
		Autor autor=ac.findAutor(3);
		
		Knjiga k=new Knjiga();
		k.setKnjigaNaziv("Moc podsvesti");
		k.setAutor(autor);
		kc.insertKnjiga(k);
		
		List<Knjiga> knjige=kc.listKnjiga();
		for(Knjiga kn: knjige) {
			System.out.println(kn);
		}
		
	}

}
