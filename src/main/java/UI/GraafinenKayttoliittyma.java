package UI;

import database.Tietokanta;
import domain.Blogipostaus;
import domain.Kirja;
import domain.Lukuvinkki;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.HashMap;
import javax.swing.JFrame;
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
        frame = new JFrame();
        alusta = new Piirtoalusta();
        frame.setPreferredSize(new Dimension(300, 400));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocation(screenW / 2, screenH / 2);
        frame.setVisible(true);
        frame = alusta.initComponents(frame, false);
        alusta.setGUIforKuuntelija(this);

    }
    
    public void poistaLukuvinkki() {
        tietokanta.poistaKirja(lukuvinkkiTaulu.get(selattavaVinkki));
        uusiAlusta();
        alusta.getOutput().setText("Vinkki poistettu!");
    }

    public void tulostaYksittainenLukuvinkki(int numero) {
        frame.getContentPane().remove(alusta);
        alusta = new Piirtoalusta();
        frame = alusta.initComponents(frame, true);
        alusta.setGUIforKuuntelija(this);
        Lukuvinkki vinkki = lukuvinkkiTaulu.get(numero);
        alusta.getOutput().setText(vinkki.toString());
        selattavaVinkki = numero;
        selaus = false;
    }

    @Override
    public void selaa() {
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
        tietokanta.muokkaaKirjaa(lukuvinkkiTaulu.get(selattavaVinkki));
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
        if (alusta.getVinkinTiedot().get(6).getText().equals("kirja")) {
            Kirja kirja = new Kirja(alusta.getVinkinTiedot().get(0).getText(),
                    alusta.getVinkinTiedot().get(1).getText(),
                    alusta.getVinkinTiedot().get(2).getText(),
                    alusta.getVinkinTiedot().get(3).getText(),
                    vuosi,
                    alusta.getVinkinTiedot().get(5).getText());
            tietokanta.lisaaKirja(kirja);
            uusiAlusta();
            alusta.getOutput().setText("Lukuvinkki lisätty!");
        } else if (alusta.getVinkinTiedot().get(6).getText().equals("blogi")) {
            Blogipostaus postaus = new Blogipostaus(alusta.getVinkinTiedot().get(0).getText(),
                    alusta.getVinkinTiedot().get(2).getText(),
                    alusta.getVinkinTiedot().get(3).getText(),
                    alusta.getVinkinTiedot().get(5).getText(),
                    alusta.getVinkinTiedot().get(1).getText(),
                    vuosi);
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
        frame = alusta.initComponents(frame, false);
        alusta.setGUIforKuuntelija(this);
        selaus = false;
    }

}
