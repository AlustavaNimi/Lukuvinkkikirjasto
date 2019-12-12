package main;

import UI.GraafinenKayttoliittyma;
import UI.NappaimistonKuuntelija;
import UI.Piirtoalusta;
import database.FakeTietokanta;
import database.LukuvinkkiDao;
import database.Tietokanta;
import domain.Blogipostaus;
import domain.Kirja;
import domain.Lukuvinkki;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import java.awt.Event;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import static org.junit.Assert.*;

public class Stepdefs {

    GraafinenKayttoliittyma gui;
    Piirtoalusta alusta;
    NappaimistonKuuntelija kuuntelija;
    Tietokanta tietokanta;
    JFrame frame;

    @Before
    public void setup() {
        tietokanta = new FakeTietokanta();
        alusta = new Piirtoalusta();
        tietokanta = new LukuvinkkiDao("jdbc:sqlite:test.db");
        kuuntelija = new NappaimistonKuuntelija(alusta);
        gui = new GraafinenKayttoliittyma(tietokanta);
        gui.run();
        frame = gui.getFrame();
        init();
        alusta.setGUIforKuuntelija(gui);
    }

    @After
    public void dispose() {
        frame.dispose();
    }

    @Given("reading suggestion with title {string} and type {string} is successfully created")
    public void readingSuggestionWithTitleAndTypeIsSuccessfullyCreated(String title, String type) {
       if (type.equals("kirja")) {
           Kirja kirja = new Kirja(title, "", "", "", 10, "");
           tietokanta.lisaaKirja(kirja);
       } else if (type.equals("blogi")) {
           Blogipostaus p = new Blogipostaus("", title, "", "", "", 10);
           tietokanta.lisaaBlogi(p);
       }
    }

    private void init() {
        frame = alusta.initComponents(frame, false, false);
        kuuntelija = alusta.getKuuntelija();
        alusta.setGUIforKuuntelija(gui);
    }

    private void performAction(Object o, String cmd) {
        kuuntelija = alusta.getKuuntelija();
        ActionEvent tapahtuma = new ActionEvent(o, 1, cmd);
        kuuntelija.actionPerformed(tapahtuma);
    }

    @When("Poista is pressed")
    public void poistaIsPressed() {
        alusta = gui.getAlusta();
        performAction(alusta.getPoistaNappi(), alusta.getPoistaNappi().getActionCommand());
    }

    @When("Muokkaa is pressed")
    public void muokkaaIsPressed() {
        alusta = gui.getAlusta();
        performAction(alusta.getMuokkausNappi(), alusta.getMuokkausNappi().getActionCommand());
    }

    @When("Tallenna is pressed")
    public void tallennaIsPressed() {
        alusta = gui.getAlusta();
        performAction(alusta.getTallennaNappi(), alusta.getTallennaNappi().getActionCommand());
    }

    @When("command {string} is selected")
    public void commandIsSelected(String command) {
        if (command.equals("selaa")) {
            performAction(alusta.getSelaaNappi(), alusta.getSelaaNappi().getActionCommand());
        }
        if (command.equals("Lisää")) {
            performAction(alusta.getLisaaNappi(), alusta.getLisaaNappi().getActionCommand());
        }
        if (command.equals("Alkuun")) {
            performAction(alusta.getAlkuun(), alusta.getAlkuun().getActionCommand());
        }
        if (command.equals("tallenna")) {
            performAction(alusta.getTallennaNappi(), alusta.getTallennaNappi().getActionCommand());
        }
        try {
            int i = Integer.parseInt(command);
            gui.tulostaYksittainenLukuvinkki(i);
        } catch (Exception e) {

        }
    }
    
    public boolean isSuggestionListed(String title) {
        alusta = gui.getAlusta();
        return alusta.getOutput().getText().contains(title);
    }

    @Then("reading suggestion with title {string} is listed")
    public void readingSuggestionWithTitleIsListed(String title) {
        assertTrue(isSuggestionListed(title));
    }
    
    @Then("reading suggestion with title {string} is not listed")
    public void readingSuggestionWithTitleIsNotListed(String title) {
        assertFalse(isSuggestionListed(title));
    }


    @Then("system will respond with {string}")
    public void systemWillRespondWith(String output) {
        alusta = gui.getAlusta();
        assertEquals(alusta.getOutput().getText(), output);
    }

    @When("title {string} is entered")
    public void titleIsEntered(String title) {
        alusta = gui.getAlusta();
        alusta.getVinkinTiedot().get(0).setText(title);
    }

    @When("type {string} is entered")
    public void typeIsEntered(String type) {
        alusta = gui.getAlusta();
        alusta.getVinkinTiedot().get(6).setText(type);
    }

    @When("author {string} is entered")
    public void authorIsEntered(String author) {
        alusta = gui.getAlusta();
        alusta.getVinkinTiedot().get(1).setText(author);
    }

    @When("isbn {string} is entered")
    public void isbnIsEntered(String isbn) {
        alusta = gui.getAlusta();
        alusta.getVinkinTiedot().get(2).setText(isbn);
    }

    @When("description {string} is entered")
    public void descriptionIsEntered(String description) {
        alusta = gui.getAlusta();
        alusta.getVinkinTiedot().get(3).setText(description);
    }

    @When("publication date {string} is entered")
    public void publicationDateIsEntered(String date) {
        alusta = gui.getAlusta();
        alusta.getVinkinTiedot().get(4).setText(date);
    }

    @When("course {string} is entered")
    public void courseIsEntered(String course) {
        alusta = gui.getAlusta();
        alusta.getVinkinTiedot().get(5).setText(course);
    }
    
    @When("{string} is selected as filter criterion")
    public void isSelectedAsFilterCriterion(String criterion) {
        alusta = gui.getAlusta();
        if (criterion.equals("kirja")) {
            alusta.getBlogiCheckBox().setSelected(false);
            alusta.getKirjaCheckBox().setSelected(true);
        } else {
            alusta.getBlogiCheckBox().setSelected(true);
            alusta.getKirjaCheckBox().setSelected(false);
        }
    }
    
    @Given("reading suggestion with title title {string}, author {string} and url {string} and type {string} is successfully created")
    public void readingSuggestionWithTitleTitleAuthorAndUrlAndTypeIsSuccessfullyCreated(String title, String author, String url, String type) {
        tietokanta.lisaaBlogi(new Blogipostaus(url, title, "", "", author, 0));
    }
    
    @When("title {string}, author {string} and url {string} are entered")
    public void titleAuthorAndUrlAreEntered(String title, String author, String url) {
        // Write code here that turns the phrase above into concrete actions
        tietokanta.lisaaBlogi(new Blogipostaus(url, title, "", "", author, 0));
    }
    
    @When("title {string}, author {string} and url {string} and type {string} are entered")
    public void titleAuthorAndUrlAndTypeAreEntered(String title, String author, String url, String type) {
        alusta = gui.getAlusta();
        alusta.getVinkinTiedot().get(0).setText(title);
        alusta.getVinkinTiedot().get(1).setText(author);
        alusta.getVinkinTiedot().get(2).setText(url);
        alusta.getVinkinTiedot().get(4).setText("1");
        alusta.getVinkinTiedot().get(6).setText(type);
        performAction(alusta.getTallennaNappi(), alusta.getTallennaNappi().getActionCommand());
    }


}
