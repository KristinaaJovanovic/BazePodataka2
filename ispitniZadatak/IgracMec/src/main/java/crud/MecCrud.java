package crud;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.Igrac;
import model.Mec;
import utils.PersistenceUtil;

public class MecCrud {
	
	public void insertMec(Mec m) {
		EntityManager em=PersistenceUtil.getEntityManager();
		EntityTransaction et=null;
		
		try {
			et=em.getTransaction();
			et.begin();

			em.persist(m);
			
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
	
	public List<Mec> listMeceva(){
		EntityManager em=PersistenceUtil.getEntityManager();
		List<Mec> mecevi=em.createQuery("select m from Mec m").getResultList();
		em.close();
		return mecevi;
	}
	
	public List<Mec> meceviKojiSuOdigrani(Igrac i){
		EntityManager em=PersistenceUtil.getEntityManager();
		List<Mec> mecevi=null;
		String upit="select m from Mec m join fetch m.igrac2 where m.igrac1=:x";
		//String upit="select i from Igrac i join fetch i."
		Query q=em.createQuery(upit);
		q.setParameter("x", i);
		mecevi=q.getResultList();
		em.close();
		return mecevi;
	}

}
