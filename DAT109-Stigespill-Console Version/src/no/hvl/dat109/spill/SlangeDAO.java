package no.hvl.dat109.spill;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

/**
 * DAO-klasse for å håndtere databasedrift av Slange-objekter.
 */
public class SlangeDAO {
	
	private EntityManagerFactory emf; // Referanse til EntityManagerFactory
	
	/**
	 * Konstruktør som oppretter en EntityManagerFactory for persistenseenheten.
	 */
	public SlangeDAO() {
		emf = Persistence.createEntityManagerFactory("slangespillPersistenceUnit");
	}
	
	
	/**
	 * Henter alle slanger fra databasen.
	 * 
	 * @return En liste over alle slanger i databasen, eller {@code null} hvis ingen finnes.
	 */
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
