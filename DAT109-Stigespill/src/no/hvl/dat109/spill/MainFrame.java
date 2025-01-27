package no.hvl.dat109.spill;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import no.hvl.dat109.utils.InputListener;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 281280578361421973L;
	private JTextField spiller1Field;
	private JTextField spiller2Field;
	private JTextField spiller3Field;
	private JTextField spiller4Field;
	private JButton startKnapp;
	private List<Spiller> spillere;
	
	public MainFrame() {
		setTitle("Stigespill Start Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());
        
        spillere = new ArrayList<>();
        
        // Panel for input til spillere
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(5, 2, 10, 10));
        
        // Spiller 1
        inputPanel.add(new JLabel("Spiller 1 Navn:"));
        spiller1Field = new JTextField();
        inputPanel.add(spiller1Field);
        
        // Spiller 2
        inputPanel.add(new JLabel("Spiller 2 Navn:"));
        spiller2Field = new JTextField();
        inputPanel.add(spiller2Field);
        
        // Spiller 3
        inputPanel.add(new JLabel("Spiller 3 Navn:"));
        spiller3Field = new JTextField();
        inputPanel.add(spiller3Field);
        
        // Spiller 4
        inputPanel.add(new JLabel("Spiller 4 Navn:"));
        spiller4Field = new JTextField();
        inputPanel.add(spiller4Field);
        
        // Start knapp
        startKnapp = new JButton("Start Spill");
        startKnapp.setEnabled(false);
        inputPanel.add(startKnapp);
        
        // Action listener for å validere input
        ActionListener inputValideringListener = e -> sjekkSpillere();
        spiller1Field.addActionListener(inputValideringListener);
        spiller2Field.addActionListener(inputValideringListener);
        spiller3Field.addActionListener(inputValideringListener);
        spiller4Field.addActionListener(inputValideringListener);

        spiller1Field.getDocument().addDocumentListener(new InputListener(() -> sjekkSpillere()));
        spiller2Field.getDocument().addDocumentListener(new InputListener(() -> sjekkSpillere()));
        spiller3Field.getDocument().addDocumentListener(new InputListener(() -> sjekkSpillere()));
        spiller4Field.getDocument().addDocumentListener(new InputListener(() -> sjekkSpillere()));
        
        // Legg til komponenter til frame
        add(inputPanel, BorderLayout.CENTER);
        
        // Start Knapp Action
        startKnapp.addActionListener(e -> startSpill());
        
        setVisible(true);
	}
	
	private void sjekkSpillere() {
		
		int filledFields = 0;
		if (!spiller1Field.getText().trim().isEmpty()) filledFields++;
		if (!spiller2Field.getText().trim().isEmpty()) filledFields++;
		if (!spiller3Field.getText().trim().isEmpty()) filledFields++;
		if (!spiller4Field.getText().trim().isEmpty()) filledFields++;
		
		startKnapp.setEnabled(filledFields >= 2);
	}
	
	private void startSpill() {
		
		spillere.clear();
		Random random = new Random();
		String[] farger = {"Red", "Blue", "Green", "Yellow"};
		Set<String> brukteFarger = new HashSet<>();
		
		if (!spiller1Field.getText().trim().isEmpty()) {
			spillere.add(lagSpiller(spiller1Field.getText().trim(), farger, random, brukteFarger));
		}
		if (!spiller2Field.getText().trim().isEmpty()) {
			spillere.add(lagSpiller(spiller2Field.getText().trim(), farger, random, brukteFarger));
		}
		if (!spiller3Field.getText().trim().isEmpty()) {
			spillere.add(lagSpiller(spiller3Field.getText().trim(), farger, random, brukteFarger));
		}
		if (!spiller4Field.getText().trim().isEmpty()) {
			spillere.add(lagSpiller(spiller4Field.getText().trim(), farger, random, brukteFarger));
		}
		
		System.out.println("Starter spillet med spillere:");
		for (Spiller spiller : spillere) {
			System.out.println(spiller);
		}
		
		new Stigespill(spillere);
		dispose();
		
	}
	
	private Spiller lagSpiller(String navn, String[] farger, Random random, Set<String> brukteFarger) {
		String farge;
		
		do {
			farge = farger[random.nextInt(farger.length)];
		} while (brukteFarger.contains(farge));
		brukteFarger.add(farge);
		
		Brikke brikke = new Brikke(farge);
		Spiller spiller = new Spiller(navn, brikke);
		System.out.println("Spiller " + spiller + " har brikke: " + brikke);
		
		return spiller;
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(MainFrame::new);
	}
	
}
