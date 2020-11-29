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
	UsersPostCall	usersPost;

    @Before
    public void setUp() throws Throwable {

		usersCall = new UsersGetCall();
		usersCall.initCalls("https://gorest.co.in");

		usersPost = new UsersPostCall();
		usersPost.initCalls("https://gorest.co.in");

		logger.trace("setUp()");
	}

	@Given("I GET Users")
	public void i_get_users() {

		usersCall.getUsers();

	 	logger.trace("i_get_users()");
	}
	

	@Given("I GET User {int}")
	public void i_get_users(int i) {

		usersCall.getUsers(i);

		logger.trace("i_get_users(" + i + ")");
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
  

	@Given ("I create an user, with name: {string}, gender: {string}, email: {string}, and status: {string}")
	public void i_create_an_user_with(String name, String gender, String email, String status) {

		StringBuilder sb = new StringBuilder();
        sb.append("{\"name\":\"");
        sb.append(name);
        sb.append("\", \"gender\":\"");
        sb.append(gender);
        sb.append("\", \"email\":\"");
		sb.append(email);
        sb.append("\", \"status\":\"");
		sb.append(status);
        sb.append("\"}");
		String data = sb.toString();
		
		usersPost.postCreateUser(data);

		logger.trace("i_create_an_user_with(" + name + ")");
	}

	@When ("I check the response")
	public void i_check_the_post_call() {

		//usersCall.minFramesInGetCall(0);
		usersPost.checkGetCall();

		logger.trace("i_check_the_post_call()");
	}

	@Then ("I see name: {string}")
	public void i_see_name(String name) {

		logger.trace("i_see_name(" + name + ")");
		
		usersPost.checkName(name);

		
	}

	@After
    public void tearDown() throws Throwable {

		logger.trace("tearDown()");

	}

}

