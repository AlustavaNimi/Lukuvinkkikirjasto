/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;


import domain.Lukuvinkki;
import javax.swing.JFrame;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PiirtoalustaTest {

    private JFrame frame;
    private Piirtoalusta alusta;
    private Lukuvinkki vinkki;
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
        alusta = new Piirtoalusta();
        vinkki = new Lukuvinkki("otsikko", "kuvaus", "kurssi", "kirjoittaja", 1234);
        frame = new JFrame();
    }

    @After
    public void tearDown() {
        frame.dispose();
    }

    @Test
    public void testInitComponents() {
        frame = alusta.initComponents(frame, true);
        assertTrue(alusta.isVisible());
        assertTrue(frame.isResizable());
    }

    @Test
    public void testLukuvinkinMuokkaus() {
        frame = alusta.lukuvinkinMuokkaus(frame, vinkki);
        assertTrue(alusta.isVisible());
    }

    @Test
    public void testLukuvinkinLisays() {
        frame = alusta.lukuvinkinLisays(frame);
        assertTrue(alusta.isVisible());
    }

}
