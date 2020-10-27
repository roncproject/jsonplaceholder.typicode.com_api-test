package com.ysshha.apitest;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.junit.Assert;


public class CreateCall extends AbstractCall {
    
    private static final Logger logger = LogManager.getLogger(CreateCall.class);

    public void doCreate(int amount, String card, String pass) {
        logger.info("CreateCall.doCreate(" + amount + "," + card + "," + pass + ")");

        RequestSpecification request = RestAssured.given();

        request.header("Content-Type", "application/json");

        StringBuilder sb = new StringBuilder();
        sb.append("{\"amount\" : ");
        sb.append(amount);
        sb.append(", \"cardNumber\" : \"");
        sb.append(card);
        sb.append("\" , \"passNumber\" : \"");
        sb.append(pass);
        sb.append("\" }");
        logger.info("[" + sb + "]");

        response = request.body(sb.toString()).post("/order/create");
    }

    public void checkCreate() {
        logger.info("CreateCall.checkCreate()");

        Assert.assertTrue(checkResponseContentType("application/json"));
        Assert.assertTrue(checkResponseStatusCode(200));
        Assert.assertTrue(checkResponseStatusLine("HTTP/1.1 200 "));
        Assert.assertTrue(checkResponseHeadersContain("Connection=keep-alive"));
    }

    public void numOrdersInList(int i) {
        logger.info("CreateCall.ordersInList()");

        String str = response.asString();
        JSONArray array = new JSONArray(str);

        Assert.assertTrue(array.length() == i);
    }

    public void orderInList(int ordId, String cardNum, String passNum,  String ordStat, int amount) {
        logger.info("CreateCall.ordersInList()");

        String str = response.asString();
        //JSONArray array = new JSONArray(str);
        String sub = str.substring(1, str.length() - 1);

        Assert.assertTrue(checkResponseKeyValueExists(sub, "orderId", ordId));
        Assert.assertTrue(checkResponseKeyValueExists(sub, "cardNumber", cardNum));
        Assert.assertTrue(checkResponseKeyValueExists(sub, "passNumber", passNum));
        Assert.assertTrue(checkResponseKeyValueExists(sub, "orderStatus", ordStat));
        Assert.assertTrue(checkResponseKeyValueExists(sub, "amount", amount));
    }



}
