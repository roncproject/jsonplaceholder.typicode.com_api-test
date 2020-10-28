package com.ysshha.apitest;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class StepDefinitions {

	private static final Logger logger = LogManager.getLogger(StepDefinitions.class);

	ListCall listCall;
	CreateCall createCall;
	IdCall idCall;

    @Before
    public void setUp() throws Throwable {

		listCall = new ListCall();
		listCall.initCalls("http://localhost:8080");
		createCall = new CreateCall();
		createCall.initCalls("http://localhost:8080");
		idCall = new IdCall();
		idCall.initCalls("http://localhost:8080");

		logger.trace("StepDefinitions.setUp()");
	}
	
	@Given("I request a List")
	public void I_request_a_List() {

		listCall.getList();

		logger.trace("StepDefinitions.I_request_a_List()");
	}

	@When("I have a correct response")
	public void I_have_a_correct_response() {

		listCall.checkList();

		logger.trace("StepDefinitions.I_have_a_correct_response()");
    }


	@Then("There are {int} orders")
	public void There_are_int_orders(int i) {

		listCall.numOrdersInList(i);

		logger.trace("StepDefinitions.There_are_int_orders()");
	}


	@And("I see order {int} with card {string} pass {string} status {string} and amount {int}")
	public void There_are_int_orders(int i1, String s1, String s2, String s3, int i2) {

		listCall.orderInList(i1, s1, s2, s3, i2);

		logger.trace("StepDefinitions.There_are_int_orders()");
	}


	@Given("I create an Order with amount {int} card {string} pass {string}")
	public void I_create_an_Order_with(int i, String s1, String s2) {

		createCall.doCreate(i, s1, s2);

		logger.trace("StepDefinitions.I_create_an_Order_with()");
	}



	@When("The order is Ok")
	public void The_order_is_Ok() {

		createCall.checkCreate();

		logger.trace("StepDefinitions.The_order_is_Ok()");
	}


	@Given("I search an Order {int}")
	public void I_search_an_Order(int i) {

		idCall.getId(i);

		logger.trace("StepDefinitions.I_search_an_Order(" + i + ")");
	}

	@When("The order is correct")
	public void The_order_is_Correct() {

		createCall.checkCreate();

		logger.trace("StepDefinitions.The_order_is_Correct()");
	}


	@After
    public void tearDown() throws Throwable {
		logger.trace("StepDefinitions.tearDown()");
		
	}

}

