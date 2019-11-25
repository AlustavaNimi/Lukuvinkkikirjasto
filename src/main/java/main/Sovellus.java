
import IO.KonsoliIO;
import UI.Kayttoliittyma;
import UI.TekstiKayttoliittyma;
import database.KirjaDao;
import database.Tietokanta;
import java.util.Scanner;


public class Sovellus {
    
    public static void main(String[] args) {
        Tietokanta lukuvinkit = new KirjaDao("jdbc:sqlite:kirjat.db");
        Kayttoliittyma kayttoliittyma = new TekstiKayttoliittyma(new KonsoliIO(), lukuvinkit);
        kayttoliittyma.run();
    }
}
