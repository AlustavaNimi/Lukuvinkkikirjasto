package database;

import domain.Blogipostaus;
import domain.Kirja;
import domain.Lukuvinkki;
import java.io.File;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class LukuvinkkiDaoTest {

    Tietokanta tietokanta = new LukuvinkkiDao("jdbc:sqlite:test.db");
    Kirja kirja = new Kirja("Otsikkotest", "Kirjoittajatest", "ISBNTEST", "Kuvaustest", 1234, "Kurssitest");
    Blogipostaus blogi = new Blogipostaus("URLtest", "Otsikkotest", "Kuvaustest", "Kurssitest", "Kirjoittajatest", 1234);
    KovakoodattuData data = new KovakoodattuData();

    public LukuvinkkiDaoTest() {
        data.lisaaKovakoodattuData(tietokanta);
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
        File file = new File("test.db");
        file.delete();
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testHaeLukuvinkit() {
        assertTrue(0 < tietokanta.haeLukuvinkit().size());
    }

    @Test
    public void testLisaaKirja() {
        int alkuKoko = tietokanta.haeLukuvinkit().size();
        tietokanta.lisaaKirja(kirja);
        assertNotEquals(alkuKoko, tietokanta.haeLukuvinkit().size());
    }

    @Test
    public void testLisaaBlogi() {
        int alkuKoko = tietokanta.haeLukuvinkit().size();
        tietokanta.lisaaBlogi(blogi);
        assertNotEquals(alkuKoko, tietokanta.haeLukuvinkit().size());
    }

    @Test
    public void testMuokkaaLukuvinkkia() {
        if (!tietokanta.haeLukuvinkit().isEmpty()) {
            Lukuvinkki vinkki = tietokanta.haeLukuvinkit().get(0);
            vinkki.setOtsikko("uusiOtsikko");
            tietokanta.muokkaaLukuvinkkia(vinkki);
            assertEquals("uusiOtsikko", tietokanta.haeLukuvinkit().get(0).getOtsikko());
        }
    }

    @Test
    public void testPoistaLukuvinkki() {
        int alkuKoko = tietokanta.haeLukuvinkit().size();
        if (tietokanta.haeLukuvinkit().size() > 2) {
            tietokanta.poistaLukuvinkki(tietokanta.haeLukuvinkit().get(0));
            assertNotEquals(alkuKoko, tietokanta.haeLukuvinkit().size());
        }
    }

    @Test
    public void testHaeLukuvinkki() {
        if (tietokanta.haeLukuvinkit().size() > 0) {
            Lukuvinkki vinkki = tietokanta.haeLukuvinkit().get(0);
            Integer vinkkiID = vinkki.getId();
            assertEquals(vinkki.getOtsikko(), tietokanta.haeLukuvinkki(vinkkiID).getOtsikko());
        }
    }



}
