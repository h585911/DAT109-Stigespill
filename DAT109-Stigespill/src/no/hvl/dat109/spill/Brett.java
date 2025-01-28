package no.hvl.dat109.spill;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Brett extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private final Rute[][] ruter;
	
	/**
	 * Brett-metoden skal opprette et brett hvor vi har ett grid-system som består av 10x10 = 100 Ruter.
	 * 
	 * Den første Ruten (rute 1) skal plasseres helt nede til venstre.
	 * Den siste Ruten (rute 100) skal plasseres helt oppe til venstre.
	 * 
	 * Dette betyr at vi må veksle mellom rekkefølgen på radene.
	 * 
	 */
	public Brett() {
		
		setLayout(new GridLayout(10, 10));
		setPreferredSize(new Dimension(600, 600));
		setBorder(new EmptyBorder(10, 10, 10, 10));
		
		int[][] grid = new int[10][10];
		int teller = 100;
		
		for (int rad = 0; rad < 10; rad++) {
			if (rad % 2 == 0) {
				for (int kol = 0; kol < 10; kol++) {
					grid[rad][kol] = teller--;
				}
			} else {
				for (int kol = 9; kol >= 0; kol--) {
					grid[rad][kol] = teller--;
				}
			}
		}
		
		ruter = new Rute[10][10];
		
		for (int rad = 0; rad < 10; rad++) {
			for (int kol = 0; kol < 10; kol++) {
				ruter[rad][kol] = new Rute(grid[rad][kol]);
				add(ruter[rad][kol]);
			}
		}
	}
	
	public Rute getRute(int row, int col) {
		return ruter[row][col];
	}
	
}