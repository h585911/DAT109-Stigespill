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
 * Representerer en slange i stigespillet. En slange har en startposisjon
 * og en sluttposisjon, og flytter spilleren bakover dersom den lander på slangens startposisjon.
 */

@Entity
@Table(schema = "stigespill")
public class Slange {
	
	/**
	 * Unik identifikastor for slange.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	/**
	 * Startposisjon for slangen, der spilleren går ned hvis de lander på denne ruten.
	 */
	@Embedded
    @AttributeOverride(name = "rute", column = @Column(name = "start_pos"))
	private Rute startPos;
	
	/**
	 * Sluttposisjon for slangen, der spilleren ender opp etter å ha truffet slangen.
	 */
	@Embedded
	@AttributeOverride(name = "rute", column = @Column(name = "slutt_pos"))
	private Rute sluttPos;
		
	/**
	 * Standardkonstruktør for JPA.
	 */
	public Slange() {
		super();
	}

	/**
	 * Konstruktør som oppretter en slange med spesifisert ID, start- og sluttposisjon.
	 * 
	 * @param id Unik identifikator for slangen.
	 * @param startPos Startposisjon til slangen.
	 * @param sluttPos Sluttposisjon til slangen.
	 */
	public Slange(int id, Rute startPos, Rute sluttPos) {
		this.id = id;
		this.startPos = startPos;
		this.sluttPos = sluttPos;
	}

	/**
	 * Henter ID-en til slangen.
	 * 
	 * @return Slangens ID.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter ID-en til slangen.
	 * 
	 * @param id ny ID for slangen.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Henter startposisjonen til slangen.
	 * 
	 * @return Startposisjonen til slangen.
	 */
	public Rute getStartPos() {
		return startPos;
	}

	/**
	 * Setter startposisjonen til slangen.
	 * 
	 * @param startPos Ny startposisjon for slangen.
	 */
	public void setStartPos(Rute startPos) {
		this.startPos = startPos;
	}

	/**
	 * Henter sluttposisjonen til slangen.
	 * 
	 * @return Sluttposisjonen til slangen.
	 */
	public Rute getSluttPos() {
		return sluttPos;
	}

	/**
	 * Setter sluttposisjonen til slangen.
	 * 
	 * @param sluttPos Ny sluttposisjon for slangen.
	 */
	public void setSluttPos(Rute sluttPos) {
		this.sluttPos = sluttPos;
	}
	
	/**
	 * Returnerer en strengrepresentasjon av slangen.
	 * 
	 * @return En streng som representerer slangen.
	 */
	@Override
	public String toString() {
		return "Slange [id=" + id + ", startPos=" + startPos + ", sluttPos=" + sluttPos + "]";
	}
}