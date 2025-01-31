package no.hvl.dat109.spill;

import java.util.List;

/**
 * Klassen representerer selve Stigespillet og håndterer spillere, stiger,
 * slanger og terningskast.
 */
public class Stigespill {

	/**
	 * Liste over alle spillere i spillet.
	 */
	private List<Spiller> spillere;

	/**
	 * Liste over alle stiger i spillet.
	 */
	private List<Stige> stiger;

	/**
	 * Liste over alle slanger i spillet.
	 */
	private List<Slange> slanger;

	/**
	 * Referanse til én Terning.
	 */
	private Terning terning;

	/**
	 * Referanse til StigeDAO for å hente stiger fra databasen.
	 */
	private StigeDAO stigedao;

	/**
	 * Referanse til SlangeDAO for å hente slanger fra databasen.
	 */
	private SlangeDAO slangedao;

	/**
	 * Konstruktør som oppretter et nytt Stigespill med en liste av spillere.
	 * Terningen initialiseres, stiger og slanger hentes fra databasen, og det gis
	 * en brikke til hver spiller.
	 * 
	 * Stigespill
	 * 
	 * @param spillere Alle spillere som er med i stigespillet.
	 */
	public Stigespill(List<Spiller> spillere) {
		this.spillere = spillere;
		this.terning = new Terning();
		this.stigedao = new StigeDAO();
		this.slangedao = new SlangeDAO();
		this.stiger = stigedao.hentAlleStiger();
		this.slanger = slangedao.hentAlleSlanger();

		for (Spiller spiller : spillere) {
			spiller.setBrikke(new Brikke(stiger, slanger));
		}

		/**
		 * Den første spilleren i listen settes som aktiv.
		 * Dvs. at spilleren har prioritet til å kaste terning.
		 */
		if (!spillere.isEmpty()) {
			spillere.get(0).setKanKasteTerning(true);
			System.out.println("\nSpiller " + spillere.get(0).getNavn() + " har prioritet, og kan kaste terning.");
		}

		spill();

	}

	/**
	 * Kjører spillet og håndterer turene for hver spiller til spillet er ferdig.
	 */
	private void spill() {
		boolean spillPågår = true;

		while (spillPågår) {
			for (Spiller spiller : spillere) {
				if (spiller.kanKasteTerning()) {

					spiller.spilltrekk(terning); // Kaller spilltrekk for hver spiller

					// Sjekker om spilleren har nådd posisjon 100 (målet)
					if (spiller.getBrikke().getRute().getRute() >= 100) {
						spillPågår = false;
						break;
					}

					// Neste spiller får turen
					spiller.setKanKasteTerning(false);
					int nesteSpiller = (spillere.indexOf(spiller) + 1) % spillere.size();
					spillere.get(nesteSpiller).setKanKasteTerning(true);

				}
			}
		}
	}
}