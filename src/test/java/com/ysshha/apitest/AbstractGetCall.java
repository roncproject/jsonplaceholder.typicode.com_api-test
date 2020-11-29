package com.ysshha.apitest;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.junit.Assert;


public abstract class AbstractGetCall extends AbstractCall {

    private static final Logger logger = LogManager.getLogger(AbstractGetCall.class);

    public void getCall(String s) {

        RequestSpecification request = RestAssured.given();
        response = request.get(s);

        logger.trace("getCall(" + s + ") = [" + response.asString() + "]");

    }

    public void checkGetCall() {
        
        //Assert.assertTrue(checkResponseContentType("application/json"));
        Assert.assertTrue(checkResponseContentType("application/json; charset=utf-8"));

        Assert.assertTrue(checkResponseStatusCode(200));
        //Assert.assertTrue(checkResponseStatusLine("HTTP/1.1 200 "));
        Assert.assertTrue(checkResponseStatusLine("HTTP/1.1 200 OK"));

        Assert.assertTrue(checkResponseHeadersContain("Connection=keep-alive"));

        logger.trace("checkGetCall()");
    }

    // public void numFramesInGetCall(int i) {

    //     String str = response.asString();
    //     String s = getResponseKeyValue(str, "data");

    //     JSONArray array = new JSONArray(s);
    //     int len = array.length();

    //     logger.trace("numFramesInGetCall(" + i + ") = [" + s + "] length: [" + len + "]");

    // }


    public void minFramesInGetCall(int i) {

        String s = getResponseKeyValue("data");
        JSONArray array = new JSONArray(s);
        int len = array.length();

        Assert.assertTrue(len >= i);

        logger.trace("minFramesInGetCall(" + i + ") = [" + "] length: [" + len + "]");
    }


    public void orderInList(int ordId, String cardNum, String passNum,  String ordStat, int amount) {
        logger.trace("orderInList()");

        String str = response.asString();
        String sub = str.substring(1, str.length() - 1);

        Assert.assertTrue(checkResponseKeyValueExists(sub, "orderId", ordId));
        Assert.assertTrue(checkResponseKeyValueExists(sub, "cardNumber", cardNum));
        Assert.assertTrue(checkResponseKeyValueExists(sub, "passNumber", passNum));
        Assert.assertTrue(checkResponseKeyValueExists(sub, "orderStatus", ordStat));
        Assert.assertTrue(checkResponseKeyValueExists(sub, "amount", amount));
    }

}
