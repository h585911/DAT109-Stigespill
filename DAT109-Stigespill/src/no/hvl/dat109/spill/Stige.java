package no.hvl.dat109.spill;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(schema = "stigespill")
public class Stige {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Embedded
    @AttributeOverride(name = "rute", column = @Column(name = "start_pos"))
	private Rute startPos;
	
	@Embedded
	@AttributeOverride(name = "rute", column = @Column(name = "slutt_pos"))
	private Rute sluttPos;
	
	private int stigetype; // lang stige er 1, kort stige er 2
	
	public Stige() {
		super();
	}

	public Stige(int id, Rute startPos, Rute sluttPos, int stigetype) {
		this.id = id;
		this.startPos = startPos;
		this.sluttPos = sluttPos;
		this.stigetype = stigetype;
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
	

	public int getStigetype() {
		return stigetype;
	}

	public void setStigetype(int stigetype) {
		this.stigetype = stigetype;
	}

	@Override
	public String toString() {
		return "Stige [id=" + id + ", startPos=" + startPos + ", sluttPos=" + sluttPos + ", stigetype=" + stigetype + "]";
	}
}