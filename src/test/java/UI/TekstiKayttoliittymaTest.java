package UI;

import IO.IOStub;
import database.FakeTietokanta;
import domain.Kirja;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TekstiKayttoliittymaTest {

    TekstiKayttoliittyma ui;
    FakeTietokanta db;
    IOStub io;
    
    @Before
    public void setUp() {
        io = new IOStub();
        db = new FakeTietokanta();
        ui = new TekstiKayttoliittyma(io, db);
        db.lisaaKirja(new Kirja("test"));
        db.lisaaKirja(new Kirja("test2"));
    }
    

    
    
    @Test
    public void testLisaa() {
        io.inputs.add("otsikko");
        io.inputs.add("kirjoittaja");
        io.inputs.add("isbn");
        io.inputs.add("kuvaus");
        io.inputs.add("kurssi");
        io.inputs.add("virheellinen vuosi");
        io.inputs.add("2000");
        ui.lisaa();
        assertEquals(3, db.haeLukuvinkit().size());
        assertEquals("Anna kirjalle otsikko: ", io.outputs.get(0));
        assertEquals("Anna kirjalle kirjoittaja: ", io.outputs.get(1));
        assertEquals("Anna kirjalle ISBN:", io.outputs.get(2));
        assertEquals("Anna kirjalle kuvaus:", io.outputs.get(3));
        assertEquals("Anna kirjalle kurssi", io.outputs.get(4));
        assertEquals("Anna kirjalle julkaisuvuosi", io.outputs.get(5));
        assertEquals("Virheellinen julkaisuvuosi", io.outputs.get(6));
    }
    
    @Test
    public void testLisaaOtsikolla() {
        io.inputs.add("otsikko");
        ui.lisaaOtsikolla();
        assertEquals(3, db.haeLukuvinkit().size());
        assertEquals("Anna kirjalle Otsikko: ", io.outputs.get(0));
    }
}
