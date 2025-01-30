package no.hvl.dat109.Tester;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import no.hvl.dat109.spill.Terning;
public class TerningTest {

	private Terning terning;
	
	@BeforeEach
	void setUp() {
		terning= new Terning();
	}
	@Test
	void testTerningVerdi() {
		int verdi = terning.trill();
		assertTrue(verdi>=1 && verdi <=6); //Terningkast skal være mellom 1-6
	}
	
	@RepeatedTest(100)
	void testTilfeldigVerdi() {
		int verdi = terning.trill();
		assertTrue(verdi>=1 && verdi <=6); //Terningkast skal være mellom 1-6
	}
	
}
