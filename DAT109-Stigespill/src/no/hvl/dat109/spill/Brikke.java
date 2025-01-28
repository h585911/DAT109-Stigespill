package no.hvl.dat109.spill;

public class Brikke {
	
	private String farge;
	
	public Brikke(String farge) {
		this.farge = farge;
	}
	
	public String getFarge() {
		return farge;
	}
	
	public void setFarge(String farge) {
		this.farge = farge;
	}
	
	@Override
	public String toString() {
		return "Brikke{ " + "farge='" + farge + '\'' + " }";
	}
}