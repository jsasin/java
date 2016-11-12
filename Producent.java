package jdbc;

public class Producent {
	private int id_producent;
	private String nazwa;
	private String kraj;
	
	public Producent(String nazwa, String kraj){
		this.nazwa=nazwa;
		this.kraj=kraj;
	}

	public int getId_producent() {
		return id_producent;
	}

	public void setId_producent(int id_producent) {
		this.id_producent = id_producent;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public String getKraj() {
		return kraj;
	}

	public void setKraj(String kraj) {
		this.kraj = kraj;
	}

}
