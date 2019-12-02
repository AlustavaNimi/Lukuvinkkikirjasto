package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


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
        } else if (e.getSource() == alusta.getAlkuun()) {
            GUI.uusiAlusta();
        } else if (e.getSource() == alusta.getInput() && GUI.getSelaus()) {
            int i = Integer.parseInt(alusta.getInput().getText());
            GUI.tulostaYksittainenLukuvinkki(i);
            alusta.getOutput().setText("");
        } else if (e.getSource() == alusta.getInput() && alusta.getInput().getText().toLowerCase().equals("lisaa vinkki")) {
            alusta.getOutput().setText("");
            alusta.getInput().setText("");
            GUI.lisaaLukuvinkkiValikko();
        } else if (e.getSource() == alusta.getMuokkausNappi()) {
            alusta.getOutput().setText("");
            alusta.getInput().setText("");
            GUI.muokkaaVinkkia();
        } else if (e.getSource() == alusta.getSelaaNappi()) {
            GUI.selaa();
        } else if (e.getSource() == alusta.getLisaaNappi()) {
            alusta.getOutput().setText("");
            alusta.getInput().setText("");
            GUI.lisaaLukuvinkkiValikko();
        } else if (e.getSource() == alusta.getLopetaNappi()) {
            GUI.getFrame().dispose();
        } else if (e.getSource() == alusta.getInput() && alusta.getInput().getText().toLowerCase().equals("lopeta")) {
            GUI.getFrame().dispose();
        } else if (e.getSource() == alusta.getTallennaNappi()) {
            if (!GUI.getMuokkaus()) {
                GUI.lisaaLukuvinkki();
            }   else {
                GUI.tallennaMuokkaus();
            }
        } else if (e.getSource() == alusta.getPoistaNappi()) {
            GUI.poistaLukuvinkki();
        }
    }

}
