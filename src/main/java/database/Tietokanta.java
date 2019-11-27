
package database;

import domain.Kirja;
import domain.Lukuvinkki;
import java.util.ArrayList;

public interface Tietokanta {
    
    public void lisaaKirja(Lukuvinkki lukuvinkki);
    
    public void lisaaBlogi(Lukuvinkki lukuvinkki);
    
    public ArrayList<Lukuvinkki> haeLukuvinkit();
    
}
