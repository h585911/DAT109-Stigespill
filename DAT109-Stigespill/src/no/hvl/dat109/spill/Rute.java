package no.hvl.dat109.spill;

public class Rute {
	
	private int rute;
	
	public Rute(int rute) {
		this.rute = rute;
	}

	public int getRute() {
		return rute;
	}

	public void setRute(int rute) {
		this.rute = rute;
	}
	
	public boolean sjekkSlange() {
		return false;
	}
	
	public boolean sjekkStige() {
		return false;
	}

	@Override
	public String toString() {
		return "Rute [rute=" + rute + "]";
	}	
}