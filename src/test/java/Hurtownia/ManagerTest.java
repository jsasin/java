package Hurtownia;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Jacek on 23.11.2016.
 */
public class ManagerTest {
    Manager m;

    @Before
    public void setUp() throws Exception {
        m=new Manager();
    }

    @After
    public void tearDown() throws Exception {
        m.dropProducent();
        m.dropProdukt();

        m.closeConnection();
    }

    @Test
    public void generujBaze() throws Exception {
       assertTrue(m.generujBaze());
    }

    @Test
    public void dodajProducenta() throws Exception {
        Producent p=new Producent();
        p.setKraj("Polska");
        p.setNazwa("SuperKoks");
        assertTrue(m.dodajProducenta(p));
        assertTrue(m.getAllProducent().size()>=1);
    }

    @Test
    public void dodajProdukt() throws Exception {
        Produkt p=new Produkt();
        p.setNazwa("Metanabol");
        p.setCena(15.20);
        p.setObjetosc_mg(30);
        assertTrue(m.dodajProdukt(p));
        assertTrue(m.getAllProdukt().size()>=1);
    }

    @Test
    public void getAllProducent() throws Exception {
        Producent p=new Producent();
        p.setKraj("Polska");
        p.setNazwa("SuperKoks");
        m.dodajProducenta(p);
        List<Producent> l = m.getAllProducent();
        assertTrue(l.size()==1);
        assertEquals("Polska",l.get(0).getKraj());
    }

    @Test
    public void getAllProdukt() throws Exception {
        Produkt p=new Produkt();
        p.setNazwa("Biala Mewa");
        p.setCena(60);
        p.setObjetosc_mg(80);
        m.dodajProdukt(p);
        List<Produkt> l = m.getAllProdukt();
        assertTrue(l.size()==1);
        assertEquals("Biala Mewa",l.get(0).getNazwa());
    }

    @Test
    public void usunProducent() throws Exception {
        Producent pierwszy = new Producent();
            pierwszy.setNazwa("Bialynosek");
            pierwszy.setKraj("Polska");
        Producent usuwany = new Producent();
            usuwany.setNazwa("Wegorz");
            usuwany.setKraj("Rumunia");
        assertEquals(true,m.dodajProducenta(pierwszy));
        assertEquals(true,m.dodajProducenta(usuwany));
        assertEquals(true,m.usunProducent(usuwany));
        List<Producent> lista;
        lista = m.getAllProducent();
        assertEquals(1,lista.size());
        assertEquals("Bialynosek",m.getAllProducent().get(0).getNazwa());

    }

    @Test
    public void usunProdukt() throws Exception {
        Produkt pierwszy = new Produkt();
        pierwszy.setNazwa("Metanabol");
        pierwszy.setCena(20.50);
        pierwszy.setObjetosc_mg(60);

        Produkt usuwany = new Produkt();
        usuwany.setNazwa("HGH");
        usuwany.setCena(90.00);
        usuwany.setObjetosc_mg(40);
        assertEquals(true,m.dodajProdukt(pierwszy));
        assertEquals(true,m.dodajProdukt(usuwany));
        assertTrue(m.usunProdukt(usuwany));
        List<Produkt> lista;
        lista = m.getAllProdukt();
        assertEquals(1,lista.size());
        assertEquals("Metanabol",m.getAllProdukt().get(0).getNazwa());
    }

    @Test
    public void dropProducent() throws Exception {
        boolean test = m.dropProducent();
        assertTrue(test);
    }

    @Test
    public void dropProdukt() throws Exception {
        boolean test = m.dropProdukt();
        assertTrue(test);
    }

    @Test
    public void closeConnection() throws Exception {
        boolean test = m.closeConnection();
        assertTrue(test);
        assertEquals(false,m.generujBaze());
    }


    @Test
    public void checkrelation() throws Exception {
        Producent p1=new Producent();
        p1.setKraj("Polska");
        p1.setNazwa("SuperKoks");
        assertTrue(m.dodajProducenta(p1));
        Produkt p2=new Produkt();
        p2.setNazwa("Metanabol");
        p2.setCena(15.20);
        p2.setObjetosc_mg(30);
        long tmp = m.getAllProducent().get(0).getId();
        p2.setId_producent(tmp);
        assertTrue(m.dodajProdukt(p2));
        assertEquals(tmp,m.getAllProdukt().get(0).getId_producent());
    }

    @Test
    public void checkUpdateProducent() throws Exception {
        Producent p1=new Producent();
        p1.setKraj("Polska");
        p1.setNazwa("SuperKoks");
        m.dodajProducenta(p1);
        p1=m.getAllProducent().get(0);
        p1.setNazwa("nowaNazwa");
        m.updateProducent(p1);
        assertEquals(p1.getNazwa(),m.getAllProducent().get(0).getNazwa());
    }
    @Test
    public void checkUpdateProdukt() throws Exception {
        Produkt p2=new Produkt();
        p2.setNazwa("Metanabol");
        p2.setCena(15.20);
        p2.setObjetosc_mg(30);
        m.dodajProdukt(p2);
        p2=m.getAllProdukt().get(0);
        p2.setNazwa("nowaNazwa");
        m.updateProdukt(p2);
        assertEquals(p2.getNazwa(),m.getAllProdukt().get(0).getNazwa());

    }

    @Test
    public void checkselectProduktofProducent() throws Exception {
        Producent pierwszypr = new Producent();
        pierwszypr.setNazwa("Bialynosek");
        pierwszypr.setKraj("Polska");
        assertEquals(true,m.dodajProducenta(pierwszypr));

        Produkt pierwszyp = new Produkt();
        pierwszyp.setNazwa("Metanabol");
        pierwszyp.setCena(20.50);
        pierwszyp.setObjetosc_mg(60);

        Produkt drugip = new Produkt();
        drugip.setNazwa("HGH");
        drugip.setCena(90.00);
        drugip.setObjetosc_mg(40);

        pierwszyp.setId_producent(m.getAllProducent().get(0).getId());
        drugip.setId_producent(m.getAllProducent().get(0).getId());

        assertEquals(true,m.dodajProdukt(pierwszyp));
        assertEquals(true,m.dodajProdukt(drugip));

        List<Produkt> lista=m.selectProduktofProducent(m.getAllProducent().get(0));

        assertEquals(2,lista.size());
    }



}