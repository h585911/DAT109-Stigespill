package no.hvl.dat109.spill;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

/* 
 * DAO-klasse for Stige-objekter som håndterer DB-operasjoner
*/
public class StigeDAO {

	private EntityManagerFactory emf;

	// Konstruktør som håndterer databasekommunikasjon
	public StigeDAO() {
		emf = Persistence.createEntityManagerFactory("slangespillPersistenceUnit");
	}

	// Henter alle stiger fra databasen
	// Returnerer en liste av alle Stige-objekter, eller null hvis ingen finnes.
	public List<Stige> hentAlleStiger() {
		EntityManager em = emf.createEntityManager();

		try {
			String q = "SELECT s FROM Stige s";
			TypedQuery<Stige> query = em.createQuery(q, Stige.class);

			List<Stige> resultList = query.getResultList();
			return resultList;
		} catch (NoResultException e) {
			System.out.println("Ingen stige funnet i databasen.");
			return null;
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			return null;
		} finally {
			em.close();
		}
	}

}
