Feature: Blogpost URL can be opened from within the app

    Scenario: blogpost URL can be opened from within the app
        Given reading suggestion with title title "Consistency models", author "Nicola Apicella" and url "https://dev.to/napicellatwit/consistency-models-52l" and type "blogi" is successfully created
        When command "selaa" is selected
        And command "1" is selected
        And command Avaa blogi is pressed
        Then URL "https://dev.to/napicellatwit/consistency-models-52l" will be opened in default browser
