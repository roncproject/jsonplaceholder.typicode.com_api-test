package com.ysshha.apitest;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.junit.Assert;


public class UsersPostCall extends AbstractPostCall {

    private static final Logger logger = LogManager.getLogger(UsersPostCall.class);


    public void postCreateUser(String data) {

        // postCall("/public-api/users", 
        //     "{\"name\":\"Ron Test\", \"gender\":\"Male\", \"email\":\"ron@test.com\", \"status\":\"Active\"}", 
        //         "06481b3eff1980648f05b255c01c1c4dcc77b424b5488f3478fef358bc8d8af2");       

        postCall("/public-api/users", 
            data, 
            "06481b3eff1980648f05b255c01c1c4dcc77b424b5488f3478fef358bc8d8af2");       

        logger.trace("postCreateUser()");
    }


    public void checkPostCall() {
        
        //Assert.assertTrue(checkResponseContentType("application/json"));
        Assert.assertTrue(checkResponseContentType("application/json; charset=utf-8"));

        Assert.assertTrue(checkResponseStatusCode(200));
        //Assert.assertTrue(checkResponseStatusLine("HTTP/1.1 200 "));
        Assert.assertTrue(checkResponseStatusLine("HTTP/1.1 200 OK"));

        Assert.assertTrue(checkResponseHeadersContain("Connection=keep-alive"));


        logger.trace("checkPostCall()");
    }


    // public void getUsers(int user) {

    //     String s = "/public-api/users/" + user;

    //     getCall(s);       

    //     logger.trace("getUsers()");
    // }

    public void checkName(String name) {

        logger.trace("checkName("  + name + ")");
        
        //keyValueInPostCall("\"name\"", name);
        keyValueInDataPostCall("name", name);

        
    }     


}



