package com.ysshha.apitest;


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

        getJSONObjectByKeyValue("userId", userId);

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
