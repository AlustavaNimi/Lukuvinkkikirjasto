package UI;

import database.Tietokanta;
import domain.Blogipostaus;
import domain.Kirja;
import domain.Lukuvinkki;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class GraafinenKayttoliittyma extends JPanel implements Kayttoliittyma, ActionListener {

    private Tietokanta tietokanta;
    private JFrame alusta;
    private int screenW;
    private int screenH;
    private JTextField input;
    private JTextArea output;
    private String komennot;
    private JButton restart;

    public GraafinenKayttoliittyma(Tietokanta lukuvinkit) {
        this.tietokanta = lukuvinkit;
        komennot = "Käytettävissä olevat komennot: "
                + "\nLisaa kirja"
                + "\nLisaa blogi"
                + "\nSelaa"
                + "\nLopeta";
    }

    @Override
    public void run() {
        screenW = Toolkit.getDefaultToolkit().getScreenSize().width;
        screenH = Toolkit.getDefaultToolkit().getScreenSize().height;
        alusta = new JFrame("Lukuvinkit");
        alusta.setPreferredSize(new Dimension(300, 400));
        alusta.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        alusta.setLocation(screenW / 2, screenH / 2);
        initComponents(alusta.getContentPane());

        alusta.pack();
        alusta.setVisible(true);
    }

    @Override
    public void selaa() {
        String lukuvinkit = "";
        for (Lukuvinkki lukuvinkki : tietokanta.haeLukuvinkit()) {
            lukuvinkit += lukuvinkki + "\n\n";
        }
        output.setText(lukuvinkit);
        input.setText("");

    }

    @Override
    public void lisaaKirja() {
        output.setText("Anna kirjalle Otsikko:");
    }
    
    @Override
    public void lisaaBlogi() {
        output.setText("Anna blogille Otsikko:");
    }

    private void initComponents(Container contentPane) {
        JPanel panel = new JPanel();
        output = new JTextArea(komennot, 20, 20);
        output.setLineWrap(true);
        JScrollPane scroll = new JScrollPane(output);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        input = new JTextField(15);
        input.addActionListener(this);
        output.setEditable(false);
        restart = new JButton("Alkuun");
        restart.addActionListener(this);
        panel.add(scroll);
        panel.add(input);
        panel.add(restart);
        contentPane.add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == input && input.getText().toLowerCase().equals("selaa")) {
            selaa();
        } else if (e.getSource() == restart) {
            output.setText(komennot);
            input.setText("");
        } else if (e.getSource() == input && input.getText().toLowerCase().equals("lisaa kirja")) {
            output.setText("");
            input.setText("");
            lisaaKirja();
        } else if (e.getSource() == input && input.getText().toLowerCase().equals("lisaa blogi")) {
            output.setText("");
            input.setText("");
            lisaaBlogi();
        } else if (e.getSource() == input && output.getText().equals("Anna kirjalle Otsikko:")) {
            Kirja kirja = new Kirja(input.getText());
            tietokanta.lisaaKirja(kirja);
            output.setText("Lukuvinkki lisätty!");
            input.setText("");
        } 
        else if (e.getSource() == input && output.getText().equals("Anna blogille Otsikko:")) {
            Blogipostaus blogi = new Blogipostaus(input.getText());
            tietokanta.lisaaBlogi(blogi);
            output.setText("Lukuvinkki lisätty!");
            input.setText("");
        } else if (e.getSource() == input && input.getText().toLowerCase().equals("lopeta")) {
            alusta.dispose();
            System.exit(0);
        }
    }

}
