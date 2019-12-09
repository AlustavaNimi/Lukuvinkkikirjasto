package database;

import domain.Kirja;
import domain.Lukuvinkki;
import java.util.ArrayList;

public class FakeTietokanta implements Tietokanta{ 
    
    private ArrayList<Lukuvinkki> lukuvinkit = new ArrayList<>();


    @Override
    public ArrayList<Lukuvinkki> haeLukuvinkit() {
        return lukuvinkit;
    }

    @Override
    public void lisaaKirja(Lukuvinkki lukuvinkki) {
        lukuvinkit.add(lukuvinkki);
    }

    @Override
    public void lisaaBlogi(Lukuvinkki lukuvinkki) {
        lukuvinkit.add(lukuvinkki);
    }

    @Override
    public void poistaLukuvinkki(Lukuvinkki lukuvinkki) {
        lukuvinkit.remove(lukuvinkki);
    }

    @Override
    public Lukuvinkki haeLukuvinkki(int id) {
        return lukuvinkit.get(id - 1);
    }

    @Override
    public void muokkaaLukuvinkkia(Lukuvinkki lukuvinkki) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Lukuvinkki> haeLukuvinkitHakusananPerusteella(String hakusana, ArrayList<String> tyypit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
