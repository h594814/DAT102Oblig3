package oppgaver;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;


public class ansattDAO {
	
	private final EntityManagerFactory emf;

	public ansattDAO() {
		emf = Persistence.createEntityManagerFactory("oblig3PU");
	}

	public ansatt finnAnsattMedAnsattID(int ansatt_id) {

		EntityManager em = emf.createEntityManager();
		
		try  {
			return em.find(ansatt.class, ansatt_id);
		} finally {
			em.close();
		}
}
	
	public ansatt sokEtterAnsattMedInitialer(String brukernavn) {
        EntityManager em = emf.createEntityManager();
           try {
               
               TypedQuery<ansatt> query = em.createQuery("SELECT b FROM ansatt b WHERE b.brukernavn LIKE :brukernavn", ansatt.class);
               query.setParameter("brukernavn", brukernavn);

               return query.getSingleResult();
           
               
               
           } finally {
               em.close();
           }
}
	
	public List<ansatt> finnAlleAnsatte() {
		
		EntityManager em = emf.createEntityManager();
		
		try {
			TypedQuery<ansatt> query = em.createQuery("SELECT a FROM ansatt a", ansatt.class);

			return query.getResultList();

		} finally {
			em.close();
		}
	}
	
	public void oppdatereAnsatt(int ansatt_id, double maanedslonn, String stilling) {
	    EntityManager em = emf.createEntityManager();
	    EntityTransaction tx = em.getTransaction();
	    
	    try {
	        tx.begin();
	        
	        ansatt endreansatt = em.find(ansatt.class, ansatt_id);
	        endreansatt.setMaanedslonn(maanedslonn);
	        endreansatt.setStilling(stilling);
	        
	        tx.commit();
	    } catch (Throwable e) {
	        e.printStackTrace();
	        if (tx.isActive()) {
	            tx.rollback();
	        }
	    } finally {
	        em.close();
	    }
	}
	
	public void lageNyAnsatt(String brukernavn, String fornavn, String etternavn, LocalDate ansettelsesdato,
	        String stilling, double maanedslonn) {
	    
	    EntityManager em = emf.createEntityManager();
	    EntityTransaction tx = em.getTransaction();

	    try {
	        tx.begin();
	        
	        ansatt nyansatt = new ansatt(brukernavn, fornavn, etternavn, ansettelsesdato, stilling, maanedslonn);
	        em.persist(nyansatt);
	        
	        tx.commit();
	        
	    } catch (Throwable e) {
	        e.printStackTrace();
	        if (tx.isActive()) {
	            tx.rollback();
	        }
	    } finally {
	        em.close();
	    }
	}
	
	
}
