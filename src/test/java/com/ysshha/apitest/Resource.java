package com.ysshha.apitest;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.restassured.specification.RequestSpecification;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

import org.json.JSONObject;


public class Resource {

    Logger 	logger = LogManager.getLogger(Resource.class.getName());
    public static String			baseURL;
    protected static Response 		response;
    protected static String 		jsonString;
    protected int Id = -1;


    Resource() {
        logger.trace("Resource()");

        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }


    public void get(String str) {

        RequestSpecification request = RestAssured.given();
        response = request.get(str);

        logger.trace("get(" + str + "]");
    }

    public String getResponse() {

        String ret = response.asString();

        logger.trace("getResponse()");

        return ret;
    }


    public JSONObject getJSONObjectByKeyValue(String key, String val) {

        logger.trace("getJSONObjectByKeyValue(String, String)");

        JSONObject  ret = null;

        String s =  response.asString();

        //logger.trace("response [" + s + "]");

        JSONArray jArray = new JSONArray(s);

        if (jArray != null) {

            for (int i=0;i<jArray.length();i++){

                JSONObject jo = jArray.getJSONObject(i);
                String value = jo.getString(key);

                System.out.println("val: [" + val + "] value: [" + value + "]");

                if (val.equals(value)) {

                    return jo;
                }

            }
        }


        return ret;
    }

    public JSONObject getJSONObjectByKeyValue(String key, int id) {

        logger.trace("getJSONObjectByKeyValue(String, int)");

        JSONObject  ret = null;

        String s =  response.asString();

       // logger.trace("response [" + s + "]");

        JSONArray jArray = new JSONArray(s);

        if (jArray != null) {

            for (int i=0;i<jArray.length();i++){

                JSONObject jo = jArray.getJSONObject(i);
                //String value = jo.getString(key);
                //int val = Integer.parseInt(value);
                int val = jo.getInt(key);

                System.out.println("val: [" + id + "] value: [" + val + "]");

                if (val==id) {

                    return jo;
                }

            }
        }

        //logger.trace("NULL!");
        return ret;
    }


    public Collection getCollectionJSONObjectByKeyValue(String key, int id) {

        logger.trace("getJSONObjectByKeyValue(String, int)");

        //JSONObject  ret = null;
        Collection col = new LinkedList();

        String s =  response.asString();

        // logger.trace("response [" + s + "]");

        JSONArray jArray = new JSONArray(s);

        if (jArray != null) {

            for (int i=0;i<jArray.length();i++){

                JSONObject jo = jArray.getJSONObject(i);
                //String value = jo.getString(key);
                //int val = Integer.parseInt(value);
                int val = jo.getInt(key);

                System.out.print("val: [" + id + "] value: [" + val + "]");

                if (val==id) {

                    col.add(jo);
                    System.out.println(" - added");
                } else {
                    System.out.println(" - NOT added");
                }

            }
        }

        //logger.trace("NULL!");
        return col;
    }


    public String getKeyStringValueFromJSONObject(JSONObject jo, String key) {

        logger.trace("getKeyStringValueFromJSONObject");
        String ret = "";

        if (jo != null) {

            JsonParser parser = new JsonParser();

            JsonObject jsonObj = parser.parse(jo.toString()).getAsJsonObject();
            JsonElement je = jsonObj.get(key);
            ret = je.toString();
        } else {

        }

        return ret;
    }

    public int getKeyIntValueFromJSONObject(JSONObject jo, String key) {

        logger.trace("getKeyIntValueFromJSONObject");
        int ret = 0;

        if (jo != null) {

            JsonParser parser = new JsonParser();

            JsonObject jsonObj = parser.parse(jo.toString()).getAsJsonObject();
            JsonElement je = jsonObj.get(key);
            String s = je.toString();
            ret = Integer.parseInt(s);

        } else {

        }

        return ret;
    }


}
