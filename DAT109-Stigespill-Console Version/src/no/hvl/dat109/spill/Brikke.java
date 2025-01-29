package no.hvl.dat109.spill;

import java.util.List;

public class Brikke {
	
	private String farge;
	private Rute rute;
	private List<Stige> stiger;
	private List<Slange> slanger;
	
	public Brikke(List<Stige> stiger, List<Slange> slanger) {
		this.stiger = stiger;
	    this.slanger = slanger;
	    this.rute = new Rute(0, stiger, slanger); // Startposisjon
	}
	
    public void flyttBrikke(int nyPosisjon) {
        this.rute = new Rute(nyPosisjon, stiger, slanger); 
    }
    
    // Metode for å sjekke om brikken er på en stige eller slange
    public void sjekkForStigerOgSlanger() {
    	// Sjekker for stiger først
        for (Stige stige : stiger) {
            if (rute.getRute() == stige.getStartPos().getRute()) {
                System.out.println("⬆ Du fant en stige!");
                rute = stige.getSluttPos();
                System.out.println("Går opp til rute " + rute.getRute());
                break; 
            }
        }

        // Sjekker deretter for slanger
        for (Slange slange : slanger) {
            if (rute.getRute() == slange.getStartPos().getRute()) {
                System.out.println("🐍 Ånei! Du ble bitt av en slange!");
                rute = slange.getSluttPos(); 
                System.out.println("Går ned til rute " + rute.getRute());
                break; // Når en slange er funnet, slutter vi å lete
            }
        }
    }
	
	public String getFarge() {
		return farge;
	}
	
	public void setFarge(String farge) {
		this.farge = farge;
	}

	public Rute getRute() {
		return rute;
	}

	public void setRute(Rute rute) {
		this.rute = rute;
	}
	
	
	
	
	

	
}