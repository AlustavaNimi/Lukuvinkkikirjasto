package UI;

import domain.Blogipostaus;
import domain.Kirja;
import domain.Lukuvinkki;
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
    private JButton muokkausNappi;
    private JButton poistaNappi;
    private JButton lisaaNappi;
    private JButton selaaNappi;
    private JButton lopetaNappi;

    public Piirtoalusta() {
        kuuntelija = new NappaimistonKuuntelija(this);
        komennot = "Käytettävissä olevat komennot: "
                + "\nLisaa vinkki"
                + "\nSelaa"
                + "\nLopeta";
    }

    public JFrame initComponents(JFrame frame, boolean muokkaus) {
        output = new JTextArea(komennot, 20, 20);
        output.setLineWrap(true);
        scroll = new JScrollPane(output);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        input = new JTextField(15);
        output.setEditable(false);
        alkuunNappi = new JButton("Alkuun");
        input.addActionListener(kuuntelija);
        alkuunNappi.addActionListener(kuuntelija);
        lisaaNappi = new JButton("Lisää");
        selaaNappi = new JButton("Selaa");
        lopetaNappi = new JButton("Lopeta");
        lisaaNappi.addActionListener(kuuntelija);
        selaaNappi.addActionListener(kuuntelija);
        lopetaNappi.addActionListener(kuuntelija);
        this.add(scroll);       
        if (muokkaus) {
            poistaNappi = new JButton("Poista");
            muokkausNappi = new JButton("Muokkaa");
            poistaNappi.addActionListener(kuuntelija);
            muokkausNappi.addActionListener(kuuntelija);
            this.add(poistaNappi);
            this.add(muokkausNappi);
        } else {
            this.add(input);
            this.add(lisaaNappi);
            this.add(selaaNappi);
            this.add(lopetaNappi);
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
            isbn = new JTextField(kirja.getISBN(),20);
            tyyppi = new JTextField("kirja", 20);
        }   else if (vinkki instanceof Blogipostaus) {
            Blogipostaus postaus = (Blogipostaus) vinkki;
            isbn = new JTextField(postaus.getUrl(),20);
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
}
