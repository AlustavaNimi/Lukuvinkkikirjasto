package main;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class Stepdefs {
    List<String> inputLines;
    
    @Before
    public void setup(){
        inputLines = new ArrayList<>();      
    }
    
    @Given("command Lisaa Otsikolla is selected")
    public void commandLisaaOtsikollaSelected() {
        
    }

    @When("title {string} is entered")
    public void titleIsEntered(String title) {
        
    }
    
    @Then("system will respond with {string}")
    public void systemWillRespondWith(String expectedOutput) {
        
    }

}