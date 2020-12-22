package com.ysshha.apitest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;


public class User extends Resource {

    User(){

        logger.trace("user()");
    }

    public void list() {

        get("/users");

        logger.trace("list()");
    }

    public void list(int id) {

        String  s = "/users/" + id;

        get(s);

        logger.trace("list(int)");
    }

    public void list(String userName) {

        String  s = "/users/";

        get(s);

        String id = getKeyStringValueFromJSONObject(getJSONObjectByKeyValue("username", userName), "id");

        logger.trace("list(String ) [" + id + "]");
    }

    public String getId(String userName) {

        String  s = "/users/";

        get(s);

        String id = getKeyStringValueFromJSONObject(getJSONObjectByKeyValue("username", userName), "id");

        logger.trace("getId(String ) [" + id + "]");

        return id;
    }


//    public int getId(String userName) {
//
//        String  s = "/users/";
//
//        get(s);
//
//        int id = getKeyIntValueFromJSONObject(getJSONObjectByKeyValue("username", userName), "id");
//
//        logger.trace("getId(String ) [" + id + "]");
//
//        return id;
//    }

    public int getId(int i) {

        String  s = "/users/";
//
        get(s);


        int id = getKeyIntValueFromJSONObject(getJSONObjectByKeyValue("id", i), "id");

        logger.trace("getId(int ) [" + id + "]");

        return id;
    }


}
