Feature: Reading suggestions can be viewed as a list

    Scenario: added reading suggestions can be viewed as a list
        Given reading suggestion with title "Tirakirja" and type "kirja" is successfully created
        When command "selaa" is selected
        Then reading suggestion with title "Tirakirja" is listed