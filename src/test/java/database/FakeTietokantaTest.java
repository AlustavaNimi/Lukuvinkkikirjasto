
package database;

import domain.Kirja;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class FakeTietokantaTest {
    private FakeTietokanta ftk;
    
    public FakeTietokantaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        ftk = new FakeTietokanta();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testLisaa() {
        assertEquals(ftk.haeLukuvinkit().size(), 0);
        ftk.lisaaKirja(new Kirja("otsikko"));
        assertEquals(ftk.haeLukuvinkit().size(), 1);
    }


    
}
