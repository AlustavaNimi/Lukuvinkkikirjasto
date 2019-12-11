Feature: Reading suggestions can be marked as read

    Scenario: added reading suggestions can be marked as read
        Given reading suggestion with title "Tirakirja" and type "kirja" is successfully created
        When command "selaa" is selected
        And command "1" is selected
        And Merkitse luetuksi is pressed
        Then system will respond with "Lukuvinkki merkitty luetuksi!"
