package no.hvl.dat109.spill;

public class Spiller {
	
	private String navn;
	private Brikke brikke;
	private boolean kanKasteTerning;
	private int posisjon;
	
	//private Terning terning;
	
	public Spiller(String navn, Brikke brikke) {
		this.navn = navn;
		this.brikke = brikke;
		this.kanKasteTerning = false;
		this.posisjon = 0;
		//this.terning = terning;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public Brikke getBrikke() {
		return brikke;
	}

	public void setBrikke(Brikke brikke) {
		this.brikke = brikke;
	}
	
	public boolean kanKasteTerning() {
		return kanKasteTerning;
	}
	
	public void setKanKasteTerning(boolean kanKasteTerning) {
		this.kanKasteTerning = kanKasteTerning;
	}
	
	public int getPosisjon() {
		return posisjon;
	}
	
	public void setPosisjon(int posisjon) {
		this.posisjon = posisjon;
	}
	
	/**
	 * 
	 */
	public void spilltrekk() {
		// Implementer etterpå
	}

	@Override
	public String toString() {
		return "Spiller [navn=" + navn + ", brikke=" + brikke + ", posisjon=" + posisjon + "]";

		//return "Spiller [navn=" + navn + ", brikke=" + brikke + ", terning=" + terning + "]";
	}
}