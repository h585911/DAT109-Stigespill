package no.hvl.dat109.Tester;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.hvl.dat109.spill.Slange;
import no.hvl.dat109.spill.SlangeDAO;

/**
 * Testklasse for SlangeDAO som verifiserer at henting av slanger fra databasen fungerer.
 */
class SlangeDAOTest {

	/**
	 * Referanse til SlangeDAO (Data Access Object) klassen.
	 */
    private SlangeDAO slangeDAO;

    /**
     * Initialiserer en ny SlangeDAO før hver test.
     */
    @BeforeEach
    void setUp() {
        slangeDAO = new SlangeDAO();
    }

    /**
     * Tester om metoden hentAlleSlanger() returnerer en liste som ikke er null, og som ikke er tom.
     * Dette verifiserer at metoden henter data fra databasen.
     */
    @Test
    void testHentAlleSlanger() {
    	List<Slange> slanger = slangeDAO.hentAlleSlanger();
    	assertNotNull(slanger, "Listen over slanger skal ikke være null.");
    	assertTrue(!slanger.isEmpty(), "Listen over slanger skal ikke være tom");
    }
}