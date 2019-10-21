Feature: Mail address used for registration should be checked for validity
  As a communication manager
  I want all new mail addresses to be validated
  So that


  @external
  Scenario Outline:
    Given I am on the Polteq Web Shop
    When I create a new user with this mail address: "<mailAddress>"
    Then the mail address is marked "<expectedValidity>"

    Examples:
    |mailAddress      |expectedValidity |
    |@polteq.com      |invalid          |
    |jenaam@polteq    |invalid          |
    |jenaam@polteq.com|valid            |