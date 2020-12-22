package com.ysshha.apitest;


import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.json.JSONObject;

import java.util.Collection;
import java.util.Iterator;

public class Post extends Resource {

    Post(){

        logger.trace("user()");
    }

    public void list() {

        get("/posts");

        logger.trace("list()");
    }

    public void list(int id) {

        String  s = "/posts/" + id;

        get(s);

        logger.trace("list(int)");
    }

    public void listUserId(int userId) {

        String  s = "/posts/";

        get(s);

        Collection c = getCollectionJSONObjectByKeyValue("userId", userId);
        Iterator iterator = c.iterator();
        while (iterator.hasNext()) {

            JSONObject jo = (JSONObject) iterator.next();
            if (jo != null) {

                JsonParser parser = new JsonParser();

                JsonObject jsonObj = parser.parse(jo.toString()).getAsJsonObject();
                JsonElement je = jsonObj.get("title");
                String t = je.toString();
                System.out.println("bla bla: ["  + t +  "]");
            }


        }

        logger.trace("list(int)");
    }



    public void list(String userId) {

        String  s = "/posts/";

        get(s);

        //String id = getKeyStringValueFromJSONObject(getJSONObjectByKeyValue("userId", userId), "id");

        logger.trace("list(String ) ");
    }

    public String getId(String userName) {

//        String  s = "/users/";
//
//        get(s);

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
