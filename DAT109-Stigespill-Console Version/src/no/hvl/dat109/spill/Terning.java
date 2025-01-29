package no.hvl.dat109.spill;

import java.util.Random;

public class Terning {
		
	private Random random;
	
	
	public Terning(Random random) {
		this.random = random;
	}
	
	private int trill() {
		System.out.print("Kaster terningen");
        try {
            for (int i = 0; i < 3; i++) { 
                System.out.print(".");
                Thread.sleep(300); //pause mellom hvert kast
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int verdi = random.nextInt(6) + 1;
        System.out.println(" 🎲 " + verdi);
        return verdi;
	 }
	
}