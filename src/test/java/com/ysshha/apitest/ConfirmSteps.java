package com.ysshha.apitest;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ConfirmSteps {

	private static final Logger logger = LogManager.getLogger(ConfirmSteps.class);

	ConfirmCall confirmCall;

    @Before
    public void setUp() throws Throwable {

		confirmCall = new ConfirmCall();
		confirmCall.initCalls("http://localhost:8080");

		logger.trace("StepDefinitions.setUp()");
	}

	@Given("I confirm order {int} with {int}")
	public void I_confirm_Order(int i1, int i2) {

		confirmCall.doConfirm(i1, i2);

		logger.trace("StepDefinitions.I_confirm_Order()");
	}

	@When("The order is confirmed")
	public void The_order_is_confirmed() {

		confirmCall.checkConfirm();

		logger.trace("StepDefinitions.The_order_is_confirmed()");
	}



	@After
    public void tearDown() throws Throwable {
		logger.trace("StepDefinitions.tearDown()");

	}

}

