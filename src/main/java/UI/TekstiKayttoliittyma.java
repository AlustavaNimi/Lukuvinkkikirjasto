package UI;

import IO.IO;
import database.FakeTietokanta;
import database.LukuvinkkiDao;
import database.Tietokanta;
import domain.Blogi;
import domain.Kirja;
import domain.Lukuvinkki;
import domain.LukuvinkkiContainer;
import java.util.Scanner;

public class TekstiKayttoliittyma implements Kayttoliittyma {

    IO io;
    LukuvinkkiContainer lukuvinkit;

    public TekstiKayttoliittyma(IO io, Tietokanta tietokanta) {
        this.io = io;
        this.lukuvinkit = new LukuvinkkiContainer(tietokanta);
    }

    public void run() {
        io.print("Tervetuloa Lukuvinkkisovellukseen!");

        tulostaKomennot();

        String syote = io.nextLine();

        while (!syote.toLowerCase().equals("lopeta")) {
            if (syote.toLowerCase().equals("lisaa kirja")) {
                lisaaKirja();
            } else if (syote.toLowerCase().equals("lisaa blogi")) {
                lisaaBlogi();
            } else if (syote.toLowerCase().equals("selaa")) {
                selaa();
            } else if (syote.toLowerCase().contains("valitse")) {
                avaaLukuvinkki(syote);
            } else {
                io.print("Tuntematon komento");
            }
            tulostaKomennot();
            syote = io.nextLine();
        }
        System.exit(0);
    }

    private void tulostaKomennot() {
        io.print("");
        io.print("Käytettävissä olevat komennot:");
        io.print("Lisaa kirja");
        io.print("Lisaa blogi");
        io.print("Selaa");
        io.print("Valitse " + "<lukuvinkin numero>");
        io.print("Lopeta");
        io.print("");
    }

    public void selaa() {
        int avain = 1;
        for (Lukuvinkki lukuvinkki : lukuvinkit.haeLukuvinkit()) {
            io.print(avain + ". " + lukuvinkki.getOtsikko());
            io.print(lukuvinkki.getKirjoittaja());
            io.print("");
            avain++;
        }
    }

    public void lisaa() {
        String otsikko, kirjailija, ISBN, kuvaus, kurssi;
        int julkaisuVuosi = -1;
        io.print("Anna kirjalle otsikko: ");
        otsikko = io.nextLine();
        io.print("Anna kirjalle kirjoittaja: ");
        kirjailija = io.nextLine();
        io.print("Anna kirjalle ISBN:");
        ISBN = io.nextLine();
        io.print("Anna kirjalle kuvaus:");
        kuvaus = io.nextLine();
        io.print("Anna kirjalle kurssi");
        kurssi = io.nextLine();
        while (julkaisuVuosi == -1) {
            io.print("Anna kirjalle julkaisuvuosi");
            String syote = io.nextLine();
            try {
                julkaisuVuosi = Integer.parseInt(syote);
            } catch (NumberFormatException e) {
                io.print("Virheellinen julkaisuvuosi");
            }
        }
        Kirja kirja = new Kirja(otsikko, kirjailija, ISBN, kuvaus, julkaisuVuosi, kurssi);
        lukuvinkit.lisaaKirja(kirja);
        io.print("Uusi lukuvinkki lisätty");
    }

    public void lisaaOtsikolla() { // Riittää antaa pelkkä otsikko
        io.print("Anna kirjalle Otsikko: ");
        String otsikko = io.nextLine();
        Kirja kirja = new Kirja(otsikko);
        //Kirja kirja = new Kirja(otsikko,"","","",0,"");
        lukuvinkit.lisaaKirja(kirja);
        io.print("Uusi lukuvinkki lisätty");
    }

    private void avaaLukuvinkki(String syote) {
        String avainStr = syote.substring("valitse ".length());
        try {
            int avain = Integer.parseInt(avainStr);
            io.print(lukuvinkit.haeAvaimella(avain));
        } catch (NumberFormatException e) {
            io.print("Virheellinen avain");
        } 
    }

    public void lisaaKirja() {
        io.print("Anna kirjalle Otsikko: ");
        String otsikko = io.nextLine();
        Kirja kirja = new Kirja(otsikko);
        lukuvinkit.lisaaKirja(kirja);
        io.print("Uusi kirja lisätty");
    }

    public void lisaaBlogi() {
        io.print("Anna blogille Otsikko: ");
        String otsikko = io.nextLine();
        Blogi blogi = new Blogi(otsikko);
        lukuvinkit.lisaaBlogi(blogi);
        io.print("Uusi blogi lisätty");
    }

}
