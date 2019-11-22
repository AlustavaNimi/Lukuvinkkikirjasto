Feature: A new book suggestion can be created

    Scenario: creation is successful with valid title
        Given command Lisaa Otsikolla is selected
        When title "Clean Code: A Handbook of Agile Software Craftsmanship"
        Then system will respond with "Uusi lukuvinkki lisätty"