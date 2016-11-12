package jdbc;

public class Produkt {
	private int id_produkt;
	private String nazwa_produktu;
	private float cena;
	private int objetosc_mg;
	private int id_producent;
	
	public Produkt(String nazwa_produktu, float cena, int objetosc_mg, int id_producent){
		this.nazwa_produktu=nazwa_produktu;
		this.cena=cena;
		this.objetosc_mg=objetosc_mg;
		this.id_producent=id_producent;
	}	
	
	
	public int getId_produkt() {
		return id_produkt;
	}


	public void setId_produkt(int id_produkt) {
		this.id_produkt = id_produkt;
	}


	public String getNazwa_produktu() {
		return nazwa_produktu;
	}

	public void setNazwa_produktu(String nazwa_produktu) {
		this.nazwa_produktu = nazwa_produktu;
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

	public int getId_producent() {
		return id_producent;
	}

	public void setId_producent(int id_producent) {
		this.id_producent = id_producent;
	}

}
