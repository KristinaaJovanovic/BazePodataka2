package crud;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Prodaja;
import model.Prodavac;
import utils.PersistenceUtil;

public class ProdavacCrud {
	
	public void deleteProdavac(Prodavac p) {
		EntityManager em=PersistenceUtil.getEntityManager();
		EntityTransaction et=null;
		
		try {
			et=em.getTransaction();
			et.begin();
			
			p=em.merge(p);
			List<Prodaja> pr=p.getProdajas();
			for(Prodaja pro: pr) {
				em.remove(pro);
			}
			em.merge(p);
			em.remove(p);
			
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
	
	public void insertProdavac(Prodavac p) {
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
	
	public List<Prodavac> listProdavci(){
		EntityManager em=PersistenceUtil.getEntityManager();
		List<Prodavac> lista=em.createQuery("select p from Prodavac p").getResultList();
		em.close();
		return lista;
	}

}
