package domain;

public class Blogi extends Lukuvinkki {
    private String url;

    public Blogi(String url, String otsikko, String kuvaus, String kurssi, int julkaisuVuosi) {
        super(otsikko, kuvaus, kurssi, julkaisuVuosi);
        this.url = url;
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
