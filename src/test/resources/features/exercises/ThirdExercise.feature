Feature: As a user I want to add my first adress

  Scenario: The user adds his first adress to MyAccount
    Given   The user is on the homepage
    When    The user logs into his MyAccount with "test@tester.com" and "1qazxsw2" as credentials
    And     clicks add first address
    And     fills in Alias "retseT"
    And     fills in First Name "Mister"
    And     fills in Last Name "Test"
    And     fills in Company "Tester.io"
    And     fills in VAT "4321"
    And     fills in Address "Testlane 23"
    And     fills in Address Complement "3A"
    And     fills in Postal Code "1111 AA"
    And     fills in City "Testdam"
    And     fills in Country ""
    And     fills in Phone "0031123456"
    And     clicks SAVE
    Then    The address is on the address page
    And     delete the address