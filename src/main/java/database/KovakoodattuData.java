package database;

import domain.Blogipostaus;
import domain.Kirja;

public class KovakoodattuData {

    private Tietokanta tk;
    private Kirja kirja1;
    private Blogipostaus blogipostaus1;
    private Kirja kirja2;
    private Blogipostaus blogipostaus2;

    public KovakoodattuData() {
        this.kirja1 = new Kirja(1, "Tirakirja", "A. Laaksonen", "9788373191723", "Ei hajota yhtään", 2019, "Tira");
        this.blogipostaus1 = new Blogipostaus(2, "https://blogit.kaleva.fi/taidon-aani/mita-on-tietojenkasittely",
                "Mitä on tietojenkäsittely", "Lyhyt esittely alaan", "JTKT", "Taidon Ääni", 2019);
        this.kirja2 = new Kirja(3, "Introduction to Algorithms", "Cormen, Leiserson, Rivest, Stein", "978-0-262-03384-8", "TLDR: lue tirakirja", 1990, "Tira");
        this.blogipostaus2 = new Blogipostaus(4, "https://martinfowler.com/agile.html", "Agile Software Guide", "Tämä tyyppi on tuttu meidän kurssilta", "Ohtu", "Martin Fowler", 2019);
    }

    public void lisaaKovakoodattuData(Tietokanta tk) {
        tk.lisaaKirja(kirja1);
        tk.lisaaBlogi(blogipostaus1);
        tk.lisaaKirja(kirja2);
        tk.lisaaBlogi(blogipostaus2);
    }
}
