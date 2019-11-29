Feature: A new book suggestion can be created

    Scenario: creation is successful with valid title
        Given command lisaa vinkki is selected
        When title "Clean Code: A Handbook of Agile Software Craftsmanship" is entered
        Then system will respond with "Uusi lukuvinkki lisätty"

    Scenario: creation is successful with valid title, author, isbn, description, publication date, course and url
        Given command lisaa vinkki is selected
        When title "Tirakirja", author "Antti Laaksonen", isbn "-", description "jee tira", publication date "2019", course "Tietorakenteet ja algoritmit" and url "https://www.cs.helsinki.fi/u/ahslaaks/tirakirja/" are entered
        Then system will respond with "Uusi lukuvinkki lisätty"
    
    Scenario: creation fails with invalid publication date
        Given command lisaa vinkki is selected
        When  title "Tirakirja" and publication date "today" is entered
        Then  system will respond with "Vuosiluvun on oltava luku"

    Scenario: creation fails without valid title
        Given command lisaa vinkki is selected
        When  title "" is entered
        Then  system will respond with "Lukuvinkille on annettava otsikko"