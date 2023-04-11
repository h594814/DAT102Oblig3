package oppgaver;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class avdelingDAO {
	
	private final EntityManagerFactory emf;

	public avdelingDAO() {
		emf = Persistence.createEntityManagerFactory("oblig3PU");
	}

	/**
	 * Finner en Avdeling med gitt ID
	 *
	 * @param avdelingID Integer id til avdeling
	 *
	 * @return Referanse til Avdeling
	 */
	public avdeling finnAvdelingMedID(int avdelingID) {

		try (EntityManager em = emf.createEntityManager()) {
			return em.find(avdeling.class, avdelingID);
		}
	}

	/**
	 * Returnerer en List med alle rader i tabellen
	 *
	 * @return List med alle Avdeling i tabell
	 */
	public List<avdeling> finnAlleAvdelinger() {

		try (EntityManager em = emf.createEntityManager()) {
			String             ql = "select a from avdeling as a where a.avdeling_id > 1";
			TypedQuery<avdeling> q  = em.createQuery(ql, avdeling.class);
			return q.getResultList();
		}
	}

}
