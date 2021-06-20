

Feature: verify the mail
  


  Scenario Outline: verify the wrong email address
    Given I open a Hoffner login page
    When I enter a <email> in the input field
    And I press the absenden button
    Then I can see the suitalble message

    Examples: 
      | email	|
      | info@gmail	|
      | info@gmail.com	|
			| usernamegmail.com	|
			| info	|