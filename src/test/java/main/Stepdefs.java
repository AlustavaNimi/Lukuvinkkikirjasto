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
        try {
            int i = Integer.parseInt(command);
            gui.tulostaYksittainenLukuvinkki(i);
        } catch (Exception e) {

        }
    }

    @Then("reading suggestion with title {string} is listed")
    public void readingSuggestionWithTitleIsListed(String title) {
        alusta = gui.getAlusta();
        assertTrue(alusta.getOutput().getText().contains(title));
    }

    @Then("system will respond with {string}")
    public void systemWillRespondWith(String output) {
        alusta = gui.getAlusta();
        assertEquals(alusta.getOutput().getText(), output);
    }

    /*@Given("command {string} is selected")
    public void commandIsSelected(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }*/
    @When("title {string} is entered")
    public void titleIsEntered(String string) {
        init();

    }

    @When("type {string} is entered")
    public void typeIsEntered(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @When("author {string} is entered")
    public void authorIsEntered(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @When("isbn {string} is entered")
    public void isbnIsEntered(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @When("description {string} is entered")
    public void descriptionIsEntered(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @When("publication date {string} is entered")
    public void publicationDateIsEntered(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @When("course {string} is entered")
    public void courseIsEntered(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

}
