package database;

import domain.Blogipostaus;
import domain.Kirja;

public class KovakoodattuData {

    //private String tietokantaOsoite;
    private Tietokanta tk;
    private Kirja kirja1;
    private Blogipostaus blogipostaus1;

    public KovakoodattuData() {
        this.kirja1 = new Kirja(1, "Tirakirja", "A. Laaksonen", "9788373191723", "Ei hajota yhtään", 2019, "Tietorakenteet ja algoritmit");
        this.blogipostaus1 = new Blogipostaus(2, "https://blogit.kaleva.fi/taidon-aani/mita-on-tietojenkasittely",
                "Mitä on tietojenkäsittely", "Lyhyt esittely alaan", "JTKT", "Taidon Ääni", 2019);
    }

    public void lisaaKovakoodattuData(Tietokanta tk) {
        tk.lisaaKirja(kirja1);
        tk.lisaaBlogi(blogipostaus1);
    }
}
