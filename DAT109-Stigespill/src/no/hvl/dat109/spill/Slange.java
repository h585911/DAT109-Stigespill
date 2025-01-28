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
public class Slange {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Embedded
    @AttributeOverride(name = "rute", column = @Column(name = "start_pos"))
	private Rute startPos;
	
	@Embedded
	@AttributeOverride(name = "rute", column = @Column(name = "slutt_pos"))
	private Rute sluttPos;
	
	private int slangetype; //grønn slange er 1, rosa er 2, gul er 3
	
	
	public Slange() {
		super();
	}

	public Slange(int id, Rute startPos, Rute sluttPos, int slangetype) {
		this.id = id;
		this.startPos = startPos;
		this.sluttPos = sluttPos;
		this.slangetype = slangetype;
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

	
	public int getSlangetype() {
		return slangetype;
	}

	public void setSlangetype(int slangetype) {
		this.slangetype = slangetype;
	}

	@Override
	public String toString() {
		return "Slange [id=" + id + ", startPos=" + startPos + ", sluttPos=" + sluttPos + ", slangetype=" + slangetype + "]";
	}
}