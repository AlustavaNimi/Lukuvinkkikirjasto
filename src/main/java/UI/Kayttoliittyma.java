package UI;

import domain.Kirja;
import domain.LukuvinkkiContainer;
import java.util.Scanner;

public class Kayttoliittyma {
    
    private Scanner lukija;
    LukuvinkkiContainer lukuvinkit = new LukuvinkkiContainer();

    public Kayttoliittyma(Scanner lukija) {
        this.lukija = lukija;
    }
   
    public void run() {
        System.out.println("Tervetuloa Lukuvinkisovellukseen!");
        
        Scanner lukija = new Scanner(System.in);
        tulostaKomennot();
        
        String syote = lukija.nextLine();
        while(!syote.equals("Lopeta")) {
            if (syote.equals("Lisaa")) {
                lisaa();
            } else if (syote.equals("Selaa")) {
                selaa();
            } else {
                System.out.println("Tuntematon komento");
            }
            tulostaKomennot();
            syote = lukija.nextLine();
        }
    }
    
    private void tulostaKomennot() {
        System.out.println("");
        System.out.println("Käytettävissä olevat komennot:");
        System.out.println("Lisaa");
        System.out.println("Selaa");
        System.out.println("Lopeta");
        System.out.println("");
    }
    
    private void selaa() {
        lukuvinkit.selaaLukuvinkit();
    }

    private void lisaa() {
        String otsikko;
        String kirjailija;
        String ISBN;
        String kuvaus;
        String kurssi;
        int julkaisuVuosi;
        System.out.println("Anna kirjalle Otsikko: ");
        otsikko = lukija.nextLine();
        System.out.println("Anna kirjalle kirjoittaja: ");
        kirjailija = lukija.nextLine();
        System.out.println("Anna kirjalle ISBN:");
        ISBN = lukija.nextLine();
        System.out.println("Anna kirjalle kuvaus:");
        kuvaus = lukija.nextLine();
        System.out.println("Anna kirjalle kurssi");
        kurssi = lukija.nextLine();
        System.out.println("Anna kirjalle julkaisuvuosi");
        julkaisuVuosi = Integer.parseInt(lukija.nextLine());
        Kirja kirja = new Kirja(otsikko,kirjailija,ISBN,kuvaus,julkaisuVuosi,kurssi);
        lukuvinkit.lisaaLukuvinkki(kirja);
    }


    
}
