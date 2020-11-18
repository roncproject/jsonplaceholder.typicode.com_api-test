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

	UsersGetCall	users;

    @Before
    public void setUp() throws Throwable {

		logger.trace("setUp()");
	}


	@After
    public void tearDown() throws Throwable {
		logger.trace("tearDown()");

	}

}

