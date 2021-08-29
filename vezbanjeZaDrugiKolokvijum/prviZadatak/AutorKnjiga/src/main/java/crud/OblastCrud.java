package crud;

import java.util.List;

import javax.persistence.EntityManager;

import model.Oblast;
import utils.PersistenceUtil;

public class OblastCrud {
	
	public List<Oblast> listOblasti(){
		EntityManager em=PersistenceUtil.getEntityManager();
		List<Oblast> oblasti=em.createQuery("select o from Oblast o").getResultList();
		em.close();
		return oblasti;
	}

}
