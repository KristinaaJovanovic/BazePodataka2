package crud;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Vrsta;
import utils.PersistenceUtil;

public class VrstaCrud {
	
	public void insertVrsta(Vrsta v) {
		EntityManager em=PersistenceUtil.getEntityManager();
		EntityTransaction et=null;
		
		try {
			et=em.getTransaction();
			et.begin();
			
			em.persist(v);
			
			em.flush();
			et.commit();
		}catch(Exception e) {
			e.printStackTrace();
			if(et!=null)
				et.rollback();
		}finally {
			if(em!=null && em.isOpen())
				em.close();
		}
	}
	
	public List<Vrsta> listVrste(){
		EntityManager em=PersistenceUtil.getEntityManager();
		List<Vrsta> lista=em.createQuery("select v from Vrsta v").getResultList();
		em.close();
		return lista;
	}

}
