Feature: A new book suggestion can be created

    Scenario: creation is successful with valid title
        Given command lisaa otsikolla is selected
        When title "Clean Code: A Handbook of Agile Software Craftsmanship" is entered
        Then system will respond with "Uusi lukuvinkki lisätty"