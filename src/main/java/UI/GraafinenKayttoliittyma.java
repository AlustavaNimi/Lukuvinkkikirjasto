package UI;

import database.Tietokanta;
import domain.Blogipostaus;
import domain.Kirja;
import domain.Lukuvinkki;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class GraafinenKayttoliittyma implements Kayttoliittyma {

    private Tietokanta tietokanta;
    private Piirtoalusta alusta;
    private int screenW;
    private int screenH;
    private String komennot;
    private JFrame frame;
    private HashMap<Integer, Lukuvinkki> lukuvinkkiTaulu;
    private boolean selaus;
    private int selattavaVinkki;
    private boolean muokkaus;

    public GraafinenKayttoliittyma(Tietokanta lukuvinkit) {
        this.tietokanta = lukuvinkit;
        frame = new JFrame("Lukuvinkit");
        lukuvinkkiTaulu = new HashMap<>();
        selaus = false;
        muokkaus = false;
    }

    public GraafinenKayttoliittyma() {

    }

    public boolean getSelaus() {
        return selaus;
    }

    public boolean getMuokkaus() {
        return muokkaus;
    }

    @Override
    public void run() {
        screenW = Toolkit.getDefaultToolkit().getScreenSize().width;
        screenH = Toolkit.getDefaultToolkit().getScreenSize().height;
        frame = new JFrame("Lukuvinkit");
        alusta = new Piirtoalusta();
        frame.setPreferredSize(new Dimension(350, 450));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocation(screenW / 2, screenH / 2);
        frame.setVisible(true);
        frame = alusta.initComponents(frame, false, false);
        alusta.setGUIforKuuntelija(this);

    }

    public void poistaLukuvinkki() {
        tietokanta.poistaLukuvinkki(lukuvinkkiTaulu.get(selattavaVinkki));
        uusiAlusta();
        alusta.getOutput().setText("Vinkki poistettu!");
    }

    public void tulostaYksittainenLukuvinkki(int numero) {
        frame.getContentPane().remove(alusta);
        alusta = new Piirtoalusta();
        boolean onBlogi = lukuvinkkiTaulu.get(numero).getTyyppi().equals("blogi");
        frame = alusta.initComponents(frame, true, onBlogi);
        alusta.setGUIforKuuntelija(this);
        Lukuvinkki vinkki = lukuvinkkiTaulu.get(numero);
        alusta.getOutput().setText(vinkki.toString());
        selattavaVinkki = numero;
        selaus = false;
    }

    @Override
    public void selaa() {
        lukuvinkkiTaulu = new HashMap<>();
        selaus = true;
        int i = 1;

        String lukuvinkit = "";
        for (Lukuvinkki lukuvinkki : tietokanta.haeLukuvinkit()) {
            String numerointi = String.valueOf(i);
            lukuvinkit += numerointi + ". " + lukuvinkki.lyhytTulostus() + "\n\n";
            lukuvinkkiTaulu.put(i, lukuvinkki);
            i++;
        }
        alusta.getOutput().setText(lukuvinkit);
        alusta.getInput().setText("");

    }
    
    public void selaaHakusanalla(String hakusana) {
        lukuvinkkiTaulu = new HashMap<>();
        selaus = true;
        int i = 1;

        String lukuvinkit = "";
        for (Lukuvinkki lukuvinkki : tietokanta.haeLukuvinkitHakusananPerusteella(hakusana)) {
            String numerointi = String.valueOf(i);
            lukuvinkit += numerointi + ". " + lukuvinkki.lyhytTulostus() + "\n\n";
            lukuvinkkiTaulu.put(i, lukuvinkki);
            i++;
        }
        alusta.getOutput().setText(lukuvinkit);
        alusta.getInput().setText("");
    }

    @Override
    public void lisaaKirja() {
        alusta.getOutput().setText("Anna kirjalle Otsikko:");
    }

    @Override
    public void lisaaBlogi() {
        alusta.getOutput().setText("Anna blogipostaukselle Otsikko:");
    }

    public void muokkaaVinkkia() {
        frame.getContentPane().remove(alusta);
        alusta = new Piirtoalusta();
        frame = alusta.lukuvinkinMuokkaus(frame, lukuvinkkiTaulu.get(selattavaVinkki));
        alusta.setGUIforKuuntelija(this);
        muokkaus = true;
    }

    public void tallennaMuokkaus() {
        int id = lukuvinkkiTaulu.get(selattavaVinkki).getId();
        ArrayList<JTextField> lista = alusta.getVinkinTiedot();
        int vuosi = Integer.parseInt(lista.get(3).getText());
        lukuvinkkiTaulu.get(selattavaVinkki).setJulkaisuVuosi(vuosi);
        lukuvinkkiTaulu.get(selattavaVinkki).setOtsikko(lista.get(0).getText());
        lukuvinkkiTaulu.get(selattavaVinkki).setKirjoittaja(lista.get(1).getText());
        lukuvinkkiTaulu.get(selattavaVinkki).setKuvaus(lista.get(2).getText());
        lukuvinkkiTaulu.get(selattavaVinkki).setKurssi(lista.get(4).getText());
        if (lukuvinkkiTaulu.get(selattavaVinkki).getTyyppi().equals("kirja")) {
            Kirja k = (Kirja) lukuvinkkiTaulu.get(selattavaVinkki);
            k.setISBN(lista.get(5).getText());
        } else if (lukuvinkkiTaulu.get(selattavaVinkki).getTyyppi().equals("blogi")) {
            Blogipostaus b = (Blogipostaus) lukuvinkkiTaulu.get(selattavaVinkki);
            b.setUrl(lista.get(5).getText());     
        }
        tietokanta.muokkaaLukuvinkkia(lukuvinkkiTaulu.get(selattavaVinkki));

        muokkaus = false;
        uusiAlusta();
        alusta.getOutput().setText("Muokkaus valmis!");
    }

    public void lisaaLukuvinkkiValikko() {
        frame.getContentPane().remove(alusta);
        alusta = new Piirtoalusta();
        frame = alusta.lukuvinkinLisays(frame);
        alusta.setGUIforKuuntelija(this);
    }

    public void lisaaLukuvinkki() {
        int vuosi = 0;
        try {
            vuosi = Integer.parseInt(alusta.getVinkinTiedot().get(4).getText());
        } catch (NumberFormatException nfe) {
            System.out.println("VUOSILUKU NOLLA");
        }
        String otsikko = alusta.getVinkinTiedot().get(0).getText();
        String kirjoittaja = alusta.getVinkinTiedot().get(1).getText();
        String isbnUrl = alusta.getVinkinTiedot().get(2).getText();
        String kuvaus = alusta.getVinkinTiedot().get(3).getText();
        String kurssi = alusta.getVinkinTiedot().get(5).getText();
        String tyyppi = alusta.getVinkinTiedot().get(6).getText().toLowerCase();
        if (tyyppi.equals("kirja")) {
            Kirja kirja = new Kirja(otsikko, kirjoittaja, isbnUrl, kuvaus, vuosi, kurssi);
            tietokanta.lisaaKirja(kirja);
            uusiAlusta();
            alusta.getOutput().setText("Lukuvinkki lisätty!");
        } else if (tyyppi.equals("blogi")) {
            System.out.println(alusta.getVinkinTiedot().get(0).getText());
            Blogipostaus postaus = new Blogipostaus(isbnUrl, otsikko, kuvaus, kurssi, kirjoittaja, vuosi);
            tietokanta.lisaaBlogi(postaus);
            uusiAlusta();
            alusta.getOutput().setText("Lukuvinkki lisätty!");
        }
    }

    public JFrame getFrame() {
        return frame;
    }

    public void uusiAlusta() {
        frame.getContentPane().remove(alusta);
        alusta = new Piirtoalusta();
        frame = alusta.initComponents(frame, false, false);
        alusta.setGUIforKuuntelija(this);
        selaus = false;
        muokkaus = false;
    }

    public void avaaLinkki() {
        Blogipostaus blogi = (Blogipostaus) lukuvinkkiTaulu.get(selattavaVinkki);
        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
            try {
                Desktop.getDesktop().browse(new URI(blogi.getUrl()));
            } catch (URISyntaxException ex) {
                Logger.getLogger(GraafinenKayttoliittyma.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                    Logger.getLogger(GraafinenKayttoliittyma.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }


}
