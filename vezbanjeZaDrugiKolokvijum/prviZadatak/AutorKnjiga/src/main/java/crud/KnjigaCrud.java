package crud;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Knjiga;
import model.Oblast;
import utils.PersistenceUtil;

public class KnjigaCrud {
	
	public void insertKnjiga(Knjiga k) {
		EntityManager em=PersistenceUtil.getEntityManager();
		EntityTransaction et=null;
		
		try {
			et=em.getTransaction();
			et.begin();
			
			em.persist(k);
			
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
	
	public void poveziKnjiguIOblast(Knjiga k, Oblast o) {
		EntityManager em=PersistenceUtil.getEntityManager();
		EntityTransaction et=null;
		
		try {
			et=em.getTransaction();
			et.begin();
			
			k=em.merge(k);
			o=em.merge(o);
			
			k.getOblasts().add(o);
			o.getKnjigas().add(k);
			
			em.merge(k);
			em.merge(o);
			
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
	
	public void deleteKnjiga(Knjiga k) {
		EntityManager em=PersistenceUtil.getEntityManager();
		EntityTransaction et=null;
		
		try {
			et=em.getTransaction();
			et.begin();
			
			k=em.merge(k);
			List<Oblast> oblasti=k.getOblasts();
			for(Oblast o: oblasti) {
				o.getKnjigas().remove(k);
				em.merge(o);
			}
			
			em.remove(k);
			
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
	
	public List<Knjiga> listKnjiga(){
		EntityManager em=PersistenceUtil.getEntityManager();
		List<Knjiga> knjige=em.createQuery("select k from Knjiga k order by k.knjigaNaziv").getResultList();
		em.close();
		return knjige;
	}
	
	public Knjiga findKnjiga(int id) {
		EntityManager em=PersistenceUtil.getEntityManager();
		Knjiga k=em.find(Knjiga.class, id);
		em.close();
		return k;
	}

	public List<Knjiga> knjigeKojePripadajuOblasti(Oblast o){
		EntityManager em=PersistenceUtil.getEntityManager();
		List<Knjiga> knjige=o.getKnjigas();
		em.close();
		return knjige;
	}
}
