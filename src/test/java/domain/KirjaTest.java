package domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KirjaTest {

    private Kirja k;
    private Kirja kirjaPelkallaOtsikolla;

    public KirjaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        k = new Kirja("Otsikko", "Kirjailija", "ISBN", "Kuvaus", 2019, "Kurssi");
        kirjaPelkallaOtsikolla = new Kirja("Pelkkä otsikko");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testGetKirjailija() {
        assertEquals(k.getKirjoittaja(), "Kirjailija");
        assertEquals(kirjaPelkallaOtsikolla.getOtsikko(), "Pelkkä otsikko");
    }

    @Test
    public void testSetKirjailija() {
        k.setKirjoittaja("Testi");
        assertEquals(k.getKirjoittaja(), "Testi");
    }

    @Test
    public void testGetISBN() {
        assertEquals(k.getISBN(), "ISBN");

    }

    @Test
    public void testSetISBN() {
        k.setISBN("Testi");
        assertEquals(k.getISBN(), "Testi");
    }
    

}
