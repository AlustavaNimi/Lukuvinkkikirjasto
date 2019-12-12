package UI;

import database.FakeTietokanta;
import database.LukuvinkkiDao;
import database.Tietokanta;
import domain.Lukuvinkki;
import javax.swing.JFrame;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class GraafinenKayttoliittymaTest {

    private Piirtoalusta alusta;
    private Lukuvinkki vinkki1;
    private Lukuvinkki vinkki2;
    private GraafinenKayttoliittyma GUI;
    private NappaimistonKuuntelija kuuntelija;
    private Tietokanta tietokanta;
    private JFrame frame;

    public GraafinenKayttoliittymaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        tietokanta = new FakeTietokanta();
        vinkki1 = new Lukuvinkki("testiotsikko", "testikuvaus", "testikurssi", "testikirjoittaja", 1234, "kirja");
        vinkki2 = new Lukuvinkki("otsikkotesti", "kuvaustesti", "kurssitesti", "kirjoittajatesti", 4321, "blogi");
        tietokanta.lisaaBlogi(vinkki2);
        tietokanta.lisaaKirja(vinkki1);
        GUI = new GraafinenKayttoliittyma(tietokanta);
        GUI.run();
        frame = GUI.getFrame();
        alusta = GUI.getAlusta();
        kuuntelija = new NappaimistonKuuntelija(alusta);
        alusta.setGUIforKuuntelija(GUI);
    }

    @After
    public void tearDown() {
        frame.dispose();
    }

    @Test
    public void testPoistaLukuvinkki() {
        frame = alusta.initComponents(frame, false, false);
        GUI.selaa();
        assertTrue(alusta.getOutput().getText().contains("testiotsikko"));
        GUI.poistaLukuvinkki();
        alusta = GUI.getAlusta();
        assertTrue(alusta.getOutput().getText().contains("Lukuvinkki poistettu!"));
    }

    @Test
    public void testTulostaYksittainenLukuvinkki() {
        frame = alusta.initComponents(frame, false, false);
        GUI.selaa();
        assertFalse(alusta.getOutput().getText().contains("kurssitesti"));
        GUI.tulostaYksittainenLukuvinkki(1);
        alusta = GUI.getAlusta();
        assertTrue(alusta.getOutput().getText().contains("kurssitesti"));
    }

    @Test
    public void testSelaa() {
        frame = alusta.initComponents(frame, false, false);
        assertFalse(alusta.getOutput().getText().contains("Otsikko"));
        GUI.selaa();
        assertTrue(alusta.getOutput().getText().contains("Otsikko"));
    }

    @Test
    public void testSelaaHakusanalla() {
        frame = alusta.initComponents(frame, false, false);
        GUI.selaa();
        alusta = GUI.getAlusta();
        assertTrue(alusta.getOutput().getText().contains("testiotsikko"));
        assertTrue(alusta.getOutput().getText().contains("otsikkotesti"));
        GUI.selaaHakusanalla("testiotsikko");
        assertTrue(alusta.getOutput().getText().contains("testiotsikko"));
        assertFalse(alusta.getOutput().getText().contains("otsikkotesti"));
    }

    @Test
    public void testLisaaKirja() {
        Lukuvinkki kirja = new Lukuvinkki("LisattyKirja", "", "", "", 1234, "kirja");
        frame = alusta.initComponents(frame, false, false);
        GUI.selaa();
        alusta = GUI.getAlusta();
        assertFalse(alusta.getOutput().getText().contains("LisattyKirja"));
        tietokanta.lisaaKirja(kirja);
        GUI.selaa();
        alusta = GUI.getAlusta();
        assertTrue(alusta.getOutput().getText().contains("LisattyKirja"));

    }

    @Test
    public void testLisaaBlogi() {
        Lukuvinkki blogi = new Lukuvinkki("LisattyBlogi", "", "", "", 1234, "blogi");
        frame = alusta.initComponents(frame, false, false);
        GUI.selaa();
        alusta = GUI.getAlusta();
        assertFalse(alusta.getOutput().getText().contains("LisattyBlogi"));
        tietokanta.lisaaKirja(blogi);
        GUI.selaa();
        alusta = GUI.getAlusta();
        assertTrue(alusta.getOutput().getText().contains("LisattyBlogi"));
    }

    @Test
    public void testMuokkaaVinkkia() {
        frame = alusta.initComponents(frame, true, true);
        assertFalse(GUI.getMuokkaus());
        GUI.muokkaaVinkkia(1);
        assertTrue(GUI.getMuokkaus());
    }

    @Test
    public void testTallennaMuokkaus() {

    }

    @Test
    public void testLisaaLukuvinkkiValikko() {

    }

    @Test
    public void testLisaaLukuvinkki() {

    }

    @Test
    public void testUusiAlusta() {
        frame = alusta.initComponents(frame, false, false);
        GUI.selaa();
        assertTrue(alusta.getOutput().getText().contains("testiotsikko"));
        GUI.tulostaYksittainenLukuvinkki(1);
        alusta = GUI.getAlusta();
        assertFalse(alusta.getOutput().getText().contains("testiotsikko"));
        GUI.uusiAlusta();
        alusta = GUI.getAlusta();
        assertTrue(alusta.getOutput().getText().contains("testiotsikko"));

    }

    @Test
    public void testAvaaLinkki() {

    }

}
