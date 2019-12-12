package UI;

import domain.Blogipostaus;
import domain.Kirja;
import domain.Lukuvinkki;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.*;

public class Piirtoalusta extends JPanel {

    private JTextField input;
    private JTextField hakuKentta;
    private JTextArea output;
    private JButton alkuunNappi;
    private JScrollPane scroll;
    private JCheckBox kirjaCheckBox;
    private JCheckBox blogiCheckBox;
    private NappaimistonKuuntelija kuuntelija;
    private ArrayList<JTextField> vinkinTiedot;
    private JButton tallennaNappi;
    private JButton muokkausNappi;
    private JButton poistaNappi;
    private JButton lisaaNappi;
    private JButton selaaNappi;
    private JButton lopetaNappi;
    private JButton linkkiNappi;
    private String vinkkiTyyppi;

    public Piirtoalusta() {
        kuuntelija = new NappaimistonKuuntelija(this);
    }
    
    public NappaimistonKuuntelija getKuuntelija() {
        return kuuntelija;
    }

    public JFrame initComponents(JFrame frame, boolean muokkaus, boolean onBlogi) {
        output = new JTextArea(20, 20);
        output.setLineWrap(true);
        scroll = new JScrollPane(output);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        input = new JTextField(15);
        hakuKentta = new JTextField(15);
        output.setEditable(false);
        alkuunNappi = new JButton("Alkuun");
        hakuKentta.addActionListener(kuuntelija);
        input.addActionListener(kuuntelija);
        alkuunNappi.addActionListener(kuuntelija);
        lisaaNappi = new JButton("Lisää");
        selaaNappi = new JButton("Selaa");
        lopetaNappi = new JButton("Lopeta");
        linkkiNappi = new JButton("Avaa blogi");
        lisaaNappi.addActionListener(kuuntelija);
        selaaNappi.addActionListener(kuuntelija);
        lopetaNappi.addActionListener(kuuntelija);
        linkkiNappi.addActionListener(kuuntelija);
        kirjaCheckBox = new JCheckBox("Kirjat");
        blogiCheckBox = new JCheckBox("Blogit");
        kirjaCheckBox.setSelected(true);
        blogiCheckBox.setSelected(true);
        this.add(scroll);
        if (muokkaus) {
            poistaNappi = new JButton("Poista");
            muokkausNappi = new JButton("Muokkaa");
            poistaNappi.addActionListener(kuuntelija);
            muokkausNappi.addActionListener(kuuntelija);
            this.add(poistaNappi);
            this.add(muokkausNappi);
            if (onBlogi) {
                this.add(linkkiNappi);
            }
        } else {
            JPanel p1 = new JPanel(new FlowLayout());
            p1.add(new JLabel("Valitse numerolla"));
            p1.add(input);
            JPanel p2 = new JPanel(new FlowLayout());
            p2.add(kirjaCheckBox);
            p2.add(blogiCheckBox);
            JPanel p3 = new JPanel(new FlowLayout());
            p3.add(new JLabel("Hae hakusanalla"));
            p3.add(hakuKentta);
            JPanel p4 = new JPanel(new FlowLayout());
            p4.add(lisaaNappi);
            p4.add(selaaNappi);
            p4.add(lopetaNappi);
            this.add(p1);
            this.add(p2);
            this.add(p3);
            this.add(p4);
        }
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

    public JFrame lukuvinkinMuokkaus(JFrame frame, Lukuvinkki vinkki) {
        String isbn = "";
        if (vinkki instanceof Kirja) {
            Kirja kirja = (Kirja) vinkki;
            isbn = kirja.getISBN();
        } else if (vinkki instanceof Blogipostaus) {
            isbn = ((Blogipostaus) vinkki).getUrl();
        }
        rakennaMuokkausNakyma(vinkki.getOtsikko(), vinkki.getKirjoittaja(), vinkki.getKuvaus(),
                String.valueOf(vinkki.getJulkaisuVuosi()), vinkki.getKurssi(), vinkki.getTyyppi(), isbn);

        frame.add(this);
        frame.pack();

        return frame;
    }

    public JFrame lukuvinkinLisays(JFrame frame) {
        rakennaMuokkausNakyma("", "", "", "", "", "", "");
        frame.add(this);
        frame.pack();
        return frame;
    }

    private void rakennaMuokkausNakyma(String otsikko, String kirjoittaja, String kuvaus, String vuosi, String kurssi, String tyyppi, String isbn) {
        vinkinTiedot = new ArrayList<>();

        JTextField otsikkoF = new JTextField(otsikko, 20);
        vinkinTiedot.add(otsikkoF);

        JTextField kirjoittajaF = new JTextField(kirjoittaja, 18);
        vinkinTiedot.add(kirjoittajaF);

        JTextField isbnF = new JTextField(isbn, 20);
        vinkinTiedot.add(isbnF);

        JTextField kuvausF = new JTextField(kuvaus, 20);
        vinkinTiedot.add(kuvausF);

        JTextField vuosilukuF = new JTextField(vuosi, 18);
        vinkinTiedot.add(vuosilukuF);

        JTextField kurssiF = new JTextField(kurssi, 20);
        vinkinTiedot.add(kurssiF);

        JTextField tyyppiF = new JTextField(tyyppi, 20);
        vinkinTiedot.add(tyyppiF);

        alkuunNappi = new JButton("Alkuun");
        alkuunNappi.addActionListener(kuuntelija);

        tallennaNappi = new JButton("Tallenna");
        tallennaNappi.addActionListener(kuuntelija);

        JPanel p1 = new JPanel(new FlowLayout());
        p1.add(new JLabel("Otsikko"));
        p1.add(otsikkoF);
        JPanel p2 = new JPanel(new FlowLayout());
        p2.add(new JLabel("Kirjoittaja"));
        p2.add(kirjoittajaF);
        JPanel p3 = new JPanel(new FlowLayout());
        p3.add(new JLabel("ISBN/URL"));
        p3.add(isbnF);
        JPanel p4 = new JPanel(new FlowLayout());
        p4.add(new JLabel("Kuvaus"));
        p4.add(kuvausF);
        JPanel p5 = new JPanel(new FlowLayout());
        p5.add(new JLabel("Vuosiluku"));
        p5.add(vuosilukuF);
        JPanel p6 = new JPanel(new FlowLayout());
        p6.add(new JLabel("Kurssi"));
        p6.add(kurssiF);
        JPanel p7 = new JPanel(new FlowLayout());
        p7.add(new JLabel("Tyyppi"));
        p7.add(tyyppiF);
        this.add(p1);
        this.add(p2);
        this.add(p3);
        this.add(p4);
        this.add(p5);
        this.add(p6);
        this.add(p7);

        this.add(tallennaNappi);
        this.add(alkuunNappi);
    }

    public JButton getTallennaNappi() {
        return tallennaNappi;
    }

    public JButton getPoistaNappi() {
        return poistaNappi;
    }

    public JButton getMuokkausNappi() {
        return muokkausNappi;
    }

    public JButton getSelaaNappi() {
        return this.selaaNappi;
    }

    public JButton getLisaaNappi() {
        return this.lisaaNappi;
    }

    public JButton getLopetaNappi() {
        return this.lopetaNappi;
    }

    public ArrayList<JTextField> getVinkinTiedot() {
        return vinkinTiedot;
    }

    public JButton getLinkkiNappi() {
        return this.linkkiNappi;
    }

    public JTextField getHakuKentta() {
        return this.hakuKentta;
    }

    public JCheckBox getKirjaCheckBox() {
        return this.kirjaCheckBox;
    }

    public JCheckBox getBlogiCheckBox() {
        return this.blogiCheckBox;
    }
}
