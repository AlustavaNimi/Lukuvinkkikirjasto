package domain;

import java.util.ArrayList;

public class Lukuvinkki {
    
     private String otsikko;
     private String kuvaus;
     private String kurssi;
     private ArrayList<String> tagit;
     private int julkaisuVuosi;

    public Lukuvinkki(String otsikko, String kuvaus, String kurssi, int julkaisuVuosi) {
        alusta(otsikko, kuvaus, kurssi, julkaisuVuosi);
    }
    
    public Lukuvinkki(String otsikko) {
        alusta(otsikko,"","",0);
    }
     
    
    public String getOtsikko() {
        return otsikko;
    }

    public void setOtsikko(String otsikko) {
        this.otsikko = otsikko;
    }

    public String getKuvaus() {
        return kuvaus;
    }

    public void setKuvaus(String kuvaus) {
        this.kuvaus = kuvaus;
    }

    public String getKurssi() {
        return kurssi;
    }

    public void setKurssi(String kurssi) {
        this.kurssi = kurssi;
    }

    public int getJulkaisuVuosi() {
        return julkaisuVuosi;
    }

    public void setJulkaisuVuosi(int julkaisuVuosi) {
        this.julkaisuVuosi = julkaisuVuosi;
    }

    @Override
    public String toString() {
        String tuloste = "";
        tuloste += "Otsikko: " + this.getOtsikko();
        tuloste += "\njulkaisuVuosi: " + this.getJulkaisuVuosi();
        tuloste += "\nRelated Courses: " + this.getKurssi();
        tuloste += "\nTagit: ";
        for (String tagi: tagit) {
            tuloste += tagi + " ";
        }
        return tuloste;
    }

    private void alusta(String otsikko, String kuvaus, String kurssi, int julkaisuVuosi) {
        this.otsikko = otsikko;
        this.kuvaus = kuvaus;
        this.kurssi = kurssi;
        this.julkaisuVuosi = julkaisuVuosi;
        tagit = new ArrayList<>();
    }
     
    
    
}
