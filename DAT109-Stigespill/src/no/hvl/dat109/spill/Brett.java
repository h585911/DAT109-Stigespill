package no.hvl.dat109.spill;

import java.util.Arrays;

public class Brett {
	
	// 10x10 grid
	private Rute[][] brett = new Rute[10][10];
	
	public Brett(Rute[][] brett) {
		super();
		this.setBrett(brett);
	}
	
	public Rute finnRute(Rute plass, Terning terning) {
		return plass;
	}

	public Rute[][] getBrett() {
		return brett;
	}

	public void setBrett(Rute[][] brett) {
		this.brett = brett;
	}

	@Override
	public String toString() {
		return "Brett [brett=" + Arrays.toString(brett) + "]";
	}
}