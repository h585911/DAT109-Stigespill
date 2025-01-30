package Tester;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import no.hvl.dat109.spill.Brikke;
import no.hvl.dat109.spill.Slange;
import no.hvl.dat109.spill.Spiller;
import no.hvl.dat109.spill.Stige;
import no.hvl.dat109.spill.Terning;


public class spillerTest {
	private Spiller spiller;
	private Brikke brikke;
	private Terning terning;

	@BeforeEach
	void setUp() {
		
		//oppretter en liste uten stiger eller slange

		List<Stige> stiger = new ArrayList<>();
		List<Slange> slanger = new ArrayList<>();

		// oppretter en brikke på startposisjon
		brikke = new Brikke(stiger, slanger);
		// oppretter spilleren
		spiller = new Spiller("Teresa", brikke);

		terning = new Terning(); // lager en falsk terning
		
		spiller.getBrikke().flyttBrikke(0);
	}

	
	@Test
	void testSpillerStarterPaaPosisjon0() {
		//Spiller skal starte på rute 0, henter frøst rute objektet, og deretter int verdien, derfor getRute() to ganger
		assertEquals(0, spiller.getBrikke().getRute().getRute()); 
	}
	
	@Test
	void testFlytterKorrekt() {
		int startpos = spiller.getBrikke().getRute().getRute();//default starter på 0
		
		spiller.spilltrekk(terning);
		
		int nypos= spiller.getBrikke().getRute().getRute();
		
		//sjekker om brikken flyttes riktig i forhold til kaste( et tall(nypos) == 0(Startpos) +  et tall(nypos))
		assertEquals(nypos,(startpos+ nypos)); 
	}
	@Test
	void testSpillerFårEkstraKastHvisFørsteErSeks() {
    int startpos = spiller.getBrikke().getRute().getRute(); // Lagre startposisjon

    spiller.spilltrekk(terning); // Spilleren gjør første trekk

    int posEtterFørsteTrekk = spiller.getBrikke().getRute().getRute(); // Posisjon etter første kast

    if (posEtterFørsteTrekk > startpos) { 
    

        // Vi gjør et nytt spilltrekk for å se om det er en ekstra kast
        spiller.spilltrekk(terning);
        int nypos = spiller.getBrikke().getRute().getRute(); // Ny posisjon etter andre trekk

        assertTrue(nypos > posEtterFørsteTrekk, 
                   "Spilleren skal ha flyttet seg videre etter et ekstra kast.");
    } else {
        // Hvis spilleren ikke flyttet seg, betyr det at de ikke fikk en 6-er
        assertEquals(startpos, spiller.getBrikke().getRute().getRute(), 
                     "Spilleren skal ikke flytte hvis første kast ikke var 6.");
    }
}

	@Test
	void testSpillerBlirStåendeHvisKastErForHøyt() {
	    spiller.getBrikke().flyttBrikke(98); // Sett spilleren på rute 98
	     int startpos= spiller.getBrikke().getRute().getRute();
	    
	     spiller.spilltrekk(terning); //kaster terning
	     
	     int nypos= spiller.getBrikke().getRute().getRute();
	    
	     //spilelr blir stående om kaste er større enn 2
	    if(nypos==startpos) {
	    	 assertEquals(98, nypos);
	    } else{
	    	assertTrue(nypos>98 && startpos<=100);
	    }
	   }
	
	@Test
	void testGårTilbakeTilStartEtterTreSeksere() {
		
		int sekserTeller=0;
		for(int i=0; i<3; i++) {
			int kast=terning.trill();
			if(kast==6) {
			sekserTeller++;
		}else {
			sekserTeller=0;
		}
			spiller.spilltrekk(terning);
	}
		if(sekserTeller==3) {
			assertEquals(0, spiller.getBrikke().getRute().getRute());
		}
	
	}
	
	@Test
	void testKanKasteTerning() {
	    spiller.setKanKasteTerning(true);
	    assertTrue(spiller.kanKasteTerning(), "Spilleren skal kunne kaste terning.");

	    spiller.setKanKasteTerning(false);
	    assertFalse(spiller.kanKasteTerning(), "Spilleren skal ikke kunne kaste terning.");
	}

	@Test
	void testSpillerVinnerNårDeNårRute100() {
	    spiller.getBrikke().flyttBrikke(99); // Sett spilleren på rute 99
	    
	    spiller.spilltrekk(terning);
	    
	    int nypos= spiller.getBrikke().getRute().getRute();
	    		 
	    if(nypos==100) {
	    assertEquals(100, spiller.getBrikke().getRute().getRute(),
	    		"Spilleren skal vinne spillet ved å nå rute 100.");
	    }
	    else {
	    	assertEquals(99, nypos, "Spilleren skal forbli på samme sted");
	    }
	    
	    
	}
}

	
	

	



	
	
	
	

