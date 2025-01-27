package no.hvl.dat109.spill;

import java.util.Random;

public class Terning {
	
	private int verdi; // 1 - 6
	
	public Terning(int verdi) {
		this.verdi = verdi;
	}

	public int getVerdi() {
		return verdi;
	}

	public void setVerdi(int verdi) {
		this.verdi = verdi;
	}
	
	public int trill() {
		// Implementer med random?
		Random random = new Random();
		
		int diceRoll = random.nextInt(6) + 1; // nextInt(6) 
		
		return diceRoll;
	}
}