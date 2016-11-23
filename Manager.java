package service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


import domain.Producent;
import domain.Produkt;


public class Manager {
	private static final String Driver ="";
	private static final String DB_URL="";
	private Connection conn;
	private Statement statt; //do utworzenia bazy
	private PreparedStatement insertProducent;
    private PreparedStatement insertProdukt;
    private PreparedStatement allProducent;
    private PreparedStatement allProdukt;
    private PreparedStatement deleteProducent;
    private PreparedStatement deleteProdukt;
    private PreparedStatement dropProducent;
    private PreparedStatement dropProdukt;
    
    
    
    
    public boolean dodajProducenta(Producent p) {

        try {
            insertProducent.setString(1, p.getNazwa());
            insertProducent.setString(2, p.getKraj());
            insertProducent.execute();
            System.out.println("Dodano Producenta");
        } 
        catch (SQLException e) {
            System.out.println("B³¹d, nie dodano Producenta");
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    
    public boolean dodajProdukt(Produkt p) {

        try {
            insertProdukt.setString(1, p.getNazwa());
            insertProdukt.setFloat(2, p.getCena());
            insertProdukt.setInt(2, p.getObjetosc_mg());
            insertProdukt.setFloat(2, p.getId_producent());
            insertProdukt.execute();
            System.out.println("Dodano Produkt");
        } 
        catch (SQLException e) {
            System.out.println("B³¹d, nie dodano Produktu");
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    
    
    
    public List<Producent> getAllProducent() {
		List<Producent> producenci = new ArrayList<Producent>();

		try {
			ResultSet rs = allProducent.executeQuery();

			while (rs.next()) {
				Producent p = new Producent();
				p.setId(rs.getInt("id"));
				p.setNazwa(rs.getString("nazwa"));
				p.setKraj(rs.getString("kraj"));
				producenci.add(p);
			}

		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return producenci;
	}
    
    
    public List<Produkt> getAllProdukt() {
		List<Produkt> produkty = new ArrayList<Produkt>();

		try {
			ResultSet rs = allProdukt.executeQuery();

			while (rs.next()) {
				Produkt p = new Produkt();
				p.setId(rs.getInt("id"));
				p.setNazwa(rs.getString("nazwa"));
				p.setCena(rs.getInt("cena"));
				p.setId_producent(rs.getInt("id_producent"));
				produkty.add(p);
			}

		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return produkty;
	}
    
    
    public boolean usunProducent(Producent p) {

        try {
            deleteProducent.setString(1,p.getNazwa());
            deleteProducent.executeUpdate();
            System.out.println("Dany Producent zosta³ usuniêty");
        } 
        catch (SQLException e) {
            System.err.println("B³¹d przy usuwaniu Producenta");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    
    public boolean usunProdukt(Produkt p) {

        try {
            deleteProdukt.setString(1,p.getNazwa());
            deleteProdukt.executeUpdate();
            System.out.println("Dany Produkt zosta³ usuniêty");
        } 
        catch (SQLException e) {
            System.err.println("B³¹d przy usuwaniu Produktu");
            e.printStackTrace();
            return false;
        }
        return true;
    }    
    
    public boolean dropProducent() {

        try {
            dropProducent.execute();
            System.out.println("Usuniêto tabele Producent");
        } 
        catch (SQLException e) {
            System.out.println("B³¹d przy usuwaniu tabeli Producent");
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public boolean dropProdukt() {

        try {
            dropProdukt.execute();
            System.out.println("Usuniêto tabelê Produkt");
        } 
        catch (SQLException e) {
            System.out.println("B³¹d przy usuwaniu tabeli Produkt");
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    
}
