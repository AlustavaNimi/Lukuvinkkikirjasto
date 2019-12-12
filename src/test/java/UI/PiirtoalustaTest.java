/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import database.FakeTietokanta;
import database.LukuvinkkiDao;
import database.Tietokanta;
import domain.Lukuvinkki;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PiirtoalustaTest {

    private Piirtoalusta alusta;
    private Lukuvinkki vinkki;
    private GraafinenKayttoliittyma GUI;
    private NappaimistonKuuntelija kuuntelija;
    private Tietokanta tietokanta;
    private JFrame frame;

    public PiirtoalustaTest() {

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
        vinkki = new Lukuvinkki("testiotsikko", "kuvaus", "kurssi", "kirjoittaja", 1234,"kirja");
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
    public void testInitComponents() {
        frame = alusta.initComponents(GUI.getFrame(), false,false);
        assertTrue(alusta.isVisible());
        assertTrue(GUI.getFrame().isVisible());
    }

    @Test
    public void testLukuvinkinLisays() {
        frame = alusta.initComponents(GUI.getFrame(), false,false);
        assertFalse(alusta.getOutput().getText().contains("testiotsikko"));
        frame = alusta.lukuvinkinLisays(GUI.getFrame());
        assertEquals(alusta.getInput().getText(), "");
        assertEquals(alusta.getVinkinTiedot().get(0).getText(), "");
        
    }

    @Test
    public void testLukuvinkinMuokkaus() {
        frame = alusta.initComponents(GUI.getFrame(), true,false);
        frame = alusta.lukuvinkinMuokkaus(frame, vinkki);
        assertEquals(alusta.getTallennaNappi().getText(), "Tallenna");
    }
}
