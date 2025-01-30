package no.hvl.dat109.Tester;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.hvl.dat109.spill.Slange;
import no.hvl.dat109.spill.SlangeDAO;

class SlangeDAOTest {

    private SlangeDAO slangeDAO;

    @BeforeEach
    void setUp() {
        slangeDAO = new SlangeDAO(); // Opprett en ny DAO før hver test
    }

    @Test
    void testHentAlleSlanger() {
        // Hent slangene fra databasen
    	List<Slange> slanger = slangeDAO.hentAlleSlanger();
    	assertNotNull(slanger, "Listen over slanger skal ikke være null.");
    	assertTrue(!slanger.isEmpty(), "Listen over slanger skal ikke være tom");
    }
}
