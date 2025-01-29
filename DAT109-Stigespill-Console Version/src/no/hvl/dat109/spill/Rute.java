package no.hvl.dat109.spill;

import jakarta.persistence.Embeddable;

@Embeddable
public class Rute{
	
	private int rute;
	
	public Rute() {
		super();
	}

	public Rute(int rute) {
		this.rute = rute;
	}
	
	public int getRute() {
		return rute;
	}

	@Override
	public String toString() {
		return "[rute=" + rute + "]";
	}
	
	
	
}