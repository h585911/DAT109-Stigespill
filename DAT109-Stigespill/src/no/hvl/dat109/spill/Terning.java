package no.hvl.dat109.spill;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.util.List;
import java.util.Random;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import no.hvl.dat109.utils.StatusPanel;

public class Terning extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private StatusPanel statusPanel;
	private JLabel terningOyneTekst;
	private JButton kastKnapp;
	private static final String[] TERNING_OYNE = {
			"/terning/inverted-dice-1.png", "/terning/inverted-dice-2.png", "/terning/inverted-dice-3.png", "/terning/inverted-dice-4.png", "/terning/inverted-dice-5.png", "/terning/inverted-dice-6.png"
	};
	private static final String TERNING_DEFAULT = "/terning/default.png";
	private int sisteKast;
	private List<Spiller> spillere;
	private static final int IMAGE_WIDTH = 50;
	private static final int IMAGE_HEIGHT = 50;
	
	public Terning(List<Spiller> spillere, StatusPanel statusPanel) {
		this.spillere = spillere;
		this.statusPanel = statusPanel;
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setPreferredSize(new Dimension(150, 200));
		setBackground(Color.LIGHT_GRAY);
		
		ImageIcon defaultIcon = scaleImage(loadImage(TERNING_DEFAULT), IMAGE_WIDTH, IMAGE_HEIGHT);
		terningOyneTekst = new JLabel(defaultIcon);
		terningOyneTekst.setAlignmentX(CENTER_ALIGNMENT);
		add(terningOyneTekst);
		
		kastKnapp = new JButton("Kast Terning");
		kastKnapp.setAlignmentX(CENTER_ALIGNMENT);
		add(Box.createRigidArea(new Dimension(0, 10)));
		add(kastKnapp);
		
		kastKnapp.addActionListener(e -> kastTerning());
	}
	
	private void trill(Spiller spiller) {
		 Random random = new Random();

		 System.out.print("Spiller " + spiller.getNavn() + " kaster terningen");
		    
	    // Simuler trilling av terning med en liten "animasjon"
	    for (int i = 0; i < 3; i++) {
	        try {
	            Thread.sleep(500); // 0.5 sekunder forsinkelse per "trill"
	            System.out.print(".");
	        } catch (InterruptedException e) {
	            Thread.currentThread().interrupt();
	        }
	    }

	    sisteKast = random.nextInt(6) + 1;
	    System.out.println(" og fikk: " + sisteKast);

	    spiller.setPosisjon(spiller.getPosisjon() + sisteKast);
	    System.out.println("Ny posisjon på brettet: " + spiller.getPosisjon());

	    // Neste spiller får tur
	    int nesteSpiller = (spillere.indexOf(spiller) + 1) % spillere.size();
	    spillere.get(nesteSpiller).setKanKasteTerning(true);
	}
	
	/*
	private void kastTerning() {
		Random random = new Random();
		sisteKast = random.nextInt(6) + 1; // "Tilfeldig" nummer fra 1 til 6
		ImageIcon newIcon = scaleImage(loadImage(TERNING_OYNE[sisteKast - 1]), IMAGE_WIDTH, IMAGE_HEIGHT);
		if (newIcon != null) {
			terningOyneTekst.setIcon(newIcon);
		}
		
		for (Spiller spiller : spillere) {
			if (spiller.kanKasteTerning()) {
				spiller.setPosisjon(spiller.getPosisjon() + sisteKast);
				spiller.setKanKasteTerning(false);
				
				System.out.println("Spiller " + spiller.getNavn() + " kastet terningen og fikk: " + sisteKast + ". Ny posisjon på brettet er: " + spiller.getPosisjon());
				System.out.println("DEBUG: " + spiller);
				
				int nesteSpiller = (spillere.indexOf(spiller) + 1) % spillere.size();
				spillere.get(nesteSpiller).setKanKasteTerning(true);
				
				statusPanel.oppdaterStatus(spillere);
				break;
			}
		}
	}*/
	
	private ImageIcon loadImage(String path) {
		java.net.URL imageUrl = getClass().getResource(path);
		if (imageUrl != null) {
			return new ImageIcon(imageUrl);
		} else {
			System.err.println("Kunne ikke laste terning bilde: " + path);
			return null;
		}
	}
	
	private ImageIcon scaleImage(ImageIcon icon, int width, int height) {
		if (icon == null) {
			return null;
		}
		Image img = icon.getImage();
		Image scaledImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		
		return new ImageIcon(scaledImg);
	}
	
	public int getSisteKast() {
		return sisteKast;
	}
	
	public void setKastKnappEnabled(boolean enabled) {
		kastKnapp.setEnabled(enabled);
	}
}