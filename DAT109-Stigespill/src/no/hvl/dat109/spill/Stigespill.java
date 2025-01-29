package no.hvl.dat109.spill;

import java.util.List;
import java.util.Random;

public class Stigespill {
	
	private List<Spiller> spillere;
	private Random random = new Random();
	private List<Stige> stiger;
	private List<Slange> slanger;
	//private static final long serialVersionUID = 1L;

	public Stigespill(List<Spiller> spillere) {
		 this.spillere = spillere;
		 StigeDAO stigedao = new StigeDAO();
		 SlangeDAO slangedao = new SlangeDAO();
		 
		 this.stiger = stigedao.hentAlleStiger();
		 this.slanger = slangedao.hentAlleSlanger();
		 
		/*
		setTitle("Stigespill");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1200, 700);
		setLayout(new BorderLayout());
		setResizable(false);
		*/
		
		/**
		 * Den første spilleren i listen settes som aktiv.
		 * Dvs. at spilleren har prioritet til å kaste terning.
		 */
		if (!spillere.isEmpty()) {
			spillere.get(0).setKanKasteTerning(true);
			System.out.println("\nSpiller " + spillere.get(0).getNavn() + " har prioritet, og kan kaste terning.");
		}
		
		startSpill();
		
	}
	
	 private void startSpill() {
		 boolean spillPågår = true;

	        while (spillPågår) {
	            for (Spiller spiller : spillere) {
	                if (spiller.kanKasteTerning()) {
	                    System.out.println("\n🔹 " + spiller.getNavn() + " sin tur!");

	                    boolean ekstraTur = true; // for logikk på om man triller sekser
	                    int sekserTeller = 0; // Teller hvor mange seksere på rad

	                    while (ekstraTur) {
	                        ekstraTur = false; // Standard: Én tur per runde

	                        if (spiller.getPosisjon() == 0) {
	                            // Spilleren må kaste en sekser for å starte
	                            int førsteKast = kastTerning();
	                            if (førsteKast == 6) {
	                                System.out.println(spiller.getNavn() + " kastet en sekser og får kaste igjen!");
	                                int andreKast = kastTerning();
	                                spiller.setPosisjon(spiller.getPosisjon() + andreKast);
	                                System.out.println(spiller.getNavn() + " flytter til posisjon " + spiller.getPosisjon());
	                                
	                                //sjekker for stiger eller slanger
	                                sjekkForStigerOgSlanger(spiller);

	                                // Hvis andre kast også er en sekser, får de ny tur
	                                if (andreKast == 6) {
	                                	sekserTeller++;
	                                    ekstraTur = true;
	                                    System.out.println(spiller.getNavn() + " trillet en sekser og får kaste igjen!");
	                                }
	                            } else {
	                                System.out.println(spiller.getNavn() + " fikk ikke en sekser og må vente på neste tur.");
	                            }
	                        } else {
	                            // Vanlig runde: Spilleren kan kaste som normalt
	                        	
	                        	int avstandFraMaal = 100 - spiller.getPosisjon(); // for å fikse når man kommer til mål
	                            int kast = kastTerning();
	                            
	                            //sjekker om de kommer over rute 100, hvis ikke kan man flytte:
	                            if (kast <= avstandFraMaal) {
	                            	spiller.setPosisjon(spiller.getPosisjon() + kast);
	 	                            System.out.println(spiller.getNavn() + " flytter til posisjon " + spiller.getPosisjon());
	 	                            
	 	                            //sjekker for stiger eller slanger;
	 	                            sjekkForStigerOgSlanger(spiller);
	                            } else {
	                                System.out.println(spiller.getNavn() + " trillet for høyt og må stå i ro!");
	                            }
	                          
	                            // Hvis de trillet en sekser, får de en ny tur
	                            if (kast == 6) {
	                            	sekserTeller++;
	                                ekstraTur = true;
	                                System.out.println(spiller.getNavn() + " trillet en sekser og får kaste igjen!");
	                            } else {
	                            	sekserTeller = 0;
	                            }
	                            
	                            // Hvis spilleren får tre seksere på rad, sendes de tilbake til start
	                            if (sekserTeller == 3) {
	                                System.out.println("❌ " + spiller.getNavn() + " trillet tre seksere på rad og må tilbake til start!");
	                                spiller.setPosisjon(0);
	                                sekserTeller = 0;
	                                ekstraTur = false; // Stopper spillerens runde
	                            }
	                        }

	                        // Sjekk om spilleren har vunnet:
	                        if (spiller.getPosisjon() >= 100) {
	                            System.out.println("🎉 Spiller " + spiller.getNavn() + " har vunnet spillet! 🎉");
	                            spillPågår = false;
	                            return; // Avslutter spillet
	                        }
	                    }

	                    // Neste spiller får turen
	                    spiller.setKanKasteTerning(false);
	                    int nesteSpiller = (spillere.indexOf(spiller) + 1) % spillere.size();
	                    spillere.get(nesteSpiller).setKanKasteTerning(true);
	                }
	            }
	        }
	    }
	 
	 private int kastTerning() {
	        System.out.print("Kaster terningen");
	        try {
	            for (int i = 0; i < 3; i++) { 
	                System.out.print(".");
	                Thread.sleep(300); //pause mellom hvert kast
	            }
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        int resultat = random.nextInt(6) + 1;
	        System.out.println(" 🎲 " + resultat);
	        return resultat;
	    }
	 
	 private void sjekkForStigerOgSlanger(Spiller spiller) {
		    for (Stige stige : stiger) {
		        if (spiller.getPosisjon() == stige.getStartPos().getRute()) {
		            System.out.println("⬆ " + spiller.getNavn() + " fant en stige! Går opp til " + stige.getSluttPos().getRute());
		            spiller.setPosisjon(stige.getSluttPos().getRute());
		            return; // Spilleren kan kun bruke én stige eller slange per tur
		        }
		    }

		    for (Slange slange : slanger) {
		        if (spiller.getPosisjon() == slange.getStartPos().getRute()) {
		            System.out.println("🐍 " + spiller.getNavn() + " ble bitt av en slange! Glir ned til " + slange.getSluttPos().getRute());
		            spiller.setPosisjon(slange.getSluttPos().getRute());
		            return; // Spilleren kan kun bruke én stige eller slange per tur
		        }
		    }
	 }
	 
	 
		/*
		
		//Brett panel
		Brett brett = new Brett();
		add(brett, BorderLayout.CENTER);
		
		
		//Får tak i slanger og stiger:
		SlangeDAO slangedao = new SlangeDAO();
		StigeDAO stigedao = new StigeDAO();
		
		// Spiller panel
		SpillerListe spillerListe = new SpillerListe(spillere);
		add(spillerListe, BorderLayout.EAST);
		
		// Status panel
		StatusPanel statusPanel = new StatusPanel(spillere);
		add(statusPanel, BorderLayout.SOUTH);
		
		// Terning panel
		Terning terning = new Terning(spillere, statusPanel);
		add(terning, BorderLayout.WEST);
		
		
		setVisible(true);
		*/
	}