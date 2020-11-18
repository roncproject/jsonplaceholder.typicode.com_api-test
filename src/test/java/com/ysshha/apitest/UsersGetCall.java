package com.ysshha.apitest;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.junit.Assert;


public class UsersGetCall extends AbstractGetCall {

    private static final Logger logger = LogManager.getLogger(UsersGetCall.class);

    public void getUsers() {

        getCall("/public-api/users");       

        logger.trace("getUsers()");
    }

}



