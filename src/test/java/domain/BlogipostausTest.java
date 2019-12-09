package domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class BlogipostausTest {
    private Blogipostaus blogi;
    private Blogipostaus blogiPelkallaOtsikolla;
    
    public BlogipostausTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        // String url, String otsikko, String kuvaus, String kurssi, String kirjoittaja, int julkaisuVuosi
        blogi = new Blogipostaus("joku url.com", "Otsikko", "Kuvaus", "Kurssi", "Tekijä X", 2019);
        blogiPelkallaOtsikolla = new Blogipostaus("Pelkkä otsikko");
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetKirjailija() {
        assertEquals(blogi.getKirjoittaja(), "Tekijä X");
        assertEquals(blogiPelkallaOtsikolla.getOtsikko(), "Pelkkä otsikko");
    }

    @Test
    public void testSetKirjailija() {
        blogi.setKirjoittaja("Testi");
        assertEquals(blogi.getKirjoittaja(), "Testi");
    }

    @Test
    public void testGetUrl() {
        assertEquals(blogi.getUrl(), "joku url.com");

    }

    @Test
    public void testSetUrl() {
        blogi.setUrl("Testi");
        assertEquals(blogi.getUrl(), "Testi");
    }
}
