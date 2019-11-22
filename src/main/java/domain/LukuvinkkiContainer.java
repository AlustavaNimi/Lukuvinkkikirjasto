
package domain;

import java.util.ArrayList;

public class LukuvinkkiContainer { // Luokka korvattu FakeTietokanta luokalla
    private ArrayList<Kirja> lukuvinkit = new ArrayList<>();
    
    public void lisaaLukuvinkki(Kirja kirja) {
        lukuvinkit.add(kirja);
    }
    
    public void selaaLukuvinkit() {
        for (Kirja kirja : lukuvinkit) {
            System.out.println(kirja);
            System.out.println("");
        }
    }
}
