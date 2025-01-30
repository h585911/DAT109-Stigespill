package Tester;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import no.hvl.dat109.spill.Brikke;
import no.hvl.dat109.spill.Slange;
import no.hvl.dat109.spill.Spiller;
import no.hvl.dat109.spill.Stige;
import no.hvl.dat109.spill.Terning;

public class spillerTest {
	private Spiller spiller;
	private Brikke brikke;
	private Terning mockTerning;

	@BeforeEach
	void setUUp() {

		// oppretter en liste uten stiger eller slange
		List<Stige> stiger = new ArrayList<>();
		List<Slange> slanger = new ArrayList<>();

		// oppretter en brikke på startposisjon
		brikke = new Brikke(stiger, slanger);
		// oppretter spilleren
		spiller = new Spiller("Teresa", brikke);

		mockTerning = Mockito.mock(Terning.class); // lager en falsk terning
	}

	// @Test
	// void testSpillerStart

}
