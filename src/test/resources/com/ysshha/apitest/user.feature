Feature: User actions
	Test

	Scenario: List all users
		When I list all users
		Then result is not empty

	Scenario: List a valid user id
		When I list user with id: 1
		Then result is not empty
		Then I get user with id: 1

	Scenario: List an invalid user id
		When I list user with id: 10000000
		Then I get no user

	Scenario: List a valid username
		When I list user with username: "Delphine"
		Then result is not empty
		Then Username: "Delphine" gets result: "9"

	Scenario: List an invalid username
		When I list user with username: "Delphine2"
		Then Username: "Delphine2" gets no result