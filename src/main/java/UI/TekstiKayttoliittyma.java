package UI;

import database.FakeTietokanta;
import database.Tietokanta;
import domain.Kirja;
import domain.LukuvinkkiContainer;
import java.util.Scanner;

public class TekstiKayttoliittyma implements Kayttoliittyma{
    
    private Scanner lukija;
    Tietokanta lukuvinkit = new FakeTietokanta();

    public TekstiKayttoliittyma(Scanner lukija) {
        this.lukija = lukija;
    }
   
    public void run() {
        System.out.println("Tervetuloa Lukuvinkisovellukseen!");
        
        Scanner lukija = new Scanner(System.in);
        tulostaKomennot();
        
        String syote = lukija.nextLine();
        
        while(!syote.toLowerCase().equals("lopeta")) {
            if (syote.toLowerCase().equals("lisaa")) {
                lisaa();
            } else if (syote.toLowerCase().equals("lisaa otsikolla")) {
                lisaaOtsikolla();
            } else if (syote.toLowerCase().equals("selaa")) {
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
    
    public void selaa() {
        for (Kirja kirja : lukuvinkit.haeLukuvinkit()) {
            System.out.println(kirja);
            System.out.println("");
        }
    }

    public void lisaa() {
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

    public void lisaaOtsikolla() { // Riittää antaa pelkkä otsikko
        System.out.println("Anna kirjalle Otsikko: ");
        String otsikko = lukija.nextLine();
        Kirja kirja = new Kirja(otsikko);
        //Kirja kirja = new Kirja(otsikko,"","","",0,"");
        lukuvinkit.lisaa(kirja);
        System.out.println("Uusi lukuvinkki lisätty");
    }


    
}