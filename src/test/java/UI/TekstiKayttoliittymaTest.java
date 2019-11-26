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
        db.lisaa(new Kirja("test"));
        db.lisaa(new Kirja("test2"));
    }
    
    @Test
    public void testRun() {
        io.inputs.add("tuntematon komento");
        io.inputs.add("lopeta");
        ui.run();
        assertEquals("Tervetuloa Lukuvinkkisovellukseen!", io.outputs.get(0));
        assertEquals("", io.outputs.get(1));
        assertEquals("Käytettävissä olevat komennot:", io.outputs.get(2));
        assertEquals("Lisaa", io.outputs.get(3));
        assertEquals("Lisaa otsikolla", io.outputs.get(4));
        assertEquals("Selaa", io.outputs.get(5));
        assertEquals("Lopeta", io.outputs.get(6));
        assertEquals("", io.outputs.get(7));
        assertEquals("Tuntematon komento", io.outputs.get(8));
    }
    
    @Test
    public void testSelaa() {
        io.inputs.add("selaa");
        ui.selaa();
        assertEquals(db.haeLukuvinkit().get(0).toString(), io.outputs.get(0));
        assertEquals("", io.outputs.get(1));
        assertEquals(db.haeLukuvinkit().get(1).toString(), io.outputs.get(2));
        assertEquals("", io.outputs.get(3));
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
