
package domain;

import java.util.ArrayList;

public class Kirja {
    
    private String otsikko;
    private String kirjailija;
    private String ISBN;
    private String kuvaus;
    private int julkaisuVuosi;
    private String kurssi;
    private ArrayList<String> tagit = new ArrayList<>();

    public Kirja(String otsikko, String kirjailija, String ISBN, String kuvaus, int julkaisuVuosi, String kurssi) {
        this.otsikko = otsikko;
        this.kirjailija = kirjailija;
        this.ISBN = ISBN;
        this.kuvaus = kuvaus;
        this.julkaisuVuosi = julkaisuVuosi;
        this.kurssi = kurssi;
    }
    
    public String getOtsikko() {
        return otsikko;
    }

    public void setOtsikko(String otsikko) {
        this.otsikko = otsikko;
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

    public String getKuvaus() {
        return kuvaus;
    }

    public void setKuvaus(String kuvaus) {
        this.kuvaus = kuvaus;
    }

    public int getJulkaisuVuosi() {
        return julkaisuVuosi;
    }

    public void setJulkaisuVuosi(int julkaisuVuosi) {
        this.julkaisuVuosi = julkaisuVuosi;
    }

    public String getKurssi() {
        return kurssi;
    }

    public void setKurssi(String kurssi) {
        this.kurssi = kurssi;
    }
    
    
    
}
