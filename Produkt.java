package domain;

public class Produkt {
	private long id;
	private String nazwa;
	private float cena;
	private int objetosc_mg;
	private long id_producent;
	
	public Produkt(){
		
	}
	
	public Produkt(String nazwa, float cena, int objetosc_mg, int id_producent){
		super();
		this.nazwa=nazwa;
		this.cena=cena;
		this.objetosc_mg=objetosc_mg;
		this.id_producent=id_producent;
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

	public float getCena() {
		return cena;
	}

	public void setCena(float cena) {
		this.cena = cena;
	}

	public int getObjetosc_mg() {
		return objetosc_mg;
	}

	public void setObjetosc_mg(int objetosc_mg) {
		this.objetosc_mg = objetosc_mg;
	}

	public long getId_producent() {
		return id_producent;
	}

	public void setId_producent(long id_producent) {
		this.id_producent = id_producent;
	}

}
