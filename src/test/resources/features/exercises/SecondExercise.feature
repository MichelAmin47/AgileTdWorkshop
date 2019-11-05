Feature: As a user I want to login to MyAccount

  @exerciseTwo
  Scenario: The user logs into his MyAccount
    Given   The user is on the homepage
    When    The user logs into his MyAccount
    Then    The user should be taken to his Account page

  @exerciseTwo
  Scenario: The user logs into his MyAccount with credentials
    Given   The user is on the homepage
    When    The user logs into his MyAccount with "testerino@tester.com" and "1qazxsw2" as credentials
    Then    The user should be taken to his Account page