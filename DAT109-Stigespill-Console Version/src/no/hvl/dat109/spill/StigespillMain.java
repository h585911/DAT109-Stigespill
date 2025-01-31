package no.hvl.dat109.spill;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StigespillMain{

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Spiller> spillere = new ArrayList<>();

        System.out.println("Velkommen til Stigespill!");
        
        while (spillere.size() < 2 || spillere.size() > 4) {
            spillere.clear();  
            System.out.println("Hvor mange spillere? (2-4)");
            int antallSpillere = scanner.nextInt();
            scanner.nextLine(); 

            if (antallSpillere < 2 || antallSpillere > 4) {
                System.out.println("Du må ha mellom 2 og 4 spillere. Prøv igjen.");
            } else {
                for (int i = 0; i < antallSpillere; i++) {
                    System.out.print("Skriv inn navn for spiller " + (i + 1) + ": ");
                    String navn = scanner.nextLine();
                    spillere.add(lagSpiller(navn));
                }
            }
        }
        
        new Stigespill(spillere);  
        scanner.close();  
    }
    
    private static Spiller lagSpiller(String navn) {
        
        StigeDAO stigedao = new StigeDAO();
        SlangeDAO slangedao = new SlangeDAO();
        
        List<Stige> stiger = stigedao.hentAlleStiger();  
        List<Slange> slanger = slangedao.hentAlleSlanger();
        
        Brikke brikke = new Brikke(stiger, slanger); 
        Spiller spiller = new Spiller(navn, brikke);
        
        return spiller;
    }
}
