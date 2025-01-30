package Tester;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import no.hvl.dat109.spill.*;
public class BrikkeTest {
	private Brikke brikke;
    private List<Stige> stiger;
    private List<Slange> slanger;

	@BeforeEach
	void setUp() {
        stiger = new ArrayList<>();
        slanger = new ArrayList<>();
        brikke = new Brikke(stiger, slanger);
}
	
	@Test
    void testFlytterBrikke() {
        brikke.flyttBrikke(10);
        assertEquals(10, brikke.getRute().getRute(), 
                     "Brikken skal flytte til rute 10.");
	}
	
	

}
