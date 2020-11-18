package com.ysshha.apitest;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class AbstractCall {

	private static final Logger 	logger = LogManager.getLogger(AbstractCall.class.getName());
	public static String			baseURL;
	protected static Response 		response;
	protected static String 		jsonString;


	AbstractCall() {
		logger.trace("AbstractCall()");
	}

	public void initCalls(String uri) {

		RestAssured.baseURI = uri;
		logger.trace("initCalls(" + uri + ")");
	}


	public boolean checkResponseStatusCode(int code) {

		int statusCode = response.getStatusCode();

		logger.trace("checkResponseStatusCode(" + code + ") [" + statusCode + "]");

		return ( statusCode == code);
	}


	public boolean checkResponseHeadersContain(String str) {

		String headers = response.getHeaders().toString();

		logger.trace("checkResponseHeadersContain(" + str + ") [" + headers + "]");

		return (headers.contains( str ));
	}


	public boolean checkResponseContentType(String type) {

		String contentType = response.getContentType();

		logger.trace("checkResponseContentType("  + type + ") [" + contentType + "]");

		return (contentType.equals(type));
	}


	public boolean checkResponseStatusLine(String line) {

		String statusLine = response.getStatusLine();

		logger.trace("checkResponseStatusLine(" + line + ") [" + statusLine + "]");

		return (statusLine.equals(line));
	}


	public boolean checkResponseKeyExists(String response, String key) {

		JsonParser parser = new JsonParser();
		JsonObject jsonObject = parser.parse(response).getAsJsonObject();

		boolean	hasKey = jsonObject.has(key);	

		logger.trace("checkResponseKeyExists(" + key + ") [" + hasKey + "]");

		return hasKey;
	}


	public String getResponseKeyValue(String response, String key) {

		String ret = "";

		JsonParser parser = new JsonParser();
		JsonObject jsonObject = parser.parse(response).getAsJsonObject();
		ret = jsonObject.get(key).toString();

		logger.trace("getResponseKeyValue(" + key + ") => ["  +  ret + "] ");

		return ret;
	}

	
	public String getResponseKeyValue(String key) {

		String ret = "";
		String s =  response.asString();

		JsonParser parser = new JsonParser();
		JsonObject jsonObject = parser.parse(s).getAsJsonObject();
		ret = jsonObject.get(key).toString();

		logger.trace("getResponseKeyValue(" +  key + ")");

		return ret;
	}


	public boolean checkResponseKeyValueExists(String response, String key, String value) {

		JsonParser parser = new JsonParser();
		JsonObject jsonObject = parser.parse(response).getAsJsonObject();
		String key_value = jsonObject.get(key).toString();

		boolean ret = (value.equals(key_value));
		logger.trace("checkResponseKeyValueExists(" + key + "," + value + ") => ["  +  key_value + "] ");

		return ret;
	}


	public boolean checkResponseKeyValueExists(String response, String key, int value) {

		JsonParser parser = new JsonParser();
		JsonObject jsonObject = parser.parse(response).getAsJsonObject();
		int key_value = Integer.parseInt(jsonObject.get(key).toString());
		boolean ret = (value == key_value);

		logger.trace("checkResponseKeyValueExists(" + key + "," + value + ") => ["  +  key_value + "] ");

		return ret;
	}

}