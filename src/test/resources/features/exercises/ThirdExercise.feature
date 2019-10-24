Feature: As a user I want to add my first adress

  @exerciseThree
  Scenario: The user adds his first adress to MyAccount
    Given   The user is on the homepage
    When    User clicks sign in button
    And     User fills in email
    And     User fills in password
    And     User click login button
    And     clicks add first address
    And     checks for the new address page
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
    And     checks for the new address save message
    Then    The address is on the address page
    And     delete the address
    And     checks for deleted address message
