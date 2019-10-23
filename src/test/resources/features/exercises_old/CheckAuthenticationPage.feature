Feature: Check the authentication page

Background: 
  Given I am on the Polteq Web Shop


Scenario Outline: Check users (outline)
  And I log in as "<mailAddress>" with password "<password>"
  Then I see my user name "<userName>" appear on top of the page
  Examples:
    |mailAddress                |password   |userName    |
    |tester@test.com            |1qazxsw2   |tester test |
    |test@guru.com              |asdfghjk   |Test guru   |
    |heavylifter@feelthepain.com|xsw21qaz   |Nope noper  |
    |bdd@cucumber.com           |zaq12wsx   |Cukes Runner|

Scenario Outline: Check email validity
  When I create a new user with this mail address: "<mailAddress>"
  Then the mail address is marked "<expectedValidity>"
  Examples:
    |mailAddress      |expectedValidity |
    |@polteq.com      |invalid          |
    |jenaam@polteq    |invalid          |
    |jenaam@polteq.com|valid            |


