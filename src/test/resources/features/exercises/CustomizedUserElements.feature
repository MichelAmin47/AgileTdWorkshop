Feature: Users should see customized page elements
    As user of the webshop
    I would like to see customized page elements
    So that I feel that I'm in my custom shopping experience

@smoke @fast
Scenario:
    Given I am on the Polteq Web Shop
    When I log in
    Then I see my user name appear on top of the page

Scenario:
    Given I am on the Polteq Web Shop
    When I log in as "tester@test.com" with password "1qazxsw2"
    Then I see my user name "tester test" appear on top of the page

Scenario:
    Given I am on the Polteq Web Shop logged in as "tester@test.com" with password "1qazxsw2"
    Then I see my user name "tester test" appear on top of the page
