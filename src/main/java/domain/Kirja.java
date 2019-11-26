package domain;

import java.util.ArrayList;

public class Kirja extends Lukuvinkki{
    
    private String kirjailija;
    private String ISBN;

    public Kirja(String otsikko, String kirjailija, String ISBN, String kuvaus, int julkaisuVuosi, String kurssi) {
        super(otsikko,kuvaus,kurssi,julkaisuVuosi);
        this.kirjailija = kirjailija;
        this.ISBN = ISBN;
    }
    
    public Kirja(String otsikko) {
        super(otsikko);
        this.kirjailija = "";
        this.ISBN = "";
    }
    
    public String getKirjailija() {
        return kirjailija;
    }

    public void setKirjailija(String kirjailija) {
        this.kirjailija = kirjailija;
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
        tuloste += "\nKirjoittaja: " + this.getKirjailija();
        tuloste += "\nTyyppi: Kirja";
        tuloste += "\nISBN: " + ISBN;
        return tuloste;
    }
       
}
