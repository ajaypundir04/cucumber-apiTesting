Feature: Steps scenarios


  Scenario: Login scenario test for Gmail

    Given navigate to Gmail page
    When user logged in using username as “userA” and password as “password”
    Then home page should be displayed