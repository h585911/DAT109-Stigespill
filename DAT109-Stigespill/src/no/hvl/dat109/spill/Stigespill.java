package no.hvl.dat109.spill;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Stigespill extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public Stigespill(List<Spiller> spillere) {
		setTitle("Stigespill");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1200, 700);
		setLayout(new BorderLayout());
		setResizable(false);
		
		GameGridPanel gameGridPanel = new GameGridPanel();
		add(gameGridPanel, BorderLayout.CENTER);
		
		PlayerListPanel playerListPanel = new PlayerListPanel(spillere);
		add(playerListPanel, BorderLayout.EAST);
		
		setVisible(true);
	}
	
	/*private List<Spiller> spillere;
	private Brett brett;

	public Stigespill(List<Spiller> spillere, Brett brett) {
		this.spillere = spillere;
		this.brett = brett;
	}
	
	public void spill() {
		
	}*/
	
	/*public Stigespill(List<Spiller> spillere) {
		JFrame frame = new JFrame("Slangespill");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1200, 700);
		frame.setResizable(false);
		frame.setLayout(new GridLayout(10, 10));
		
		int[][] grid = new int[10][10];
		int teller = 100;
		
		// Fill the grid with the correct snake pattern
        for (int row = 0; row < 10; row++) {
            if (row % 2 == 0) {
                // Even rows (from top, left to right)
                for (int col = 0; col < 10; col++) {
                    grid[row][col] = teller--;
                }
            } else {
                // Odd rows (from top, right to left)
                for (int col = 9; col >= 0; col--) {
                    grid[row][col] = teller--;
                }
            }
        }

        // Add JLabels to the JFrame based on the grid
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                JLabel cell = createCellLabel(grid[row][col]);
                frame.add(cell);
            }
        }
		
		
		frame.setVisible(true);
	}
	
	private static JLabel createCellLabel(int number) {
		JLabel label = new JLabel(String.valueOf(number), SwingConstants.CENTER);
		label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		label.setFont(new Font("Arial", Font.BOLD, 16));
		return label;
	}*/
	
	
}

class PlayerListPanel extends JPanel {
	public PlayerListPanel(List<Spiller> spillere) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(new EmptyBorder(10, 10, 10, 10));
		
		JLabel title = new JLabel("Spillere");
		title.setFont(new Font("Arial", Font.BOLD, 18));
		title.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(title);
		
		add(Box.createRigidArea(new Dimension(0, 10)));
		
		for (Spiller spiller : spillere) {
			JLabel spillerLabel = new JLabel(spiller.getNavn());
			spillerLabel.setFont(new Font("Arial", Font.PLAIN, 16));
			add(spillerLabel);
			add(Box.createRigidArea(new Dimension(0, 5)));
		}
	}
}

class GameGridPanel extends JPanel {
	public GameGridPanel() {
		setLayout(new GridLayout(10, 10));
		setPreferredSize(new Dimension(600, 600));
		setBorder(new EmptyBorder(10, 10, 10, 10));
		
		int[][] grid = new int[10][10];
		int teller = 100;
		
		// Fill the grid with the correct snake pattern
        for (int row = 0; row < 10; row++) {
            if (row % 2 == 0) {
                // Even rows (from top, left to right)
                for (int col = 0; col < 10; col++) {
                    grid[row][col] = teller--;
                }
            } else {
                // Odd rows (from top, right to left)
                for (int col = 9; col >= 0; col--) {
                    grid[row][col] = teller--;
                }
            }
        }

        // Add JLabels to the JFrame based on the grid
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                JLabel cell = createCellLabel(grid[row][col]);
                add(cell);
            }
        }
	}
	
	private static JLabel createCellLabel(int number) {
		JLabel label = new JLabel(String.valueOf(number), SwingConstants.CENTER);
		label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		label.setFont(new Font("Arial", Font.BOLD, 16));
		return label;
	}
}