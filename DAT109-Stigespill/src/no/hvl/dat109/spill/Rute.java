package no.hvl.dat109.spill;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import jakarta.persistence.Embeddable;

@Embeddable
public class Rute extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private final int rute;
	
	public Rute(int rute) {
		this.rute = rute;
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		setBackground(Color.WHITE);
		
		JLabel label = new JLabel(String.valueOf(rute), SwingConstants.NORTH_EAST);
		add(label);
	}
	
	public int getRute() {
		return rute;
	}
	
}