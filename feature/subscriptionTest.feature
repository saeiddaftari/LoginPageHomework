	Feature: Subscription
	  Scenario: Subscription Test
    Given a Hoffner login page
    When I enter my email in the input field
    And I press Absenden button 
    Then I can see a confirmation message that my subscription is in progress