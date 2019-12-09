
import UI.GraafinenKayttoliittyma;
import UI.Kayttoliittyma;
import database.FakeTietokanta;
import database.LukuvinkkiDao;
import database.Tietokanta;
import java.util.Scanner;
import javax.swing.SwingUtilities;

public class Sovellus {


    public static void main(String[] args) {

        Tietokanta lukuvinkit = new LukuvinkkiDao("jdbc:sqlite:db.db");
        GraafinenKayttoliittyma kayttoliittyma = new GraafinenKayttoliittyma(lukuvinkit);
        kayttoliittyma.run();

    }
}
