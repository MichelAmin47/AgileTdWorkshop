Feature: The product tags should be visible on the homepage

  @ui
  Scenario: The expected product tags are visible on the homepage
    Given   I am on the Polteq Web Shop
    Then the product tags are visible
    |ipod|apple|nano|


  Scenario: The expected product tags are visible on the homepage with headers
    Given   I am on the Polteq Web Shop
    Then the product tags are visible header example
      |Tags   |
      |nano   |
      |ipod   |
      |bitcoin|

