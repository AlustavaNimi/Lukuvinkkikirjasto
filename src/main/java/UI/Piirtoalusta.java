package UI;

import java.awt.Point;
import javax.swing.*;

public class Piirtoalusta extends JPanel {

    private JTextField input;
    private JTextArea output;
    private String komennot;
    private JButton alkuunNappi;
    private JScrollPane scroll;
    private NappaimistonKuuntelija kuuntelija;

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

    public JFrame lukuvinkinLisays(JFrame frame) {

        JTextField otsikko = new JTextField(20);
        JTextField kuvaus = new JTextField(20);
        JTextField kurssi = new JTextField(20);
        JTextField kirjoittaja = new JTextField(15);
        JTextField vuosiluku = new JTextField(18);
        JTextField tyyppi = new JTextField(20);
        JTextField url = new JTextField(20);

        alkuunNappi = new JButton("Alkuun");
        alkuunNappi.addActionListener(kuuntelija);

        JButton tallenna = new JButton("Tallenna");
        tallenna.addActionListener(kuuntelija);

        alkuunNappi.setLocation(new Point(195, 313));
        this.add(new JLabel("otsikko"));
        this.add(otsikko);
        this.add(new JLabel("kuvaus"));
        this.add(kuvaus);
        this.add(new JLabel("kurssi"));
        this.add(kurssi);
        this.add(new JLabel("kirjoittaja"));
        this.add(kirjoittaja);
        this.add(new JLabel("vuosiluku"));
        this.add(vuosiluku);
        this.add(new JLabel("tyyppi"));
        this.add(tyyppi);
        this.add(new JLabel("url"));
        this.add(url);
        this.add(tallenna);
        this.add(alkuunNappi);

        frame.add(this);
        frame.pack();

        return frame;
    }
}
