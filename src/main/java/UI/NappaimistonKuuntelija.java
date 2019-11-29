package UI;

import domain.Blogipostaus;
import domain.Kirja;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NappaimistonKuuntelija implements ActionListener {

    private Piirtoalusta alusta;
    private GraafinenKayttoliittyma GUI;

    public NappaimistonKuuntelija(Piirtoalusta panel) {
        alusta = panel;

    }

    public void setGUI(GraafinenKayttoliittyma liittyma) {
        GUI = liittyma;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == alusta.getInput() && alusta.getInput().getText().toLowerCase().equals("selaa")) {
            GUI.selaa();
            System.out.println(alusta.getAlkuun().getLocation());
        } else if (e.getSource() == alusta.getAlkuun()) {
            GUI.uusiAlusta();  
        } else if (e.getSource() == alusta.getInput() && alusta.getInput().getText().toLowerCase().equals("lisaa vinkki")) {
            alusta.getOutput().setText("");
            alusta.getInput().setText("");
            GUI.lisaaLukuvinkinTiedot();
        } else if (e.getSource() == alusta.getInput() && alusta.getInput().getText().toLowerCase().equals("lisaa blogipostaus")) {
            alusta.getOutput().setText("");
            alusta.getInput().setText("");
            GUI.lisaaBlogi();
        } else if (e.getSource() == alusta.getInput() && alusta.getOutput().getText().equals("Anna kirjalle Otsikko:")) {
//            Kirja kirja = new Kirja(alusta.getInput().getText());
//            tietokanta.lisaaKirja(kirja);
//            alusta.getOutput().setText("Lukuvinkki lisätty!");
//            alusta.getInput().setText("");
        } else if (e.getSource() == alusta.getInput() && alusta.getOutput().getText().equals("Anna blogipostaukselle Otsikko:")) {
//            Blogipostaus blogi = new Blogipostaus(alusta.getInput().getText());
//            tietokanta.lisaaBlogi(blogi);
//            alusta.getOutput().setText("Lukuvinkki lisätty!");
//            alusta.getInput().setText("");
        } else if (e.getSource() == alusta.getInput() && alusta.getInput().getText().toLowerCase().equals("lopeta")) {
            GUI.getFrame().dispose();
        }
    }

}
