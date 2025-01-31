package no.hvl.dat109.spill;

/**
 * Representerer en spiller i stigespillet. Hver spiller har en brikke og kan
 * kaste
 * terningen for å flytte brikken på brettet.
 */
public class Spiller {

	/**
	 * Spillerens navn.
	 */
	private String navn;

	/**
	 * Spillerens brikke.
	 */
	private Brikke brikke;

	/**
	 * Indikerer om spilleren kan kaste terningen.
	 */
	private boolean kanKasteTerning;

	/**
	 * Konstruktør for å opprette en spiller med navn og brikke.
	 * 
	 * @param navn   Spillerens navn
	 * @param brikke Brikken som tilhører spilleren.
	 */
	public Spiller(String navn, Brikke brikke) {
		this.navn = navn;
		this.brikke = brikke;
		this.kanKasteTerning = false;
	}

	/**
	 * Utfører et spilltrekk hvor spilleren kaster terningen og flytter brikken
	 * tilsvarende.
	 * 
	 * @param terning Terningen som brukes i spillet.
	 */
	public void spilltrekk(Terning terning) {

		System.out.println("\n🔹 " + navn + " sin tur!");
		boolean ekstraTur = true; // for logikk på om man triller sekser
		int sekserTeller = 0; // Teller hvor mange seksere på rad

		while (ekstraTur) {
			ekstraTur = false; // Standard: Én tur per runde

			if (brikke.getRute().getRute() == 0) {
				// Spilleren må kaste en sekser for å starte
				int førsteKast = terning.trill(); // Forutsetter at Terning er en eksisterende klasse
				if (førsteKast == 6) {
					System.out.println(navn + " kastet en sekser og får kaste igjen!");
					int andreKast = terning.trill();
					brikke.flyttBrikke(brikke.getRute().getRute() + andreKast);
					System.out.println(navn + " flytter til posisjon " + brikke.getRute().getRute());

					// Sjekker for stiger og slanger
					brikke.sjekkForStigerOgSlanger();

					if (andreKast == 6) {
						sekserTeller++;
						ekstraTur = true;
						System.out.println(navn + " trillet en sekser og får kaste igjen!");
					}
				} else {
					System.out.println(navn + " fikk ikke en sekser og må vente på neste tur.");
				}
			} else {
				// Vanlig runde: Spilleren kan kaste som normalt
				int avstandFraMaal = 100 - brikke.getRute().getRute();
				int kast = terning.trill();

				if (kast <= avstandFraMaal) {
					brikke.flyttBrikke(brikke.getRute().getRute() + kast);
					System.out.println(navn + " flytter til posisjon " + brikke.getRute().getRute());

					// Sjekker for stiger og slanger
					brikke.sjekkForStigerOgSlanger();
				} else {
					System.out.println(navn + " trillet for høyt og må stå i ro!");
				}

				if (kast == 6) {
					sekserTeller++;
					ekstraTur = true;
					System.out.println(navn + " trillet en sekser og får kaste igjen!");
				} else {
					sekserTeller = 0;
				}

				if (sekserTeller == 3) {
					System.out.println("❌ " + navn + " trillet tre seksere på rad og må tilbake til start!");
					brikke.flyttBrikke(0);
					sekserTeller = 0;
					ekstraTur = false;
				}
			}

			if (brikke.getRute().getRute() >= 100) {
				System.out.println("🎉 Spiller " + navn + " har vunnet spillet! 🎉");
				return;
			}
		}

	}

	/**
	 * Henter spillerens navn.
	 * 
	 * @return Spillerens navn.
	 */
	public String getNavn() {
		return navn;
	}

	/**
	 * Setter spillerens navn.
	 * 
	 * @param navn Det nye navnet til spilleren.
	 */
	public void setNavn(String navn) {
		this.navn = navn;
	}

	/**
	 * Henter spillerens brikke.
	 * 
	 * @return Spillerens brikke.
	 */
	public Brikke getBrikke() {
		return brikke;
	}

	/**
	 * Setter spillerens brikke.
	 * 
	 * @param brikke Den nye brikken til spilleren.
	 */
	public void setBrikke(Brikke brikke) {
		this.brikke = brikke;
	}

	/**
	 * Sjekker om spilleren kan kaste terningen.
	 * 
	 * @return {@code true} hvis spilleren kan kaste terningen, ellers
	 *         {@code false}.
	 */
	public boolean kanKasteTerning() {
		return kanKasteTerning;
	}

	/**
	 * Setter om spilleren kan kaste terningen.
	 * 
	 * @param kanKasteTerning {@code true} hvis spilleren skal kunne kaste
	 *                        terningen.
	 */
	public void setKanKasteTerning(boolean kanKasteTerning) {
		this.kanKasteTerning = kanKasteTerning;
	}

	/**
	 * Returnerer en strengrepresentasjon av spilleren.
	 * 
	 * @return En streng som representerer spilleren.
	 */
	@Override
	public String toString() {
		return "Spiller [navn=" + navn + "]";
	}
}