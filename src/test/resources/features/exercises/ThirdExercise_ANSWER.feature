Feature: As a user I want to add my first address

  @exerciseFour
  Scenario: The user adds his first address to MyAccount
    Given   The user is on the homepage
    When    The user logs into his MyAccount
    And     The user submits his first address
    Then    The new address should be shown on the address page
