package domain;

public class Blogipostaus extends Lukuvinkki {
    private String url;

    public Blogipostaus(String url, String otsikko, String kuvaus, String kurssi, int julkaisuVuosi) {
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
        tuloste += "\nTyyppi: Blogipostaus";
        return tuloste;
    }    
    
}
