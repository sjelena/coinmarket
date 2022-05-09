Feature: Retrieve the Erherium technical documentation and confirm some values

  Scenario: Retrieve the Erherium technical documentation and confirm some values
    Given I send request and I got JSON result
    When Confirm that the following logo URL is present
    And Confirm that the technical_doc URI is present
    And Confirm that the symbol of the currency is ETH
    Then Confirm that the date added is 2015-08-07T00:00:00.000Z
    And Confirm that the platform is null
    And Confirm that the currency has the mineable tag