package domain;

import java.util.ArrayList;

public class Lukuvinkki {

    private int id;
    private String otsikko;
    private String kuvaus;
    private String kurssi;
    private String kirjoittaja;
    private String tyyppi;
    private ArrayList<String> tagit;
    private int julkaisuVuosi;

    public Lukuvinkki(int id, String otsikko, String kuvaus, String kurssi, String kirjoittaja, int julkaisuVuosi, String tyyppi) {
        alusta(id, otsikko, kuvaus, kurssi, kirjoittaja, julkaisuVuosi, tyyppi);
    }

    public Lukuvinkki(String otsikko, String kuvaus, String kurssi, String kirjoittaja, int julkaisuVuosi, String tyyppi) {
        alusta(-1, otsikko, kuvaus, kurssi, kirjoittaja, julkaisuVuosi, tyyppi);
    }

    public int getId() {
        return id;
    }

    public String getKirjoittaja() {
        return kirjoittaja;
    }

    public void setKirjoittaja(String kirjoittaja) {
        this.kirjoittaja = kirjoittaja;
    }

    public Lukuvinkki(String otsikko) {
        alusta(-1, otsikko, "", "", "", 0, "kirja");
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

    public String getTyyppi() {
        return tyyppi;
    }
    
    @Override
    public String toString() {
        String tuloste = "";
        tuloste += "Otsikko: " + this.getOtsikko();
        tuloste += "\nkirjoittaja: " + this.getKirjoittaja();
        tuloste += "\nJulkaisuvuosi: " + this.getJulkaisuVuosi();
        tuloste += "\nRelated Courses: " + this.getKurssi();
        tuloste += "\nTagit: ";
        for (String tagi : tagit) {
            tuloste += tagi + " ";
        }
        return tuloste;
    }

    public String lyhytTulostus() {
        String tuloste = "";
        tuloste += "Otsikko: " + this.getOtsikko();
        tuloste += "\nKirjoittaja: " + this.getKirjoittaja();
        
        return tuloste;
    }

    private void alusta(int id, String otsikko, String kuvaus, String kurssi, String kirjoittaja, int julkaisuVuosi, String tyyppi) {
        this.id = id;
        this.otsikko = otsikko;
        this.kuvaus = kuvaus;
        this.kurssi = kurssi;
        this.julkaisuVuosi = julkaisuVuosi;
        this.kirjoittaja = kirjoittaja;
        this.tyyppi = tyyppi;
        tagit = new ArrayList<>();
    }

}
