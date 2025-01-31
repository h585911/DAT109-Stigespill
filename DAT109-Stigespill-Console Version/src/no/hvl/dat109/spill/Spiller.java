package no.hvl.dat109.spill;

public class Spiller {
	
	private String navn;
	private Brikke brikke;
	private boolean kanKasteTerning;
	
	public Spiller(String navn, Brikke brikke) {
		this.navn = navn;
		this.brikke = brikke;
		this.kanKasteTerning = false;
	}
	
	
	public void spilltrekk(Terning terning) {
 
		
		System.out.println("\n🔹 " + navn + " sin tur!");
		boolean ekstraTur = true; // for logikk på om man triller sekser
	    int sekserTeller = 0; // Teller hvor mange seksere på rad

        while (ekstraTur) {
            ekstraTur = false; // Standard: Én tur per runde

            if (brikke.getRute().getRute() == 0) {
                // Spilleren må kaste en sekser for å starte
                int førsteKast = terning.trill();  // Forutsetter at Terning er en eksisterende klasse
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
	

	@Override
	public String toString() {
		return "Spiller [navn=" + navn + "]";
	}


	
}