
Feature: Subscription



  Scenario Outline: duplicate email
  Given I open a temporary mail in <browser>
    When I get the mail address
    And I enter that email address in the input field
    And I press absenden button under email textbox
    Then I receive an email asking to confirm
    When I open that mail 
    When I click Jetzt Anmeldung abschliessen
		Then I am redirected to hoffner.de
  	When I enter the same email address in the email field
  	And Again press the absenden
  	Then I receive error note
 Examples: 
      | browser	|
      | chrome	|
      | firefox	|
      |	edge	|