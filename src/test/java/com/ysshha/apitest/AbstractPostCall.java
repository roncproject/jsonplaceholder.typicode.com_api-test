package com.ysshha.apitest;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.junit.Assert;


public abstract class AbstractPostCall extends AbstractCall {

    private static final Logger logger = LogManager.getLogger(AbstractPostCall.class);

    public void postCall(String path, String data, String code) {

        RequestSpecification request = RestAssured.given();
        

        request.header("Authorization", "Bearer " + code)
        .header("Content-Type", "application/json");


        //request.header("Content-Type", "application/json");

        StringBuilder sb = new StringBuilder();
        sb.append("{\"Authorization: Bearer \" : ");
        sb.append(code);
        sb.append(",");
        sb.append(data);
        sb.append("}");
        String body_string = sb.toString();

        //response = request.body(body_string).post("path");
        response = request.body(data).post(path);
        
        // RequestSpecification request = RestAssured.given();
        // response = request.get(s);

        //logger.trace("postCall(" + path + "," + data + "," + code + ") = [" + response.asString() + "]");
        logger.trace("postCall(" + body_string + ") = [" + response.asString() + "]");
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


    // public void minFramesInGetCall(int i) {

    //     String s = getResponseKeyValue("data");
    //     JSONArray array = new JSONArray(s);
    //     int len = array.length();

    //     Assert.assertTrue(len >= i);

    //     logger.trace("minFramesInGetCall(" + i + ") = [" + "] length: [" + len + "]");
    // }


    public void keyValueInPostCall(String key, String value) {

        String val = getResponseKeyValue(key);
        //JSONArray array = new JSONArray(s);
        //int len = array.length();

        Assert.assertTrue(val.equals(value));

        logger.trace("keyValueInPostCall(" + key + "," + value + ") = [" + val + "]");
    }


    public void keyValueInDataPostCall(String key, String value) {


        String val = getDataKeyValue(key);

        logger.trace("keyValueInDataPostCall(" + key + "," + value + ") [" + val + "]");

        //JSONArray array = new JSONArray(s);
        //int len = array.length();

        Assert.assertTrue(val.equals(value));

        //logger.trace("keyValueInDataPostCall(" + key + "," + value + ") = [" + val + "]");
    }


    // public void orderInList(int ordId, String cardNum, String passNum,  String ordStat, int amount) {
    //     logger.trace("orderInList()");

    //     String str = response.asString();
    //     String sub = str.substring(1, str.length() - 1);

    //     Assert.assertTrue(checkResponseKeyValueExists(sub, "orderId", ordId));
    //     Assert.assertTrue(checkResponseKeyValueExists(sub, "cardNumber", cardNum));
    //     Assert.assertTrue(checkResponseKeyValueExists(sub, "passNumber", passNum));
    //     Assert.assertTrue(checkResponseKeyValueExists(sub, "orderStatus", ordStat));
    //     Assert.assertTrue(checkResponseKeyValueExists(sub, "amount", amount));
    // }

    // public void idInResponse(String id) {


    // } 


}
