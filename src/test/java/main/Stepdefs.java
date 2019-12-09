package main;

import IO.IOStub;
import UI.GraafinenKayttoliittyma;
import UI.NappaimistonKuuntelija;
import UI.Piirtoalusta;
import UI.TekstiKayttoliittyma;
import database.FakeTietokanta;
import database.Tietokanta;
import domain.Lukuvinkki;
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
    public void setup(){
        tietokanta = new FakeTietokanta();
        alusta = new Piirtoalusta();
        tietokanta = new FakeTietokanta();
        kuuntelija = new NappaimistonKuuntelija(alusta);
        gui = new GraafinenKayttoliittyma(tietokanta);
        gui.run();
        frame = gui.getFrame();
        alusta.setGUIforKuuntelija(gui);
        init();
    }
    
    @Given("reading suggestion with title {string} and type {string} is successfully created")
    public void readingSuggestionWithTitleAndTypeIsSuccessfullyCreated(String title, String type) {
        tietokanta.lisaaKirja(new Lukuvinkki(title));
    }
    
    private void init() {
        alusta.initComponents(frame, true, true);
    }
    
    private void performAction(Object o, String cmd) {
        init();
        ActionEvent tapahtuma = new ActionEvent(o, 0, cmd);
        kuuntelija.actionPerformed(tapahtuma);
    }
    
    @When("Poista is pressed")
    public void poistaIsPressed() {
        performAction(alusta.getPoistaNappi(), alusta.getPoistaNappi().getActionCommand());
    }

    @When("Muokkaa is pressed")
    public void muokkaaIsPressed() {
        performAction(alusta.getMuokkausNappi(), alusta.getMuokkausNappi().getActionCommand());
    }

    @When("command {string} is selected")
    public void commandIsSelected(String command) {
        // Write code here that turns the phrase above into concrete actions
        alusta.getInput().setText(command);
        performAction(alusta.getInput().getText(), alusta.getInput().getText());
    }

    @Then("reading suggestion with title {string} is listed")
    public void readingSuggestionWithTitleIsListed(String title) {
        // Write code here that turns the phrase above into concrete actions
        ArrayList<String> otsikot = new ArrayList<>();
        for (Lukuvinkki v : tietokanta.haeLukuvinkit()) {
            otsikot.add(v.getOtsikko());
        }
        assertTrue(otsikot.contains(title));
    }

    @Then("system will respond with {string}")
    public void systemWillRespondWith(String output) {
        // Write code here that turns the phrase above into concrete actions
        init();
        assertEquals(alusta.getOutput().getText(), output);
    }

    /*@Given("command {string} is selected")
    public void commandIsSelected(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }*/

    @When("title {string} is entered")
    public void titleIsEntered(String string) {
        // Write code here that turns the phrase above into concrete actions
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
