package no.hvl.dat109.spill;

import java.util.Random;

/**
 * Representerer en terning i spillet. Terningen kan trilles og gir et tilfeldig tall mellom 1 og 6.
 */
public class Terning {

	/**
	 * Referanse til den innebygde Random-klassen. 
	 */
    private Random random;

    /**
     * Konstruktør som oppretter en ny terning med en tilfedig generator.
     */
    public Terning() {
        this.random = new Random();
    }

    /**
     * Triller terningen og returnerer en verdi mellom 1 og 6.
     * 
     * @return En tilfeldig verdi mellom 1 og 6.
     */
    public int trill() {
        System.out.print("Kaster terningen");
        try {
            // Simulerer at terningen "ruller" med tre korte pauser
            for (int i = 0; i < 3; i++) {
                System.out.print(".");
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