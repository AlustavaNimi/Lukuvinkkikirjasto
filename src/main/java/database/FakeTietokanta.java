package database;

import domain.Kirja;
import java.util.ArrayList;

public class FakeTietokanta implements Tietokanta{
    
    private ArrayList<Kirja> lukuvinkit = new ArrayList<>();

    @Override
    public void lisaa(Kirja kirja) {
        lukuvinkit.add(kirja);
    }

    @Override
    public ArrayList<Kirja> haeLukuvinkit() {
        return lukuvinkit;
    }
    
}
