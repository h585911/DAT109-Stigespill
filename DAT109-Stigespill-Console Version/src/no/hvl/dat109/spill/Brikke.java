package no.hvl.dat109.spill;

import java.util.List;

/**
 * Representerer en brikke i stigespillet. Brikken kan flyttes rundt på spillebrettet
 * og interagere med stiger og slanger.
 */
public class Brikke {

	/**
	 * Fargen til brikken.
	 */
    private String farge;
    
    /**
     * Ruten brikken befinner seg på.
     */
    private Rute rute;
    
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
        this.rute = new Rute(0, stiger, slanger);
    }

    /**
     * Flytter brikken til en ny posisjon på brettet.
     * 
     * @param nyPosisjon Den nye posisjonen til brikken.
     */
    public void flyttBrikke(int nyPosisjon) {
        this.rute = new Rute(nyPosisjon, stiger, slanger);
    }

    /**
     * Sjekker om brikken havner på en stige eller en slange, og flytter brikken
     * tilsvarende om nødvendig.
     */
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
                break; // Når en slange er funnet, slutter vi å lete.
            }
        }
    }

    /**
     * Henter fargen på brikken.
     * 
     * @return Fargen på brikken.
     */
    public String getFarge() {
        return farge;
    }

    /**
     * Setter fargen på brikken.
     * 
     * @param farge Den nye fargen til brikken.
     */
    public void setFarge(String farge) {
        this.farge = farge;
    }

    /**
     * Henter ruten som brikken befinner seg på.
     * 
     * @return Ruten som brikken er på.
     */
    public Rute getRute() {
        return rute;
    }

    /**
     * Setter ruten til brikken.
     * 
     * @param rute Den nye ruten til brikken.
     */
    public void setRute(Rute rute) {
        this.rute = rute;
    }
}