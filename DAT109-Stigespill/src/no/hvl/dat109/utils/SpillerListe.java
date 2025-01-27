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
	
	/*public SpillerListe(List<Spiller> spillere) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setPreferredSize(new Dimension(300, 300));
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setBackground(Color.LIGHT_GRAY);
		
		JLabel panelTittel = new JLabel("Spillere");
		panelTittel.setFont(new Font("Arial", Font.BOLD, 18));
		panelTittel.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(panelTittel);
		
		add(Box.createRigidArea(new Dimension(0, 10)));
		
		for (Spiller spiller : spillere) {
			JLabel spillerTekst = new JLabel(spiller.getNavn());
			spillerTekst.setFont(new Font("Arial", Font.PLAIN, 16));
			add(spillerTekst);
			add(Box.createRigidArea(new Dimension(0, 5)));
		}
	}*/
	
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
		
		// TODO: KOFFOR FUNKE DA IKKJE Å RENDRA SIRKELEN (FARGE) VED SIDEN AV NAVNET????! SATANS DRIT
		
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
			
			JLabel fargeSirkel = new JLabel() {
				@Override
				protected void paintComponent(Graphics g) {
					super.paintComponent(g);
					g.setColor(sirkelFarge);
					g.fillOval(0, 0, getWidth(), getHeight());
				}
			};
			fargeSirkel.setPreferredSize(new Dimension(20, 20));
			
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
