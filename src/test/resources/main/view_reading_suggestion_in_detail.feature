Feature: Reading suggestion can be opened and viewed in more detail

    Scenario: created reading suggestion can be opened and viewed in more detail
        Given reading suggestion with title title "Consistency models", author "Nicola Apicella" and url "https://dev.to/napicellatwit/consistency-models-52l" and type "blogi" is successfully created
        When search term "Consistency models" is entered
        And command "selaa" is selected
        And command "1" is selected
        Then title "Consistency models", author "Nicola Apicella", url "https://dev.to/napicellatwit/consistency-models-52l" and type "Blogipostaus" are displayed

