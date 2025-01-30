package no.hvl.dat109.spill;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class SlangeDAO {

	private EntityManagerFactory emf;

	public SlangeDAO() {
		emf = Persistence.createEntityManagerFactory("slangespillPersistenceUnit");
	}

	public List<Slange> hentAlleSlanger() {
		EntityManager em = emf.createEntityManager();

		try {
			String q = "SELECT s FROM Slange s";
			TypedQuery<Slange> query = em.createQuery(q, Slange.class);

			List<Slange> resultList = query.getResultList();
			return resultList;
		} catch (NoResultException e) {
			System.out.println("Ingen slange funnet i databasen.");
			return null;
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			return null;
		} finally {
			em.close();
		}
	}

}
