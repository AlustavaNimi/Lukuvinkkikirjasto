
import IO.KonsoliIO;
import UI.Kayttoliittyma;
import UI.TekstiKayttoliittyma;
import java.util.Scanner;


public class Sovellus {
    
    public static void main(String[] args) {
        Kayttoliittyma kayttoliittyma = new TekstiKayttoliittyma(new KonsoliIO());
        kayttoliittyma.run();
    }
}
