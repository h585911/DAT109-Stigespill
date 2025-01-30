package no.hvl.dat109.spill;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Representerer en stige i stigespillet. En stige har en startposisjon
 * og en sluttposisjon, og lar spilleren klatre opp dersom de lander på stigens startposisjon.
 */
@Entity
@Table(schema = "stigespill")
public class Stige {

	/**
	 * Unik identifikator for stigen.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	/**
	 * Startposisjon for stigen, der spilleren kan klatre opp.
	 */
	@Embedded
	@AttributeOverride(name = "rute", column = @Column(name = "start_pos"))
	@AttributeOverride(name = "rute", column = @Column(name = "start_pos"))
	private Rute startPos;

	/**
	 * Sluttposisjon for stigen, der spilleren ender opp etter å ha klatret opp.
	 */
	@Embedded
	@AttributeOverride(name = "rute", column = @Column(name = "slutt_pos"))
	private Rute sluttPos;

	/**
	 * Standardkonstruktør for JPA.
	 */
	public Stige() {
		super();
	}

	/**
	 * Konstruktør som oppretter en stige med spesifisert ID, start- og sluttposisjon.
	 * 
	 * @param id Unik identifikator for stigen.
	 * @param startPos Startposisjonen til stigen.
	 * @param sluttPos Sluttposisjonen til stigen.
	 */
	public Stige(int id, Rute startPos, Rute sluttPos) {
		this.id = id;
		this.startPos = startPos;
	}

	/**
	 * Henter ID-en til stigen.
	 * 
	 * @return Stigens ID.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter ID-en til stigen.
	 * 
	 * @param id Ny ID for stigen.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Henter startposisjonen til stigen.
	 * 
	 * @return Startposisjonen til stigen.
	 */
	public Rute getStartPos() {
		return startPos;
	}

	/**
	 * Setter startposisjonen til stigen.
	 * 
	 * @param startPos Ny startposisjon for stigen.
	 */
	public void setStartPos(Rute startPos) {
		this.startPos = startPos;
	}

	/**
	 * Henter sluttposisjonen til stigen.
	 * 
	 * @return Sluttposisjonen til stigen.
	 */
	public Rute getSluttPos() {
		return sluttPos;
	}

	/**
	 * Setter sluttposisjonen til stigen.
	 * 
	 * @param sluttPos Ny sluttposisjon for stigen.
	 */
	public void setSluttPos(Rute sluttPos) {
		this.sluttPos = sluttPos;
	}

	/**
	 * Returnerer en strengrepresentasjon av stigen.
	 * 
	 * @return En streng som representerer stigen.
	 */
	@Override
	public String toString() {
		return "Stige [id=" + id + ", startPos=" + startPos + ", sluttPos=" + sluttPos + "]";
	}
}