package no.hvl.dat109.spill;

import java.util.List;

public class Brikke {
	
	private Rute plass;
	private List<Stige> stiger;
	private List<Slange> slanger;
	
	public Brikke(List<Stige> stiger, List<Slange> slanger) {
		this.stiger = stiger;
	    this.slanger = slanger;
	    this.plass = new Rute(0, stiger, slanger); // Startposisjon
	}
	
    public void flyttBrikke(int nyPosisjon) {
        this.plass = new Rute(nyPosisjon, stiger, slanger); 
    }
    
    public void sjekkForStigerOgSlanger() {
        for (Stige stige : stiger) {
            if (plass.getRute() == stige.getStartPos().getRute()) {
                System.out.println("⬆ Du fant en stige!");
                plass = stige.getSluttPos();
                System.out.println("Går opp til rute " + plass.getRute());
                break; 
            }
        }

        for (Slange slange : slanger) {
            if (plass.getRute() == slange.getStartPos().getRute()) {
                System.out.println("🐍 Ånei! Du ble bitt av en slange!");
                plass = slange.getSluttPos(); 
                System.out.println("Går ned til rute " + plass.getRute());
                break;
            }
        }
    }

	public Rute getRute() {
		return plass;
	}

	public void setRute(Rute rute) {
		this.plass = rute;
	}
	
	
	
	
	

	
}