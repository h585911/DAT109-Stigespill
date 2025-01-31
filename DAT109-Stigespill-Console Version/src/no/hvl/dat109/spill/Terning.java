package no.hvl.dat109.spill;

import java.util.Random;

public class Terning {
		
	private Random random;
	
	public Terning() {
		this.random = new Random();
	}
	
	public int trill() {
		System.out.print("Kaster terningen");
        try {
            for (int i = 0; i < 3; i++) { 
                System.out.print(".");
                Thread.sleep(500); //pause mellom hvert kast, kan endres
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int verdi = random.nextInt(6) + 1;
        System.out.println(" 🎲 " + verdi);
        return verdi;
	 }
	
}