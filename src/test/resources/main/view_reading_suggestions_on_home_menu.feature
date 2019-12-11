Feature: Reading suggestions can be viewed as a list on the home menu

    Scenario: added reading suggestions can be viewed as a list on the home menu
        Given reading suggestion with title "Tirakirja" and type "kirja" is successfully created
        When command "Alkuun" is selected
        Then reading suggestion with title "Tirakirja" is listed
