package no.hvl.dat109.spill;

public class Spiller {
	
	private String navn;
	private Brikke brikke;
	private Terning terning;
	
	public Spiller(String navn, Brikke brikke, Terning terning) {
		this.navn = navn;
		this.brikke = brikke;
		this.terning = terning;
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

	public Terning getTerning() {
		return terning;
	}

	public void setTerning(Terning terning) {
		this.terning = terning;
	}
	
	/**
	 * 
	 */
	public void spilltrekk() {
		// Implementer etterpå
	}

	@Override
	public String toString() {
		return "Spiller [navn=" + navn + ", brikke=" + brikke + ", terning=" + terning + "]";
	}
}