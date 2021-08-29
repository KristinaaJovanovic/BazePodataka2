package crud;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Prodavac;
import model.Proizvod;
import utils.PersistenceUtil;

public class ProizvodCrud {
	
	public void insertProizvod(Proizvod p) {
		EntityManager em=PersistenceUtil.getEntityManager();
		EntityTransaction et=null;
		
		try {
			et=em.getTransaction();
			et.begin();
			
			em.persist(p);
			
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
	
	public List<Proizvod> listProizvod(){
		EntityManager em=PersistenceUtil.getEntityManager();
		List<Proizvod> proizvodi=em.createQuery("select p from Proizvod p").getResultList();
		em.close();
		return proizvodi;
	}
	
	public Proizvod findProizvod(int spr) {
		EntityManager em=PersistenceUtil.getEntityManager();
		Proizvod p=em.find(Proizvod.class, spr);
		em.close();
		return p;
	}
	
	

}
