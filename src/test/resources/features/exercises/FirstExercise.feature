Feature: Login

  @exerciseOne
  Scenario: User log in
    Given   User is on the homepage
    When    User clicks login button
    And     User fills in email
    And     User fills in password
    And     User click login button
    Then    MyAccount elements visible
