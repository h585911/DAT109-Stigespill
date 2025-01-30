package no.hvl.dat109.spill;

import java.util.Random;

// Denne klassen representerer en terning som kan trilles for å få en tilfeldig verdi mellom 1 og 6
public class Terning {

    // Tilfeldig generator for terningkast
    private Random random;

    // Konstruktør som oppretter en terning med en tilfeldig generator
    public Terning() {
        this.random = new Random();
    }

    /**
     * Denne metoden triller terningen og returnerer en tilfeldig verdi mellom 1 og
     * 6.
     * Vi bruker tråder for å simulere kast med en visuell effekt av venting og
     * prikker.
     * Returnerer en tilfeldig verdi mellom 1 og 6.
     **/
    public int trill() {
        System.out.print("Kaster terningen");
        try {
            // Simulerer at terningen "ruller" med tre korte pauser
            for (int i = 0; i < 3; i++) {
                System.out.print(".");
                Thread.sleep(500); // pause mellom hvert kast
                Thread.sleep(500); // Pause i 500 ms mellom hver prikk
            }
            // Håndterer mulig avbruddsfeil
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int verdi = random.nextInt(6) + 1;
        System.out.println(" 🎲 " + verdi);
        return verdi;
    }
}
