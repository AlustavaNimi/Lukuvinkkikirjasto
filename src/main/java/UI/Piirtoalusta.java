package UI;

import domain.Blogipostaus;
import domain.Kirja;
import domain.Lukuvinkki;
import java.awt.FlowLayout;
import java.awt.Point;
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
        vinkinTiedot = new ArrayList<>();
        JTextField isbn = new JTextField();
        JTextField tyyppi = new JTextField();
        JTextField otsikko = new JTextField(vinkki.getOtsikko(), 20);
        JTextField kirjoittaja = new JTextField(vinkki.getKirjoittaja(), 18);
        JTextField kuvaus = new JTextField(vinkki.getKuvaus(), 20);
        String vuosi = String.valueOf(vinkki.getJulkaisuVuosi());
        JTextField vuosiluku = new JTextField(vuosi, 18);
        JTextField kurssi = new JTextField(vinkki.getKurssi(), 20);
        if (vinkki instanceof Kirja) {
            Kirja kirja = (Kirja) vinkki;
            isbn = new JTextField(kirja.getISBN(), 20);
            tyyppi = new JTextField("kirja", 20);
        } else if (vinkki instanceof Blogipostaus) {
            Blogipostaus postaus = (Blogipostaus) vinkki;
            isbn = new JTextField(postaus.getUrl(), 20);
            tyyppi = new JTextField("blogi", 20);
        }
        vinkinTiedot.add(otsikko);
        vinkinTiedot.add(kirjoittaja);
        vinkinTiedot.add(kuvaus);
        vinkinTiedot.add(vuosiluku);
        vinkinTiedot.add(kurssi);
        vinkinTiedot.add(isbn);
        vinkinTiedot.add(tyyppi);

        alkuunNappi = new JButton("Alkuun");
        alkuunNappi.addActionListener(kuuntelija);

        tallennaNappi = new JButton("Tallenna");
        tallennaNappi.addActionListener(kuuntelija);

        alkuunNappi.setLocation(new Point(195, 313));
        JPanel p1 = new JPanel(new FlowLayout());
        p1.add(new JLabel("Otsikko"));
        p1.add(otsikko);
        JPanel p2 = new JPanel(new FlowLayout());
        p2.add(new JLabel("Kirjoittaja"));
        p2.add(kirjoittaja);
        JPanel p3 = new JPanel(new FlowLayout());
        p3.add(new JLabel("ISBN/URL"));
        p3.add(isbn);
        JPanel p4 = new JPanel(new FlowLayout());
        p4.add(new JLabel("Kuvaus"));
        p4.add(kuvaus);
        JPanel p5 = new JPanel(new FlowLayout());
        p5.add(new JLabel("Vuosiluku"));
        p5.add(vuosiluku);
        JPanel p6 = new JPanel(new FlowLayout());
        p6.add(new JLabel("Kurssi"));
        p6.add(kurssi);
        JPanel p7 = new JPanel(new FlowLayout());
        p7.add(new JLabel("Tyyppi"));
        p7.add(tyyppi);
        this.add(p1);
        this.add(p2);
        this.add(p3);
        this.add(p4);
        this.add(p5);
        this.add(p6);
        this.add(p7);

        this.add(tallennaNappi);
        this.add(alkuunNappi);

        frame.add(this);
        frame.pack();

        return frame;
    }

    public JFrame lukuvinkinLisays(JFrame frame) {
        vinkinTiedot = new ArrayList<>();

        JTextField otsikko = new JTextField(20);
        vinkinTiedot.add(otsikko);

        JTextField kirjoittaja = new JTextField(18);
        vinkinTiedot.add(kirjoittaja);

        JTextField isbn = new JTextField(20);
        vinkinTiedot.add(isbn);

        JTextField kuvaus = new JTextField(20);
        vinkinTiedot.add(kuvaus);

        JTextField vuosiluku = new JTextField(18);
        vinkinTiedot.add(vuosiluku);

        JTextField kurssi = new JTextField(20);
        vinkinTiedot.add(kurssi);

        JTextField tyyppi = new JTextField(20);
        vinkinTiedot.add(tyyppi);

        alkuunNappi = new JButton("Alkuun");
        alkuunNappi.addActionListener(kuuntelija);

        tallennaNappi = new JButton("Tallenna");
        tallennaNappi.addActionListener(kuuntelija);

        alkuunNappi.setLocation(new Point(195, 313));

        JPanel p1 = new JPanel(new FlowLayout());
        p1.add(new JLabel("Otsikko"));
        p1.add(otsikko);
        JPanel p2 = new JPanel(new FlowLayout());
        p2.add(new JLabel("Kirjoittaja"));
        p2.add(kirjoittaja);
        JPanel p3 = new JPanel(new FlowLayout());
        p3.add(new JLabel("ISBN/URL"));
        p3.add(isbn);
        JPanel p4 = new JPanel(new FlowLayout());
        p4.add(new JLabel("Kuvaus"));
        p4.add(kuvaus);
        JPanel p5 = new JPanel(new FlowLayout());
        p5.add(new JLabel("Vuosiluku"));
        p5.add(vuosiluku);
        JPanel p6 = new JPanel(new FlowLayout());
        p6.add(new JLabel("Kurssi"));
        p6.add(kurssi);
        JPanel p7 = new JPanel(new FlowLayout());
        p7.add(new JLabel("Tyyppi"));
        p7.add(tyyppi);
        this.add(p1);
        this.add(p2);
        this.add(p3);
        this.add(p4);
        this.add(p5);
        this.add(p6);
        this.add(p7);

        this.add(tallennaNappi);
        this.add(alkuunNappi);

        frame.add(this);
        frame.pack();

        return frame;
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
