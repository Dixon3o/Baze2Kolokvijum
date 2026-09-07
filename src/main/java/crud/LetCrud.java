package crud;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import model.Caerodrom;
import model.Clet;

public class LetCrud {
	
	public boolean insertLet(Clet l) {
		EntityManager em = utils.PersistenceUtil.getEntityManager();
		EntityTransaction et = null;
		boolean u = false;
		try {
			
			et = em.getTransaction();
			et.begin();
			
			em.persist(l);
			
			em.flush();
			et.commit();
			u = true;
			
		}catch(Exception ex) {
			ex.printStackTrace();
			if(et != null) {
				et.rollback();
			}
		}finally {
			if(em != null) {
				em.close();
			}
		}
		return u;
	}
	
	public List<Clet> listaLetovaZaAerodrom(Caerodrom a){
		
		EntityManager em = utils.PersistenceUtil.getEntityManager();
		a = em.merge(a);
		a.getClets1().size();
		List<Clet> letovi = a.getClets1();
		em.close();
		return letovi;
		
	}

}
