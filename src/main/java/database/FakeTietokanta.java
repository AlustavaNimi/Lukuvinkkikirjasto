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
    
}
