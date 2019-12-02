Feature: Reading suggestions can be deleted

    Scenario: added reading suggestions can be deleted
        Given reading suggestion with title "Tirakirja" and type "kirja" is successfully created
        When command "selaa" is selected
        When command "1" is selected
        And Poista is pressed
        Then system will respond with "Lukuvinkki poistettu!"