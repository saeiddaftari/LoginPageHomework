
Feature: Confirm subscription

  @tag2
  Scenario Outline: Confirming subscription
   Given I open a temporary mail web page in <browser>
    When I get the email address
    And I enter the email address in the input field
    And I press absenden button of newsletter form
    Then I receive an email asking to confirm my email address
    When I open the mail
    Then there is a link to finish registration 
    When I click Jetzt Anmeldung abschliessen button
		Then I am redirected to page of confirming subscription
    Examples: 
      | browser	|
      | chrome	|
      | firefox	|
      |	edge	|