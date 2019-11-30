/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PiirtoalustaTest {

    private JFrame frame;
    private Piirtoalusta alusta;

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
        frame = new JFrame();
        alusta = new Piirtoalusta();
        System.setProperty("java.awt.headless", "true");
    }

    @After
    public void tearDown() {
        System.setProperty("java.awt.headless", "false");

    }

    @Test
    public void testInitComponents() {

    }

    @Test
    public void testLukuvinkinMuokkaus() {

    }

    @Test
    public void testLukuvinkinLisays() {
        frame = alusta.lukuvinkinLisays(frame);
        assertTrue(frame.isResizable());

    }

}
