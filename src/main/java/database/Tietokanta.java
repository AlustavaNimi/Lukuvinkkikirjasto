
package database;

import domain.Kirja;
import java.util.ArrayList;

/**
 *
 * @author matilaol
 */
public interface Tietokanta {
    
    public void lisaa(Kirja kirja);
    
    public ArrayList<Kirja> haeLukuvinkit();
    
}
