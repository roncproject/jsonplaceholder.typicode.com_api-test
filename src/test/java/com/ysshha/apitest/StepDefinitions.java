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
		logger.info("StepDefinitions.setUp()");

			listCall = new ListCall();
			listCall.initCalls("http://localhost:8080");
			createCall = new CreateCall();
			createCall.initCalls("http://localhost:8080");
			idCall = new IdCall();
			idCall.initCalls("http://localhost:8080");

	}
	
	@Given("I request a List")
	public void I_request_a_List() {
		logger.info("StepDefinitions.I_request_a_List()");

		listCall.getList();
	}

	@When("I have a correct response")
	public void I_have_a_correct_response() {
		logger.info("StepDefinitions.I_have_a_correct_response()");

		listCall.checkList();
    }


	@Then("There are {int} orders")
	public void There_are_int_orders(int i) {
		logger.info("StepDefinitions.There_are_int_orders()");

		listCall.numOrdersInList(i);

	}

	@And("I see order {int} with card {string} pass {string} status {string} and amount {int}")
	public void There_are_int_orders(int i1, String s1, String s2, String s3, int i2) {
    	logger.info("StepDefinitions.There_are_int_orders()");

		listCall.orderInList(i1, s1, s2, s3, i2);
	}

//	@When("I create an Order")
//	public void I_create_an_Order() {
//		logger.info("StepDefinitions.I_create_an_Order()");
//
//    	createCall.doCreate(1000, "202", "303");
//	}

	@Given("I create an Order with amount {int} card {string} pass {string}")
	public void I_create_an_Order_with(int i, String s1, String s2) {
		logger.info("StepDefinitions.I_create_an_Order_with()");

		createCall.doCreate(i, s1, s2);
	}



	@When("The order is Ok")
	public void The_order_is_Ok() {
		logger.info("StepDefinitions.The_order_is_Ok()");

		createCall.checkCreate();
	}


	@Given("I search an Order {int}")
	public void I_search_an_Order(int i) {
		logger.info("StepDefinitions.I_search_an_Order(" + i + ")");

		idCall.getId(i);
	}

	@When("The order is correct")
	public void The_order_is_Correct() {
		logger.info("StepDefinitions.The_order_is_Correct()");

		createCall.checkCreate();
	}


	@After
    public void tearDown() throws Throwable {
		logger.info("StepDefinitions.tearDown()");

		//orderPage.closePage();
	}

}

