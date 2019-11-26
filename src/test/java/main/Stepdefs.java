package main;

import IO.IOStub;
import UI.TekstiKayttoliittyma;
import database.FakeTietokanta;
import database.Tietokanta;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class Stepdefs {
    ArrayList<String> inputLines;
    IOStub io;
    Tietokanta tietokanta;
    TekstiKayttoliittyma tekstiKayttoliittyma;

    @Before
    public void setup(){
        tietokanta = new FakeTietokanta();
        inputLines = new ArrayList<>();
    }

    @Given("command lisaa otsikolla is selected")
    public void commandLisaaOtsikollaSelected() {
        inputLines.add("lisaa otsikolla");
    }

    @When("title {string} is entered")
    public void titleIsEntered(String title) {
        inputLines.add(title);
        inputLines.add("lopeta");
        
        io = new IOStub();
        io.setInputs(inputLines);
        tekstiKayttoliittyma = new TekstiKayttoliittyma(io, tietokanta);
        tekstiKayttoliittyma.run();
    }

    @Then("system will respond with {string}")
    public void systemWillRespondWith(String expectedOutput) {
        assertTrue(io.getOutputs().contains(expectedOutput));
    }

}
