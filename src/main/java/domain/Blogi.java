package domain;

public class Blogi extends Lukuvinkki {
    private String url;

    public Blogi(String url, String otsikko, String kuvaus, String kurssi, String kirjoittaja, int julkaisuVuosi) {
        super(otsikko, kuvaus, kurssi, kirjoittaja, julkaisuVuosi);
        this.url = url;
    }

    public Blogi(String otsikko) {
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
        tuloste += "\nTyyppi: Blogi";
        return tuloste;
    }    
    
}
