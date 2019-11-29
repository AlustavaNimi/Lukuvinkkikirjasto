package UI;

import java.awt.Point;
import java.util.ArrayList;
import javax.swing.*;

public class Piirtoalusta extends JPanel {

    private JTextField input;
    private JTextArea output;
    private String komennot;
    private JButton alkuunNappi;
    private JScrollPane scroll;
    private NappaimistonKuuntelija kuuntelija;
    private ArrayList<JTextField> vinkinTiedot;
    private JButton tallennaNappi;

    public Piirtoalusta() {
        kuuntelija = new NappaimistonKuuntelija(this);
        komennot = "Käytettävissä olevat komennot: "
                + "\nLisaa vinkki"
                + "\nMuokkaa"
                + "\nSelaa"
                + "\nLopeta";
    }

    public JFrame initComponents(JFrame frame) {
        output = new JTextArea(komennot, 20, 20);
        output.setLineWrap(true);
        scroll = new JScrollPane(output);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        input = new JTextField(15);
        output.setEditable(false);
        alkuunNappi = new JButton("Alkuun");
        input.addActionListener(kuuntelija);
        alkuunNappi.addActionListener(kuuntelija);
        this.add(scroll);
        this.add(input);
        this.add(alkuunNappi);
        frame.getContentPane().add(this);
        frame.pack();
        return frame;
    }

    public JTextArea getOutput() {
        return output;
    }

    public JTextField getInput() {
        return input;
    }

    public JPanel getPanel() {
        return this;
    }

    public JScrollPane getScroll() {
        return scroll;
    }

    public JButton getAlkuun() {
        return alkuunNappi;
    }

    public void setGUIforKuuntelija(GraafinenKayttoliittyma liittyma) {
        kuuntelija.setGUI(liittyma);
    }
    
    public JFrame lukuvinkinMuokkaus(JFrame frame, ArrayList<JTextField> lista) {
        return frame;
    }

    public JFrame lukuvinkinLisays(JFrame frame) {
        JTextField otsikko;
        JTextField kirjoittaja;
        JTextField isbn;
        JTextField kuvaus;
        JTextField vuosiluku;
        JTextField kurssi;
        JTextField tyyppi;

        vinkinTiedot = new ArrayList<>();

        otsikko = new JTextField(20);
        vinkinTiedot.add(otsikko);

        kirjoittaja = new JTextField(18);
        vinkinTiedot.add(kirjoittaja);

        isbn = new JTextField(20);
        vinkinTiedot.add(isbn);

        kuvaus = new JTextField(20);
        vinkinTiedot.add(kuvaus);

        vuosiluku = new JTextField(18);
        vinkinTiedot.add(vuosiluku);

        kurssi = new JTextField(20);
        vinkinTiedot.add(kurssi);

        tyyppi = new JTextField(20);
        vinkinTiedot.add(tyyppi);

        alkuunNappi = new JButton("Alkuun");
        alkuunNappi.addActionListener(kuuntelija);

        tallennaNappi = new JButton("Tallenna");
        tallennaNappi.addActionListener(kuuntelija);

        alkuunNappi.setLocation(new Point(195, 313));
        this.add(new JLabel("otsikko"));
        this.add(otsikko);
        this.add(new JLabel("kirjoittaja"));
        this.add(kirjoittaja);
        this.add(new JLabel("isbn/url"));
        this.add(isbn);
        this.add(new JLabel("kuvaus"));
        this.add(kuvaus);
        this.add(new JLabel("vuosiluku"));
        this.add(vuosiluku);
        this.add(new JLabel("kurssi"));
        this.add(kurssi);
        this.add(new JLabel("tyyppi"));
        this.add(tyyppi);

        this.add(tallennaNappi);
        this.add(alkuunNappi);

        frame.add(this);
        frame.pack();

        return frame;
    }

    public JButton getTallennaNappi() {
        return tallennaNappi;
    }

    public ArrayList<JTextField> getVinkinTiedot() {
        return vinkinTiedot;
    }
}
