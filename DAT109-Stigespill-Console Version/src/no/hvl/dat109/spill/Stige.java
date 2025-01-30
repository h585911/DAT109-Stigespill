package no.hvl.dat109.spill;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/* 
 * Klassen representerer en Stige i stigespillet
 * En stige har en startposisjon og en sluttposisjon, som angir hvor spilleren kan klatre
*/

@Entity
@Table(schema = "stigespill")
public class Stige {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Embedded
	@AttributeOverride(name = "rute", column = @Column(name = "start_pos"))
	@AttributeOverride(name = "rute", column = @Column(name = "start_pos"))
	private Rute startPos;

	@Embedded
	@AttributeOverride(name = "rute", column = @Column(name = "slutt_pos"))
	private Rute sluttPos;

	// Standard konstruktør
	public Stige() {
		super();
	}

	// Konstruktør som oppretter en Stige med ID (hvilken stige), startpos og
	// sluttpos
	public Stige(int id, Rute startPos, Rute sluttPos, int stigetype) {
		this.id = id;
		this.startPos = startPos;
		this.sluttPos = sluttPos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Rute getStartPos() {
		return startPos;
	}

	public void setStartPos(Rute startPos) {
		this.startPos = startPos;
	}

	public Rute getSluttPos() {
		return sluttPos;
	}

	public void setSluttPos(Rute sluttPos) {
		this.sluttPos = sluttPos;
	}

	@Override
	public String toString() {
		return "Stige [id=" + id + ", startPos=" + startPos + ", sluttPos=" + sluttPos + "]";
	}
}