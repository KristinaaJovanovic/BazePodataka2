package crud;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Igrac;
import model.Mec;
import utils.PersistenceUtil;

public class IgracCrud {
	
	public void insertIgrac(Igrac i) {
		EntityManager em=PersistenceUtil.getEntityManager();
		EntityTransaction et=null;
		
		try {
			et=em.getTransaction();
			et.begin();

			em.persist(i);
			
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
	
	public List<Igrac> listIgraci(){
		EntityManager em=PersistenceUtil.getEntityManager();
		List<Igrac> igraci=em.createQuery("select i from Igrac i order by i.igracIme").getResultList();
		em.close();
		return igraci;
	}
	
	public Igrac findIgrac(int id) {
		EntityManager em=PersistenceUtil.getEntityManager();
		Igrac igrac=em.find(Igrac.class, id);
		em.close();
		return igrac;
	}
	
	public void deleteIgrac(Igrac i) {
		EntityManager em=PersistenceUtil.getEntityManager();
		EntityTransaction et=null;
		
		try {
			et=em.getTransaction();
			et.begin();

			i=em.merge(i);
			List<Mec> mecs1=i.getMecs1();
			for(Mec m: mecs1) {
				em.remove(m);
			}
			em.merge(i);
			
			List<Mec> mecs2=i.getMecs2();
			for(Mec m2: mecs2) {
				em.remove(m2);
			}
			
			em.remove(i);
			
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

}
