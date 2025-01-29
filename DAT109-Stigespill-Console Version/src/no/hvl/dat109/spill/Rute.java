package no.hvl.dat109.spill;

import java.util.List;

import jakarta.persistence.Embeddable;

@Embeddable
public class Rute{
	
	private int rute;
    private List<Stige> stiger;
    private List<Slange> slanger;

    public Rute() {
    }
	
    public Rute(int rute, List<Stige> stiger, List<Slange> slanger) {
        this.rute = rute;
        this.stiger = stiger;
        this.slanger = slanger;
    }
	
    public boolean erStige() {
    	 for (Stige stige : stiger) {
             if (stige.getStartPos().getRute() == this.rute) {
                 return true;
             }
         }
         return false;
    }
    
    public boolean erSlange() {
    	 for (Slange slange : slanger) {
             if (slange.getStartPos().getRute() == this.rute) {
                 return true;
             }
         }
         return false;
    }
    
	
	public int getRute() {
		return rute;
	}

	@Override
	public String toString() {
		return "[rute=" + rute + "]";
	}
	
	
	
	
}