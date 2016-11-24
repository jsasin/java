package Hurtownia;

/**
 * Created by Jacek on 23.11.2016.
 */
public class Produkt {
    private long id;
    private String nazwa;
    private double cena;
    private int objetosc_mg;
    private long id_producent;



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

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
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