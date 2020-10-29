package com.ysshha.apitest;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.junit.Assert;


public class ConfirmCall extends AbstractCall {
    
    private static final Logger logger = LogManager.getLogger(ConfirmCall.class);

    public void doConfirm(int id, int code) {

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");

        StringBuilder sb = new StringBuilder();
        sb.append("{\"accessCode\" : ");
        sb.append(code);
        sb.append(", \"orderId\" : \"");
        sb.append(id);
        sb.append("\" }");
        String body_string = sb.toString();

        response = request.body(body_string).post("/order/confirm");

        logger.trace("CreateCall.doCreate(" + code + "," + id + ") [" + body_string + "]");
    }

    public void checkConfirm() {

        Assert.assertTrue(checkResponseContentType("application/json"));
        Assert.assertTrue(checkResponseStatusCode(200));
        Assert.assertTrue(checkResponseStatusLine("HTTP/1.1 200 "));
        Assert.assertTrue(checkResponseHeadersContain("Connection=keep-alive"));

        logger.trace("ConfirmCall.checkConfirm()");
    }





}
