Feature: A new book suggestion can be created

    Scenario: creation is successful with valid title and type
        Given command "lisaa vinkki" is selected
        When title "Clean Code: A Handbook of Agile Software Craftsmanship" is entered
        And type "kirja" is entered
        Then system will respond with "Lukuvinkki lisätty!"

    Scenario: creation is successful with valid title, author, isbn, description, publication date, course and type
        Given command "lisaa vinkki" is selected
        When title "Tirakirja" is entered
        And author "Antti Laaksonen" is entered
        And isbn "-" is entered
        And description "jee tira" is entered
        And publication date "2019" is entered
        And course "Tietorakenteet ja algoritmit" is entered
        And type "kirja" is entered
        Then system will respond with "Lukuvinkki lisätty!"
    
    Scenario: creation fails with invalid publication date
        Given command "lisaa vinkki" is selected
        When title "Tirakirja" is entered
        And publication date "today" is entered
        Then system will respond with "Lukuvinkki lisätty!"
