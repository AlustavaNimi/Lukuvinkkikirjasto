package domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class LukuvinkkiTest {

    private Lukuvinkki l;
    private Lukuvinkki lukuvinkkiPelkallaOtsikolla;

    public LukuvinkkiTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        l = new Lukuvinkki("otsikko", "kuvaus", "kurssi", "kirjoittaja", 0);
        lukuvinkkiPelkallaOtsikolla = new Lukuvinkki("otsikko");

    }

    @After
    public void tearDown() {
    }

    @Test
    public void testGetOtsikko() {
        assertEquals(l.getOtsikko(), "otsikko");
    }

    @Test
    public void testSetOtsikko() {
        l.setOtsikko("testi");
        assertEquals(l.getOtsikko(), "testi");
    }

    @Test
    public void testGetKuvaus() {
        assertEquals(l.getKuvaus(), "kuvaus");
    }

    @Test
    public void testSetKuvaus() {
        l.setKuvaus("testi");
        assertEquals(l.getKuvaus(), "testi");
    }

    @Test
    public void testGetKurssi() {
        assertEquals(l.getKurssi(), "kurssi");
    }

    @Test
    public void testSetKurssi() {
        l.setKurssi("testi");
        assertEquals(l.getKurssi(), "testi");

    }

    @Test
    public void testGetJulkaisuVuosi() {
        assertEquals(l.getJulkaisuVuosi(), 0);

    }

    @Test
    public void testSetJulkaisuVuosi() {
        l.setJulkaisuVuosi(100);
        assertEquals(l.getJulkaisuVuosi(), 100);

    }

    @Test
    public void testToString() {
            String teksti = "Otsikko: otsikko"
                    + "\nJulkaisuvuosi: 0"
                    + "\nRelated Courses: kurssi"
                    + "\nTagit: ";
            
            assertEquals(l.toString(), teksti);
    }

}
