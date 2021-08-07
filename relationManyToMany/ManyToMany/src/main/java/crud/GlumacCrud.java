package crud;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Fiilm;
import model.Glumac;
import utils.PersistenceUtil;

public class GlumacCrud {
	
	public void insertGlumac(Glumac g) {
		EntityManager em=PersistenceUtil.getEntityManager();
		EntityTransaction et=null;
		
		try {
			et=em.getTransaction();
			et.begin();
			em.persist(g); //-->insert
			em.flush(); // -->synchronizing memory with the database
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
	
	//showing all the actors
	public List<Glumac> listGlumac(){
		EntityManager em=PersistenceUtil.getEntityManager();
		List<Glumac> glumci=em.createQuery("select g from Glumac g order by g.ime").getResultList(); //--> HQL
		em.close();
		return glumci;
	}
	
	/*now I want to connect the actor with his role in the film*/
	public void poveziGlumcaIFilm(Glumac g, Fiilm f) {
		EntityManager em=PersistenceUtil.getEntityManager();
		EntityTransaction et=null;
		
		try {
			et=em.getTransaction();
			et.begin();
			g=em.merge(g); //switches to the active state
			f=em.merge(f);
			g.getFiilms().add(f);
			f.getGlumacs().add(g);
			em.merge(g); //-->update
			em.merge(f); //--> update
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
	
	public Glumac findGlumac(int id) {
		EntityManager em=PersistenceUtil.getEntityManager();
		Glumac glumac=em.find(Glumac.class, id);
		em.close();
		return glumac;
	}
	
	public List<Glumac> glumciUFilmu(Fiilm f){
		EntityManager em=PersistenceUtil.getEntityManager();
		List<Glumac> glumci=f.getGlumacs();
		em.close();
		return glumci;
	}
	
	public void deleteGlumac(Glumac g) {
		EntityManager em=PersistenceUtil.getEntityManager();
		EntityTransaction et=null;
		
		try {
			et=em.getTransaction();
			et.begin();
			g=em.merge(g);
			List<Fiilm> filmovi=g.getFiilms();
			
			for(Fiilm f: filmovi) {
				f.getGlumacs().remove(g);
				em.merge(f);
			}
			
			em.remove(g);
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
