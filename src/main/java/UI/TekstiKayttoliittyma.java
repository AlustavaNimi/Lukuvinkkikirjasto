package UI;

import IO.IO;
import database.FakeTietokanta;
import database.KirjaDao;
import database.Tietokanta;
import domain.Kirja;
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
            if (syote.toLowerCase().equals("lisaa")) {
                lisaa();
            } else if (syote.toLowerCase().equals("lisaa otsikolla")) {
                lisaaOtsikolla();
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
    }

    private void tulostaKomennot() {
        io.print("");
        io.print("Käytettävissä olevat komennot:");
        io.print("Lisaa");
        io.print("Lisaa otsikolla");
        io.print("Selaa");
        io.print("Valitse " + "<lukuvinkin numero>");
        io.print("Lopeta");
        io.print("");
    }

    public void selaa() {
        int avain = 1;
        for (Kirja kirja : lukuvinkit.haeLukuvinkit()) {
            io.print(avain + ". " + kirja.getOtsikko());
            io.print(kirja.getKirjailija());
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
        lukuvinkit.lisaa(kirja);
        io.print("Uusi lukuvinkki lisätty");
    }

    public void lisaaOtsikolla() { // Riittää antaa pelkkä otsikko
        io.print("Anna kirjalle Otsikko: ");
        String otsikko = io.nextLine();
        Kirja kirja = new Kirja(otsikko);
        //Kirja kirja = new Kirja(otsikko,"","","",0,"");
        lukuvinkit.lisaa(kirja);
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

}
