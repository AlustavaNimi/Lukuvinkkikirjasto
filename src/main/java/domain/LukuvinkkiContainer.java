
package domain;

import database.Tietokanta;
import java.util.ArrayList;

public class LukuvinkkiContainer { 
    private ArrayList<Lukuvinkki> lukuvinkit = new ArrayList<>();
    Tietokanta tietokanta;

    public LukuvinkkiContainer(Tietokanta tietokanta) {
        this.tietokanta = tietokanta;
    }
    
    public void lisaaKirja(Lukuvinkki lukuvinkki) {
        tietokanta.lisaaKirja(lukuvinkki);
    }
    
    public void lisaaBlogi(Lukuvinkki lukuvinkki) {
        tietokanta.lisaaBlogi(lukuvinkki);
    }
    
    public ArrayList<Lukuvinkki> haeLukuvinkit() {
        lukuvinkit = tietokanta.haeLukuvinkit();
        return lukuvinkit;
    }

    public Lukuvinkki haeAvaimella(int avain) {
        avain--;
        if (avain >= 0 && avain < lukuvinkit.size()) return lukuvinkit.get(avain);
        return null;
    }
}
