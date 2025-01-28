package no.hvl.dat109.utils;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import no.hvl.dat109.spill.Spiller;

public class SpillerListe extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Metoden skal vise hvilke spillere som er med i spillet.
	 * Spillerene blir hentet fra `MainFrame`-komponenten når vi først startet spillet.
	 * 
	 * Hver spiller blir da vist i panelet med navn og en sirkel med hvilken farge på brikken spilleren har.
	 * 
	 * @param spillere
	 */
	public SpillerListe(List<Spiller> spillere) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setPreferredSize(new Dimension(200, 200));
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setBackground(Color.LIGHT_GRAY);
		
		JLabel panelTittel = new JLabel("Spillere");
		panelTittel.setFont(new Font("Arial", Font.BOLD, 18));
		panelTittel.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(panelTittel);
		
		add(Box.createRigidArea(new Dimension(0, 10)));

		for (Spiller spiller : spillere) {
			JPanel spillerPanel = new JPanel();
			spillerPanel.setLayout(new BoxLayout(spillerPanel, BoxLayout.X_AXIS));
			spillerPanel.setBackground(Color.LIGHT_GRAY);
			
			Color sirkelFarge;
			switch (spiller.getBrikke().getFarge().toLowerCase()) {
				case "red":
					sirkelFarge = Color.RED;
					break;
				case "blue":
					sirkelFarge = Color.BLUE;
					break;
				case "green":
					sirkelFarge = Color.GREEN;
					break;
				case "yellow":
					sirkelFarge = Color.YELLOW;
					break;
				default:
					sirkelFarge = Color.BLACK;
			}
			
			JPanel fargeSirkel = new JPanel() {
				@Override
				protected void paintComponent(Graphics g) {
					super.paintComponent(g);
					g.setColor(sirkelFarge);
					g.fillOval(0, 0, getWidth(), getHeight());
				}
				
				@Override
				public boolean isOpaque() {
					return false;
				}
			};
			fargeSirkel.setPreferredSize(new Dimension(20, 20));
			fargeSirkel.setMaximumSize(new Dimension(20, 20));
			fargeSirkel.setAlignmentY(Component.CENTER_ALIGNMENT);
			
			JLabel spillerTekst = new JLabel(spiller.getNavn());
			spillerTekst.setFont(new Font("Arial", Font.PLAIN, 14));
			spillerTekst.setAlignmentY(Component.CENTER_ALIGNMENT);
			
			spillerPanel.add(fargeSirkel);
			spillerPanel.add(Box.createRigidArea(new Dimension(10, 0)));
			spillerPanel.add(spillerTekst);
			
			add(spillerPanel);
			add(Box.createRigidArea(new Dimension(0, 10)));
		}
	}

}
