package domain;

import java.util.ArrayList;

public class Lukuvinkki {

    private int id;
    private String otsikko;
    private String kuvaus;
    private String kurssi;
    private String kirjoittaja;
    private ArrayList<String> tagit;
    private int julkaisuVuosi;

    public Lukuvinkki(int id, String otsikko, String kuvaus, String kurssi, String kirjoittaja, int julkaisuVuosi) {
        alusta(id, otsikko, kuvaus, kurssi, kirjoittaja, julkaisuVuosi);
    }

    public Lukuvinkki(String otsikko, String kuvaus, String kurssi, String kirjoittaja, int julkaisuVuosi) {
        alusta(-1, otsikko, kuvaus, kurssi, kirjoittaja, julkaisuVuosi);
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
        alusta(-1, otsikko, "", "", "", 0);
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

    private void alusta(int id, String otsikko, String kuvaus, String kurssi, String kirjoittaja, int julkaisuVuosi) {
        this.otsikko = otsikko;
        this.kuvaus = kuvaus;
        this.kurssi = kurssi;
        this.julkaisuVuosi = julkaisuVuosi;
        this.kirjoittaja = kirjoittaja;
        tagit = new ArrayList<>();
    }

}
