package no.hvl.dat109.spill;

import java.util.List;

/**
 * Representerer en brikke i stigespillet. Brikken kan flyttes rundt på spillebrettet
 * og interagere med stiger og slanger.
 */
public class Brikke {
	
	 /**
     * Ruten brikken befinner seg på.
     */
	private Rute plass;
	 /**
     * Liste over stiger i spillet.
     */
	private List<Stige> stiger;
	 /**
     * Liste over slanger i spillet.
     */
	private List<Slange> slanger;
	
	/**
     * Konstruktør som oppretter en brikke med tilknyttede stiger og slanger.
     * Brikken starter på rute 0, dvs. den starter utenfor brettet.
     * 
     * @param stiger Liste over stiger i spillet.
     * @param slanger Liste over slanger i spillet.
     */
	public Brikke(List<Stige> stiger, List<Slange> slanger) {
		this.stiger = stiger;
	    this.slanger = slanger;
	    this.plass = new Rute(0, stiger, slanger); // Startposisjon
	}
	
	/**
     * Flytter brikken til en ny posisjon på brettet.
     * 
     * @param nyPosisjon Den nye posisjonen til brikken.
     */
    public void flyttBrikke(int nyPosisjon) {
        this.plass = new Rute(nyPosisjon, stiger, slanger); 
    }

    /**
     * Sjekker om brikken havner på en stige eller en slange, og flytter brikken
     * tilsvarende om nødvendig.
     */
    public void sjekkForStigerOgSlanger() {
        // Sjekker for stiger først
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

    /**
     * Henter ruten som brikken befinner seg på.
     * 
     * @return Ruten som brikken er på.
     */
    public Rute getRute() {
        return plass;
    }

    /**
     * Setter ruten til brikken.
     * 
     * @param rute Den nye ruten til brikken.
     */
    public void setRute(Rute plass) {
        this.plass = plass;
    }
}