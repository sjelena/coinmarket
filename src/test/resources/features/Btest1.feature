Feature: Retrieve the ID of Bitcoin (BTC), Namecoin (NMC) and Ethereum (ETH). Than convert them to Bolivian Boliviano

  Scenario Outline: Convert cryptocurrency to Boliviano
    Given I send request and I got JSON result
    When I need id of "<cryptocurrency>"
    Then I will convert "<cryptocurrency>" price to BOLI
    Examples:
      | cryptocurrency |
      |  BTC  |
      |  NMC  |
      |  ETH  |