Feature: Verify the login functionality of the facebook

  Scenario: Varify the login by giving invalid user name and valid password
    Given user have to launch the browser and enter the url
    When user enters the invalid username and valid password
    Then user clicks on the login button
    But user not display the homepage of the application
