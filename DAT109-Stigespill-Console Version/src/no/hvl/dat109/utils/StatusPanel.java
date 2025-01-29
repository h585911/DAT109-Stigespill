package no.hvl.dat109.utils;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import no.hvl.dat109.spill.Spiller;

public class StatusPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JLabel statusTekst;
	
	public StatusPanel(List<Spiller> spillere) {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		setPreferredSize(new Dimension(1200, 50));
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setBackground(Color.WHITE);
		
		statusTekst = new JLabel();
		statusTekst.setFont(new Font("Arial", Font.PLAIN, 16));
		oppdaterStatus(spillere);
		
		add(statusTekst);
	}
	
	public void oppdaterStatus(List<Spiller> spillere) {
		for (Spiller spiller : spillere) {
			if (spiller.kanKasteTerning()) {
				statusTekst.setText("Det er spiller " + spiller.getNavn() + " sin tur til å kaste terningen.");
				return;
			}
		}
	}
	
	public void setStatusTekst(String tekst) {
		statusTekst.setText(tekst);
	}

}
