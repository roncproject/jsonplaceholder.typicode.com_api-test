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
        String body_string = sb.toString();

        response = request.body(body_string).post("/order/create");

        logger.trace("CreateCall.doCreate(" + amount + "," + card + "," + pass + ") [" + body_string + "]");
    }

    public void checkCreate() {

        Assert.assertTrue(checkResponseContentType("application/json"));
        Assert.assertTrue(checkResponseStatusCode(200));
        Assert.assertTrue(checkResponseStatusLine("HTTP/1.1 200 "));
        Assert.assertTrue(checkResponseHeadersContain("Connection=keep-alive"));

        logger.trace("CreateCall.checkCreate()");
    }

    public void numOrdersInList(int num) {

        String str = response.asString();
        JSONArray array = new JSONArray(str);

        Assert.assertTrue(array.length() == num);

        logger.trace("CreateCall.numOrdersInList(" + num + ")");
    }

    public void orderInList(int ordId, String cardNum, String passNum,  String ordStat, int amount) {

        String str = response.asString();
        String sub = str.substring(1, str.length() - 1);

        Assert.assertTrue(checkResponseKeyValueExists(sub, "orderId", ordId));
        Assert.assertTrue(checkResponseKeyValueExists(sub, "cardNumber", cardNum));
        Assert.assertTrue(checkResponseKeyValueExists(sub, "passNumber", passNum));
        Assert.assertTrue(checkResponseKeyValueExists(sub, "orderStatus", ordStat));
        Assert.assertTrue(checkResponseKeyValueExists(sub, "amount", amount));

        logger.trace("CreateCall.ordersInList(" + ordId +
                "," + cardNum +
                "," + passNum +
                "," + ordStat +
                "," + amount +
                ")");
    }



}
