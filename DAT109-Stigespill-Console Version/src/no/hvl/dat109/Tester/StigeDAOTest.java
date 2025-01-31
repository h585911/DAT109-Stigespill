package no.hvl.dat109.Tester;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import no.hvl.dat109.spill.Stige;
import no.hvl.dat109.spill.StigeDAO;

/**
 * Testklasse for StigeDAO som verifiserer at henting av stiger fra databasen fungerer.
 */
public class StigeDAOTest {
	
	/**
	 * Referanse til StigeDAO (Data Access Object) klassen.
	 */
	private StigeDAO stigeDAO;
	
	/**
	 * Initialiserer en ny StigeDAO før hver test.
	 */
	@BeforeEach
	void setUp() {
		stigeDAO = new StigeDAO();
	}
	
	/**
	 * Tester om metoden hentAlleStiger() returnerer en liste som ikke er null, og som ikke er tom.
	 * Dette verifiserer at metoden henter data fra databasen.
	 */
	@Test
	void testHentAlleStiger() {
		// Hent stigene fra databasen
		List<Stige> stiger = stigeDAO.hentAlleStiger();
		assertNotNull(stiger, "Listen over stiger skal ikke være null.");
		assertTrue(!stiger.isEmpty(), "Listen over stiger skal ikke være tom");
	}

}
