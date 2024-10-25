Feature: User Login

  @Test
  Scenario Outline: Successful login with valid credentials
    Given the user is on the homepage
    When the user navigates to the login page
    And the user provides valid email "<email>" and password "<password>"
    And the user submits the login form
    #Then the user should be redirected to the homepage

  Examples:
    | email                        | password    |
    | monikamonika1379@gmail.com    | Monika@123  |
