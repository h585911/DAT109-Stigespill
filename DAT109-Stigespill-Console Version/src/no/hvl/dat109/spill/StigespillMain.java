package no.hvl.dat109.spill;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class StigespillMain{

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Spiller> spillere = new ArrayList<>();
        Random random = new Random();
        String[] farger = {"Red", "Blue", "Green", "Yellow"};
        Set<String> brukteFarger = new HashSet<>();
        
        System.out.println("Velkommen til Stigespill!");
        
        // Be om navn for spillere (2-4 spillere)
        while (spillere.size() < 2 || spillere.size() > 4) {
            spillere.clear();  // Rydder listen hvis vi har for mange eller for få spillere
            System.out.println("Hvor mange spillere? (2-4)");
            int antallSpillere = scanner.nextInt();
            scanner.nextLine(); 

            if (antallSpillere < 2 || antallSpillere > 4) {
                System.out.println("Du må ha mellom 2 og 4 spillere. Prøv igjen.");
            } else {
                for (int i = 0; i < antallSpillere; i++) {
                    System.out.print("Skriv inn navn for spiller " + (i + 1) + ": ");
                    String navn = scanner.nextLine();
                    spillere.add(lagSpiller(navn, farger, random, brukteFarger));
                }
            }
        }
        
        new Stigespill(spillere);  
        scanner.close();  
    }
    
    private static Spiller lagSpiller(String navn, String[] farger, Random random, Set<String> brukteFarger) {
        String farge;
        
        do {
            farge = farger[random.nextInt(farger.length)];
        } while (brukteFarger.contains(farge));
        brukteFarger.add(farge);
        
        // Hent stigene og slangene fra databasen via DAO-ene
        StigeDAO stigedao = new StigeDAO();
        SlangeDAO slangedao = new SlangeDAO();
        
        List<Stige> stiger = stigedao.hentAlleStiger();  // Henter alle stiger
        List<Slange> slanger = slangedao.hentAlleSlanger();  // Henter alle slanger
        
        Brikke brikke = new Brikke(stiger, slanger); 
        Spiller spiller = new Spiller(navn, brikke);
        
        return spiller;
    }
}
