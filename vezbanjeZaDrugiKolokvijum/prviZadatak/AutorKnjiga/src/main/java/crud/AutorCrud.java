package crud;

import java.util.List;

import javax.persistence.EntityManager;

import model.Autor;
import model.Knjiga;
import utils.PersistenceUtil;

public class AutorCrud {
	
	public List<Autor> listAutora(){
		EntityManager em=PersistenceUtil.getEntityManager();
		List<Autor> autori=em.createQuery("select a from Autor a").getResultList();
		em.close();
		return autori;
	}
	public Autor findAutor(int id) {
		EntityManager em=PersistenceUtil.getEntityManager();
		Autor a=em.find(Autor.class, id);
		em.close();
		return a;
	}

}
