Feature: Reading suggestions can be filtered by type

    Scenario: all books are listed when "kirja" is selected as filter criterion
        Given reading suggestion with title "Tirakirja" and type "kirja" is successfully created
        When "kirja" is selected as filter criterion
        And command "selaa" is selected
        Then reading suggestion with title "Tirakirja" is listed

    Scenario: no blogposts are listed when "kirja" is selected as filter criterion
        Given reading suggestion with title title "Consistency models", author "Nicola Apicella" and url "https://dev.to/napicellatwit/consistency-models-52l" and type "blogi" is successfully created
        When "kirja" is selected as filter criterion
        And command "selaa" is selected
        Then reading suggestion with title "Consistency models" is not listed

    Scenario: all blogposts are listed when "blogi" is selected as filter criterion
        Given reading suggestion with title title "Consistency models", author "Nicola Apicella" and url "https://dev.to/napicellatwit/consistency-models-52l" and type "blogi" is successfully created
        When "blogi" is selected as filter criterion
        And command "selaa" is selected
        Then reading suggestion with title "Consistency models" is listed

    Scenario: no books are listed when "blogi" is selected as filter criterion
        Given reading suggestion with title "Tirakirja" and type "kirja" is successfully created
        When "blogi" is selected as filter criterion
        And command "selaa" is selected
        Then reading suggestion with title "Tirakirja" is not listed