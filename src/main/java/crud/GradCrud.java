package crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import model.Cgrad;

public class GradCrud {

	public boolean insertGrad(Cgrad g) {
		EntityManager em = utils.PersistenceUtil.getEntityManager();
		EntityTransaction et = null;
		boolean u = false;
		try {
			
			et = em.getTransaction();
			et.begin();
			
			em.persist(g);
			
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
	
}
