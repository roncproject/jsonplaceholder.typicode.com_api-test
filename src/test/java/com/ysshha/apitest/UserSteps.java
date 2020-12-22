package com.ysshha.apitest;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;


public class UserSteps {

	private static final Logger logger = LogManager.getLogger(UserSteps.class);

	User	us;

    @Before
    public void setUp() throws Throwable {

		us = new User();

		logger.trace("setUp()");
	}

	@When("I list all users")
	public void i_list_all_users() {

		us.list();

	 	logger.trace("i_list_all_users()");
	}


	@When("I list user with id: {int}")
	public void i_list_user_with_id_int(int i) {

		us.list(i);

		logger.trace("i_list_user_with_id_int()");
	}

	@Then("result is not empty")
	public void result_is_not_empty() {

		Assert.assertFalse(us.getResponse().equals("{}"));

		logger.trace("result_is_not_empty()");
	}

	@Then("I get user with id: {int}")
	public void i_get_user_with_id_int(int i) {

    	int id = us.getId(i);

		Assert.assertTrue(id == i);

		logger.trace("i_get_user_with_id_int() i = [" + i + "] id [" + id + "]" );
	}


	@Then("I get no user")
	public void i_get_no_user() {

		Assert.assertTrue(us.getResponse().equals("{}"));

		logger.trace("i_get_no_user()");
	}

	@Then("Username: {string} gets no result")
	public void username_string_gets_no_result(String s) {

		Assert.assertTrue(us.getId(s).equals(""));

		logger.trace("username_string_gets_no_result()");
	}

	@Then("Username: {string} gets result: {string}")
	public void username_string_gets_result_string(String s1, String s2) {

		Assert.assertTrue(us.getId(s1).equals(s2));

		logger.trace("username_string_gets_result_string()");
	}


////	@Then("I get no response")
////	public void i_get_no_response() {
////
////    	String s = us.getResponse();
////
////		logger.trace("i_get_no_response() ==> [" + s + "]");
////
////		Assert.assertTrue(s.equals(""));
////
////		logger.trace("i_get_no_response()");
//	}



	@When("I list user with username: {string}")
	public void i_list_user_with_username_string(String s) {

		us.list(s);

		logger.trace("i_list_user_with_username_string()");
	}



}

