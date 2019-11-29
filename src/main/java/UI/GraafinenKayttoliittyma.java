package UI;

import database.Tietokanta;
import domain.Lukuvinkki;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
        String lukuvinkit = "";
        for (Lukuvinkki lukuvinkki : tietokanta.haeLukuvinkit()) {
            lukuvinkit += lukuvinkki + "\n\n";
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

    public void lisaaLukuvinkinTiedot() {
        frame.getContentPane().remove(alusta);
        alusta = new Piirtoalusta();
        frame = alusta.lukuvinkinLisays(frame);
        alusta.setGUIforKuuntelija(this);
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
