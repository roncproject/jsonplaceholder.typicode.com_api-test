Feature: Post actions
	Test

	Scenario: List all posts
		When I list all posts
		Then post is not empty

	Scenario: List a valid post id
		When I list post with id: 1
		Then post is not empty
		Then I get post with id: 1

	Scenario: List an invalid post id
		When I list post with id: 10000000

	Scenario: List a valid post userId
		When I list post with userId: 9

