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
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testInitComponents() {

    }

    @Test
    public void testLukuvinkinMuokkaus() {

    }

    @Test
    public void testLukuvinkinLisays() {
    }

}
