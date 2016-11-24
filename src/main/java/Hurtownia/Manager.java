package Hurtownia;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jacek on 23.11.2016.
 */
public class Manager {
    private static final String Driver ="org.sqlite.JDBC";
    private static final String DB_URL="jdbc:sqlite:hurtownia.db";
    private Connection conn;
    private Statement statt;
    private PreparedStatement insertProducent;
    private PreparedStatement insertProdukt;
    private PreparedStatement allProducent;
    private PreparedStatement allProdukt;
    private PreparedStatement deleteProducent;
    private PreparedStatement deleteProdukt;
    private PreparedStatement dropProducent;
    private PreparedStatement dropProdukt;
    private PreparedStatement updateProducent;
    private PreparedStatement updateProdukt;

    public Manager(){
        try {
            Class.forName(Driver);
        } catch (ClassNotFoundException e) {
            System.err.println("Brak sterownika JDBC");
            e.printStackTrace();
        }

        try {
            conn = DriverManager.getConnection(DB_URL);
            statt = conn.createStatement();
            generujBaze();

            insertProducent = conn.prepareStatement("INSERT INTO producent VALUES (null,?,?)");
            insertProdukt = conn.prepareStatement("INSERT INTO produkt VALUES (null,?,?,?,?)");

            allProducent = conn.prepareStatement("SELECT * FROM producent");
            allProdukt = conn.prepareStatement("SELECT * FROM produkt");

            deleteProducent = conn.prepareStatement("DELETE FROM producent WHERE nazwa=?");
            deleteProdukt = conn.prepareStatement("DELETE FROM produkt WHERE nazwa=?");

            updateProducent = conn.prepareStatement("UPDATE producent SET nazwa=? WHERE id_producent=?");
            updateProdukt=conn.prepareStatement("UPDATE produkt SET  nazwa=? WHERE id_produkt=?");

            dropProducent=conn.prepareStatement("DROP TABLE IF EXISTS producent");
            dropProdukt=conn.prepareStatement("DROP TABLE IF EXISTS produkt");

        } catch (SQLException e) {
            System.err.println("Problem z otwarciem polaczenia");
            e.printStackTrace();
        }

    }

    public boolean generujBaze(){
        String createProducentString = "CREATE TABLE IF NOT EXISTS producent(id_producent INTEGER PRIMARY KEY AUTOINCREMENT, nazwa TEXT NOT NULL, kraj TEXT NOT NULL)";
        String createProduktString = "CREATE TABLE IF NOT EXISTS produkt(id_produkt INTEGER PRIMARY KEY AUTOINCREMENT, nazwa TEXT NOT NULL, cena DOUBLE NOT NULL, objetosc_mg INTEGER,idproducent INTEGER, FOREIGN KEY(idproducent) REFERENCES idproducent(id_producent))";

        try {
            statt.execute(createProducentString);
            statt.execute(createProduktString);
            System.out.println("Stworzono tabele");

        } catch (SQLException e) {
            System.err.println("Blad przy tworzeniu tabeli");
            e.printStackTrace();
            return false;
        }

        return true;
    }


    public boolean dodajProducenta(Producent p) {

        try {
            insertProducent.setString(1, p.getNazwa());
            insertProducent.setString(2, p.getKraj());
            insertProducent.execute();
            System.out.println("Dodano Producenta do bazy");
        }
        catch (SQLException e) {
            System.out.println("Blad, nie dodano Producenta");
            e.printStackTrace();
            return false;
        }
        return true;
    }


    public boolean dodajProdukt(Produkt p) {

        try {
            insertProdukt.setString(1, p.getNazwa());
            insertProdukt.setDouble(2, p.getCena());
            insertProdukt.setInt(3, p.getObjetosc_mg());
            insertProdukt.setFloat(4, p.getId_producent());
            insertProdukt.execute();
            System.out.println("Dodano Produkt");
        }
        catch (SQLException e) {
            System.out.println("Blad, nie dodano Produktu");
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
                p.setId(rs.getInt("id_producent"));
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
                p.setId(rs.getInt("id_produkt"));
                p.setNazwa(rs.getString("nazwa"));
                p.setCena(rs.getInt("cena"));
                p.setId_producent(rs.getInt("idproducent"));
                produkty.add(p);
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return produkty;
    }
    public boolean updateProdukt(Produkt p){

        try {
            updateProdukt.setString(1,p.getNazwa());
            updateProdukt.setLong(2,p.getId());
            updateProdukt.executeUpdate();
        }
        catch (SQLException e) {
            System.err.println("Blad przy usuwaniu Producenta");
            e.printStackTrace();
            return false;
        }
        return  true;

    }
    public boolean updateProducent(Producent producent){

        try {
            updateProducent.setString(1,producent.getNazwa());
            updateProducent.setLong(2,producent.getId());
            updateProducent.executeUpdate();
        }
        catch (SQLException e) {
            System.err.println("Blad przy usuwaniu Producenta");
            e.printStackTrace();
            return false;
        }
        return  true;

    }


    public boolean usunProducent(Producent p) {

        try {
            deleteProducent.setString(1,p.getNazwa());
            deleteProducent.executeUpdate();
            System.out.println("Dany Producent zostal usuniety");
        }
        catch (SQLException e) {
            System.err.println("Blad przy usuwaniu Producenta");
            e.printStackTrace();
            return false;
        }
        return true;
    }


    public boolean usunProdukt(Produkt p) {

        try {
            deleteProdukt.setString(1,p.getNazwa());
            deleteProdukt.executeUpdate();
            System.out.println("Dany Produkt zostal usuniety");
        }
        catch (SQLException e) {
            System.err.println("Blad przy usuwaniu Produktu");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean dropProducent() {

        try {
            dropProducent.execute();
            System.out.println("Usunieto tabele Producent");
        }
        catch (SQLException e) {
            System.out.println("Blad przy usuwaniu tabeli Producent");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean dropProdukt() {

        try {
            dropProdukt.execute();
            System.out.println("Usunieto tabele Produkt");
        }
        catch (SQLException e) {
            System.out.println("Blad przy usuwaniu tabeli Produkt");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    boolean closeConnection() {
        try {
            conn.close();
//            System.out.println("Polaczenie zamknieto pomyslnie");
        } catch (SQLException e) {
//            System.err.println("Problem z zamknieciem polaczenia");
            e.printStackTrace();
            return false;
        }
        return true;
    }


}