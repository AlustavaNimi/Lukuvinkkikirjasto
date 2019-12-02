package domain;

public class Blogipostaus extends Lukuvinkki {
    private String url;

    public Blogipostaus(String url, String otsikko, String kuvaus, String kurssi, String kirjoittaja, int julkaisuVuosi) {
        super(otsikko, kuvaus, kurssi, kirjoittaja, julkaisuVuosi, "blogi");
        this.url = url;
    }

    public Blogipostaus(int id, String url, String otsikko, String kuvaus, String kurssi, String kirjoittaja, int julkaisuVuosi) {
        super(id, otsikko, kuvaus, kurssi, kirjoittaja, julkaisuVuosi, "blogi");
        this.url = url;
    }

    public Blogipostaus(String otsikko) {
        super(otsikko);
        this.url = "";
    }

    public String getUrl() {
        return url;
    }


    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        String tuloste = super.toString();
        tuloste += "\nURL: " + this.getUrl();
        tuloste += "\nTyyppi: Blogipostaus";
        return tuloste;
    }    
    
}
