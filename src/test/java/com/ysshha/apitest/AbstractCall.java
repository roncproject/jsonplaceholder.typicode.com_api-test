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
		logger.trace("AbstractCall.AbstractCall()");
	}

	public void initCalls(String uri) {

		RestAssured.baseURI = uri;
		logger.trace("AbstractCall.initCalls(" + uri + ")");
	}


	public boolean checkResponseStatusCode(int code) {

		int statusCode = response.getStatusCode();

		logger.trace("AbstractCall.checkResponseStatusCode(" + code + ") [" + statusCode + "]");

		return ( statusCode == code);
	}


	public boolean checkResponseHeadersContain(String str) {

		String headers = response.getHeaders().toString();

		logger.trace("AbstractCall.checkResponseHeadersContain(" + str + ") [" + headers + "]");

		return (headers.contains( str ));
	}


	public boolean checkResponseContentType(String type) {

		String contentType = response.getContentType();

		logger.trace("AbstractCall.checkResponseContentType("  + type + ") " + contentType);

		return (contentType.equals(type));
	}


	public boolean checkResponseStatusLine(String line) {

		String statusLine = response.getStatusLine();

		logger.trace("AbstractCall.checkResponseStatusLine(" + line + ") [" + statusLine + "]");

		return (statusLine.equals(line));
	}


	public boolean checkResponseKeyExists(String response, String key) {

		JsonParser parser = new JsonParser();
		JsonObject jsonObject = parser.parse(response).getAsJsonObject();

		logger.trace("AbstractCall.checkResponseKeyExists(" + response + "," + key + ")");

		return jsonObject.has(key);
	}


	public boolean checkResponseKeyValueExists(String response, String key, String value) {

		JsonParser parser = new JsonParser();
		JsonObject jsonObject = parser.parse(response).getAsJsonObject();
		String key_value = jsonObject.get(key).toString();

		boolean ret = (value.equals(key_value));
		logger.trace("AbstractCall.checkResponseKeyValueExists("
				+ response + "," + key + "," + value + ") => ["  +  key_value + "] ");

		return ret;
	}


	public boolean checkResponseKeyValueExists(String response, String key, int value) {

		JsonParser parser = new JsonParser();
		JsonObject jsonObject = parser.parse(response).getAsJsonObject();
		int key_value = Integer.parseInt(jsonObject.get(key).toString());
		boolean ret = (value == key_value);

		logger.trace("AbstractCall.checkResponseKeyValueExists("
				+ response + "," + key + "," + value + ") => ["  +  key_value + "] ");

		return ret;
	}

}