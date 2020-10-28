package com.ysshha.apitest;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

public class IdCall extends AbstractCall {

    private static final Logger logger = LogManager.getLogger(IdCall.class);

    public void getId(int id) {

        RequestSpecification request = RestAssured.given();
        String str = "/order/".concat(Integer.toString(id));
        response = request.get(str);
    
        logger.trace("IdCall.getId(" + id + ") Request[" +  str + "]");
    }

    public void checkList() {


        Assert.assertTrue(checkResponseContentType("application/json"));
        Assert.assertTrue(checkResponseStatusCode(200));
        Assert.assertTrue(checkResponseStatusLine("HTTP/1.1 200 "));
        Assert.assertTrue(checkResponseHeadersContain("Connection=keep-alive"));

        logger.trace("IdCall.checkList()");
    }


    public void checkOrderId(int ordId, String cardNum, String passNum,  String ordStat, int amount) {

        String str = response.asString();
        String sub = str.substring(1, str.length() - 1);

        Assert.assertTrue(checkResponseKeyValueExists(sub, "orderId", ordId));
        Assert.assertTrue(checkResponseKeyValueExists(sub, "cardNumber", cardNum));
        Assert.assertTrue(checkResponseKeyValueExists(sub, "passNumber", passNum));
        Assert.assertTrue(checkResponseKeyValueExists(sub, "orderStatus", ordStat));
        Assert.assertTrue(checkResponseKeyValueExists(sub, "amount", amount));

        logger.trace("IdCall.checkOrderId(" + ordId +
                "," + cardNum + "," + passNum + "," + ordStat + "," + amount + ")");
    }


}
