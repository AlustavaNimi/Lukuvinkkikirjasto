Feature: Reading suggestions can be filtered by search terms

    Scenario: search function lists all reading suggestions containing the search term 
        Given reading suggestion with title "Tirakirja" and type "kirja" is successfully created
        When command "Hae hakusanalla" is selected
        And search term "Tira" is entered
        And command "selaa" is selected
        Then reading suggestion with title "Tirakirja" is listed

    Scenario: search function doesn't list reading suggestions that don't contain the search term 
        Given reading suggestion with title "Tirakirja" and type "kirja" is successfully created
        When command "Hae hakusanalla" is selected
        And search term "Ohtu" is entered
        And command "selaa" is selected
        Then reading suggestion with title "Tirakirja" is not listed
