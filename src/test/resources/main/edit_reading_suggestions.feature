Feature: Reading suggestions can be edited

    Scenario: added reading suggestions can be edited
        Given reading suggestion with title "Tirakirja" and type "kirja" is successfully created
        When command "selaa" is selected
        And command "1" is selected
        And Muokkaa is pressed
        And Tallenna is pressed
        Then system will respond with "Muokkaus valmis!"