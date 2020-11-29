Feature: User stuff
	Should be successful


	Scenario: Get Users
		Given I create an user, with name: "ron23", gender: "Male", email: "ron23@rotterdam.io", and status: "Active"
		When I check the response
		Then I see name: "ron23"
