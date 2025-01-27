package no.hvl.dat109.spill;

public class Brikke {
	
	private String farge;
	private Rute rute;

	public Brikke(String farge) {
		this.farge = farge;
		this.rute = null;
	}

	public String getFarge() {
		return farge;
	}

	public void setFarge(String farge) {
		this.farge = farge;
	}

	public Rute getRute() {
		return rute;
	}

	public void setRute(Rute rute) {
		this.rute = rute;
	}

	@Override
	public String toString() {
		return "Brikke [farge=" + farge + ", rute=" + rute + "]";
	}
}