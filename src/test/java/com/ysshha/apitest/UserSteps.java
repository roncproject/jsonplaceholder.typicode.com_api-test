package com.ysshha.apitest;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class UserSteps {

	private static final Logger logger = LogManager.getLogger(UserSteps.class);

	UsersGetCall	us;
	UsersGetCall	usersCall;

    @Before
    public void setUp() throws Throwable {

		usersCall = new UsersGetCall();
		usersCall.initCalls("https://gorest.co.in");

		logger.trace("setUp()");
	}

	@Given("I GET Users")
	public void i_get_users() {

		usersCall.getUsers();

	 	logger.trace("i_get_users()");
	}
	
	@When ("I check GET CALL")
	public void i_check_get_call() {

		usersCall.checkGetCall();

		logger.trace("i_check_get_call()");
	}

	@Then ("I see GET CALL is not empty")
	public void i_see_get_call_is_not_empty() {

		usersCall.minFramesInGetCall(0);

		logger.trace("i_check_get_call()");
	}


	@After
    public void tearDown() throws Throwable {
		logger.trace("tearDown()");

	}

}

