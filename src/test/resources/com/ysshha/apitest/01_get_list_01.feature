Feature: User stuff
	Should be successful


	Scenario: Get Users
		Given I GET Users
		When I check GET CALL
		Then I see GET CALL is not empty

