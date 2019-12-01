package domain;

import java.util.ArrayList;

public class Kirja extends Lukuvinkki{

    private String ISBN;

    public Kirja(String otsikko, String kirjoittaja, String ISBN, String kuvaus, int julkaisuVuosi, String kurssi) {
        super(otsikko,kuvaus,kurssi, kirjoittaja,julkaisuVuosi);
        this.ISBN = ISBN;
    }
    
    public Kirja(int id, String otsikko, String kirjoittaja, String ISBN, String kuvaus, int julkaisuVuosi, String kurssi) {
        super(id, otsikko,kuvaus,kurssi, kirjoittaja,julkaisuVuosi);
        this.ISBN = ISBN;
    }
    
    public Kirja(String otsikko) {
        super(otsikko);
        this.ISBN = "";
    }
   

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }


    @Override
    public String toString() {
        String tuloste = super.toString();
        tuloste += "\nKirjoittaja: " + this.getKirjoittaja();
        tuloste += "\nTyyppi: Kirja";
        tuloste += "\nISBN: " + ISBN;
        return tuloste;
    }
       
}
