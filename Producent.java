package domain;

public class Producent {
	
	private long id;
	private String nazwa;
	private String kraj;
	
	public Producent(){
		
	}
	
	public Producent(String nazwa, String kraj){
		super();
		this.nazwa=nazwa;
		this.kraj=kraj;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
