package domain;

import java.util.ArrayList;

public class Lukuvinkki {
    
     private String otsikko;
     private String kuvaus;
     private String kurssi;
     private ArrayList<String> tagit;
     private int julkaisuVuosi;

    public Lukuvinkki(String otsikko, String kuvaus, String kurssi, int julkaisuVuosi) {
        this.otsikko = otsikko;
        this.kuvaus = kuvaus;
        this.kurssi = kurssi;
        this.julkaisuVuosi = julkaisuVuosi;
        tagit = new ArrayList<>();
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
     
     
    
}
