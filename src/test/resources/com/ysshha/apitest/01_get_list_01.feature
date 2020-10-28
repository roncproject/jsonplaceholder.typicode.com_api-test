Feature: Get a List
	Should be successful


	Scenario: Get empty List
		Given I request a List
		When I have a correct response
		Then There are 0 orders


	Scenario: Create an order
		Given I create an Order with amount 1001 card "1" pass "10"
		When The order is Ok


	Scenario: Search an order
		Given I search an Order 1
		When The order is correct


	Scenario: List with 1 order
		Given I request a List
		When I have a correct response
		Then There are 1 orders
		And I see order 1 with card "\"1\"" pass "\"10\"" status "\"CREATED\"" and amount 1001

