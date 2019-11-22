package UI;

import database.FakeTietokanta;
import database.Tietokanta;
import domain.Kirja;
import domain.LukuvinkkiContainer;
import java.util.Scanner;

public class Kayttoliittyma {
    
    private Scanner lukija;
    Tietokanta lukuvinkit = new FakeTietokanta();

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
            } else if (syote.equals("Lisaa Otsikolla")) {
                lisaaOtsikolla();
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
        System.out.println("Lisaa Otsikolla");
        System.out.println("Selaa");
        System.out.println("Lopeta");
        System.out.println("");
    }
    
    private void selaa() {
        for (Kirja kirja : lukuvinkit.haeLukuvinkit()) {
            System.out.println(kirja);
            System.out.println("");
        }
    }

    private void lisaa() {
        String otsikko,kirjailija,ISBN,kuvaus,kurssi;
        int julkaisuVuosi = -1;
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
        while (julkaisuVuosi == -1) {
            System.out.println("Anna kirjalle julkaisuvuosi");
            String syote = lukija.nextLine();
            try {
                julkaisuVuosi = Integer.parseInt(syote);
            } catch (NumberFormatException e) {
                System.out.println("Virheellinen julkaisuvuosi");
            }
        }
        Kirja kirja = new Kirja(otsikko,kirjailija,ISBN,kuvaus,julkaisuVuosi,kurssi);
        lukuvinkit.lisaa(kirja);
        System.out.println("Uusi lukuvinkki lisätty");
    }

    private void lisaaOtsikolla() { // Riittää antaa pelkkä otsikko
        System.out.println("Anna kirjalle Otsikko: ");
        String otsikko = lukija.nextLine();
        Kirja kirja = new Kirja(otsikko);
        //Kirja kirja = new Kirja(otsikko,"","","",0,"");
        lukuvinkit.lisaa(kirja);
        System.out.println("Uusi lukuvinkki lisätty");
    }


    
}
