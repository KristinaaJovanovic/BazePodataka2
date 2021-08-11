package crud;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Fiilm;
import model.Glumac;
import utils.PersistenceUtil;

public class FiilmCrud {
	
	public void insertFilm(Fiilm f) {
		EntityManager em=PersistenceUtil.getEntityManager();
		EntityTransaction et=null;
		
		try {
			et=em.getTransaction();
			et.begin();
			em.persist(f); //-->insert
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
	
	//showing all movies
	public List<Fiilm> listFilm(){
		EntityManager em=PersistenceUtil.getEntityManager();
		List<Fiilm> filmovi=em.createQuery("select f from Fiilm f order by f.naziv").getResultList(); //--> HQL
		em.close();
		return filmovi;
	}
	
	public Fiilm findFilm(int sifra) {
		EntityManager em=PersistenceUtil.getEntityManager();
		Fiilm film=em.find(Fiilm.class, sifra);
		em.close();
		return film;
	}
	
	public void deleteFilm(Fiilm f) {
		EntityManager em=PersistenceUtil.getEntityManager();
		EntityTransaction et=null;
		
		try {
			et=em.getTransaction();
			et.begin();
			f=em.merge(f);
			List<Glumac> glumci=f.getGlumacs();
			
			for(Glumac g: glumci) {
				g.getFiilms().remove(f);
				em.merge(g);
			}
			
			em.remove(f);
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
	
	public void promeniZanr(Fiilm f, String zanr) {
		EntityManager em=PersistenceUtil.getEntityManager();
		EntityTransaction et=null;
		
		try {
			et=em.getTransaction();
			et.begin();
			f=em.merge(f);
			f.setZanr(zanr);
			em.merge(f);
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
