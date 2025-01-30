package no.hvl.dat109.spill;

import java.util.List;

import jakarta.persistence.Embeddable;

/**
 * Representerer en rute i stigespillet. En rute kan inneholde
 * en stige eller en slange. En rute har ett unikt nummer.
 */

@Embeddable
public class Rute {

    private int rute; // Nummeret til denne rute.
    private List<Stige> stiger; // Liste over stiger som er tilknyttet denne ruten.
    private List<Slange> slanger; // Liste over slanger som tilknyttet denne ruten.

    /**
     * Konstruktør for å opprette en rute med angitt nummer, stiger og slanger.
     * 
     * @param rute    Rutenummer
     * @param stiger  Liste over stiger på denne ruten.
     * @param slanger Liste over slanger på denne ruten.
     */
    public Rute(int rute, List<Stige> stiger, List<Slange> slanger) {
        this.rute = rute;
        this.stiger = stiger;
        this.slanger = slanger;
    }

    /**
     * Sjekker om ruten inneholder en stige.
     * 
     * @return {@code true} hvis ruten har en stige, ellers {@code false}.
     */
    public boolean erStige() {
        for (Stige stige : stiger) {
            if (stige.getStartPos().getRute() == this.rute) {
                return true;
            }
        }
        return false;
    }

    /**
     * Sjekker om denne ruten inneholder en slange.
     * 
     * @return {@code true} hvis ruten har en slange, ellers {@code false}.
     */
    public boolean erSlange() {
        for (Slange slange : slanger) {
            if (slange.getStartPos().getRute() == this.rute) {
                return true;
            }
        }
        return false;
    }

    /**
     * Henter rutenummeret.
     * 
     * @return Rutenummeret.
     */
    public int getRute() {
        return rute;
    }

    /**
     * Returnerer en strengrepresentasjon av ruten.
     * 
     * @return En streng som representerer ruten.
     */
    @Override
    public String toString() {
        return "[rute=" + rute + "]";
    }
}