
import UI.Kayttoliittyma;
import java.util.Scanner;


public class Sovellus {
    
    public static void main(String[] args) {
        
        Scanner lukija = new Scanner(System.in);
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(lukija);
        kayttoliittyma.run();
        

    }
}
