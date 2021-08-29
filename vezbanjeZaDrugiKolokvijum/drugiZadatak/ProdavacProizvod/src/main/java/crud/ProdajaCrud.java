package crud;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.Prodaja;
import model.ProdajaPK;
import model.Prodavac;
import model.Proizvod;
import utils.PersistenceUtil;

public class ProdajaCrud {
	
	public void insertProdaja(Prodavac p, Proizvod pr, double kolicina, String datum) {
		EntityManager em=PersistenceUtil.getEntityManager();
		EntityTransaction et=null;
		
		try {
			et=em.getTransaction();
			et.begin();
			
			p=em.merge(p);
			pr=em.merge(pr);
			Prodaja prodaja=new Prodaja();
			prodaja.setDatum(datum);
			prodaja.setKolicina(kolicina);
			prodaja.setProdavac(p);
			prodaja.setProizvod(pr);
			ProdajaPK kljuc=new ProdajaPK();
			kljuc.setIdp(p.getIdp());
			kljuc.setSifp(pr.getSifp());
			prodaja.setId(kljuc);
			
			p.addProdaja(prodaja);
			pr.addProdaja(prodaja);
			
			em.persist(prodaja);
			em.merge(p);
			em.merge(pr);
			
			em.persist(prodaja);
			
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
	
	public List<Prodaja> prodatiProizvodi(Prodavac p){
		EntityManager em=PersistenceUtil.getEntityManager();
		String upit="select p from Prodavac p join fetch p.prodajas where p.idp=:x";
		Query q=em.createQuery(upit);
		q.setParameter("x", p.getIdp());
		Prodavac pr=(Prodavac) q.getSingleResult();
		em.close();
		return pr.getProdajas();
	}

}
