package no.hvl.dat109.Tester;



import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import no.hvl.dat109.spill.Stige;
import no.hvl.dat109.spill.StigeDAO;

public class StigeDAOTest {
	private StigeDAO stigeDAO;
	
	@BeforeEach
	void setUp() {
		stigeDAO = new StigeDAO();
	}
	
	@Test
	void testHentAlleStiger() {
		// Hent stigene fra databasen
		List<Stige> stiger = stigeDAO.hentAlleStiger();
		assertNotNull(stiger, "Listen over stiger skal ikke være null.");
		assertTrue(!stiger.isEmpty(), "Listen over stiger skal ikke være tom");
	}

}
