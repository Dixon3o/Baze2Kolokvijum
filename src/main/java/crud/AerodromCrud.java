package crud;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import model.Caerodrom;
import model.Cgrad;
import model.Clet;

public class AerodromCrud {
	
	public boolean deleteAerodrom(Caerodrom a) {
		EntityManager em = utils.PersistenceUtil.getEntityManager();
		EntityTransaction et = null;
		boolean u = false;
		try {
			
			et = em.getTransaction();
			et.begin();
			
			a = em.merge(a);
			List<Clet> letovi1 = a.getClets1();
			for(Clet l : letovi1) {
				em.remove(l);
			}
			List<Clet> letovi2 = a.getClets2();
			for(Clet l : letovi2) {
				em.remove(l);
			}
			
			a = em.merge(a);
			em.remove(a);
			
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
	
	public List<Caerodrom> lista(){
		EntityManager em = utils.PersistenceUtil.getEntityManager();
		String upit = "select a from Caerodrom a order by a.aerodromId";
		List<Caerodrom> lista = em.createQuery(upit).getResultList();
		em.close();
		return lista;
	}

}
