Feature: Check witch currencies have the mineable tag associated with them

  Scenario: Check witch currencies have the mineable tag associated with them
    Given I send request for 10 currencies
    When I check witch currencies have the mineable tag associated with them
    Then I verify that the correct cryptocurrencies have been printed out
