package no.hvl.dat109.spill;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JFrame;

import no.hvl.dat109.utils.SpillerListe;
import no.hvl.dat109.utils.StatusPanel;

public class Stigespill extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public Stigespill(List<Spiller> spillere) {
		setTitle("Stigespill");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1200, 700);
		setLayout(new BorderLayout());
		setResizable(false);
		
		/**
		 * Den første spilleren i listen settes som aktiv.
		 * Dvs. at spilleren har prioritet til å kaste terning.
		 */
		if (!spillere.isEmpty()) {
			spillere.get(0).setKanKasteTerning(true);
			System.out.println("Spiller " + spillere.get(0).getNavn() + " har prioritet, og kan kaste terning.");
		}
		
		// Brett panel
		Brett brett = new Brett();
		add(brett, BorderLayout.CENTER);
		
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
	}
}