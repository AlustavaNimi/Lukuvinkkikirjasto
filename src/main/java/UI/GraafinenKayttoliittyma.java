package UI;

import database.Tietokanta;
import domain.Blogipostaus;
import domain.Kirja;
import domain.Lukuvinkki;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
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

    public GraafinenKayttoliittyma(Tietokanta lukuvinkit) {
        this.tietokanta = lukuvinkit;
        frame = new JFrame("Lukuvinkit");
    }

    public GraafinenKayttoliittyma() {

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
        frame = alusta.initComponents(frame);
        alusta.setGUIforKuuntelija(this);

    }

    @Override
    public void selaa() {
        int i = 1;
        
        String lukuvinkit = "";
        for (Lukuvinkki lukuvinkki : tietokanta.haeLukuvinkit()) {
            String numerointi = String.valueOf(i);
            lukuvinkit += numerointi + " " + lukuvinkki.lyhytTulostus() + "\n\n";
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
        System.out.println("ei vielä toiminnassa");
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
        frame = alusta.initComponents(frame);
        alusta.setGUIforKuuntelija(this);
    }

}
