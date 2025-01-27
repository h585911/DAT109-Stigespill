package no.hvl.dat109.spill;

public class Stige {
	
	private int id;
	private Rute startPos;
	private Rute sluttPos;
	
	public Stige(int id, Rute startPos, Rute sluttPos) {
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