package com.ysshha.apitest;

import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;


public class PostSteps {

	private static final Logger logger = LogManager.getLogger(PostSteps.class);

	Post	post;

    @Before
    public void setUp() throws Throwable {

		post = new Post();

		logger.trace("setUp()");
	}

	@When("I list all posts")
	public void i_list_all_posts() {

		post.list();

	 	logger.trace("i_list_all_posts()");
	}


	@When("I list post with id: {int}")
	public void i_list_post_with_id_int(int i) {

		post.list(i);

		logger.trace("i_list_post_with_id_int()");
	}

	@When("I list post with userId: {int}")
	public void i_list_post_with_userid_int(int i) {

		post.listUserId(i);

		logger.trace("i_list_post_with_id_int()");
	}



	@Then("post is not empty")
	public void result_is_not_empty() {

		Assert.assertFalse(post.getResponse().equals("{}"));

		logger.trace("result_is_not_empty()");
	}

	@Then("I get post with id: {int}")
	public void i_get_post_with_id_int(int i) {

    	int id = post.getId(i);

		Assert.assertTrue(id == i);

		logger.trace("i_get_post_with_id_int() i = [" + i + "] id [" + id + "]" );
	}


	@Then("I get no post")
	public void i_get_no_post() {

		Assert.assertTrue(post.getResponse().equals("{}"));

		logger.trace("i_get_no_post()");
	}
//
//	@Then("Username: {string} gets no result")
//	public void username_string_gets_no_result(String s) {
//
//		Assert.assertTrue(post.getId(s).equals(""));
//
//		logger.trace("username_string_gets_no_result()");
//	}
//
//	@Then("Username: {string} gets result: {string}")
//	public void username_string_gets_result_string(String s1, String s2) {
//
//		Assert.assertTrue(post.getId(s1).equals(s2));
//
//		logger.trace("username_string_gets_result_string()");
//	}
//
//
//////	@Then("I get no response")
//////	public void i_get_no_response() {
//////
//////    	String s = us.getResponse();
//////
//////		logger.trace("i_get_no_response() ==> [" + s + "]");
//////
//////		Assert.assertTrue(s.equals(""));
//////
//////		logger.trace("i_get_no_response()");
////	}
//
//
//
//	@When("I list user with username: {string}")
//	public void i_list_user_with_username_string(String s) {
//
//		post.list(s);
//
//		logger.trace("i_list_user_with_username_string()");
//	}
//
//

}

