
package database;

import domain.Kirja;
import java.util.ArrayList;

public interface Tietokanta {
    
    public void lisaa(Kirja kirja);
    
    public ArrayList<Kirja> haeLukuvinkit();
    
}
