
package domain;

import database.Tietokanta;
import java.util.ArrayList;

public class LukuvinkkiContainer { 
    private ArrayList<Kirja> lukuvinkit = new ArrayList<>();
    Tietokanta tietokanta;

    public LukuvinkkiContainer(Tietokanta tietokanta) {
        this.tietokanta = tietokanta;
    }
    
    public void lisaa(Kirja kirja) {
        tietokanta.lisaa(kirja);
    }
    
    public ArrayList<Kirja> haeLukuvinkit() {
        lukuvinkit = tietokanta.haeLukuvinkit();
        return lukuvinkit;
    }

    public Kirja haeAvaimella(int avain) {
        avain--;
        if (avain >= 0 && avain < lukuvinkit.size()) return lukuvinkit.get(avain);
        return null;
    }
}
