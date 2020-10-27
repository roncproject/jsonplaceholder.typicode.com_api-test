package com.ysshha.apitest;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class AbstractCall {

	private static final Logger logger = LogManager.getLogger(AbstractCall.class.getName());

	public static String	baseURL;
	protected static Response response;
	protected static String jsonString;

	AbstractCall() {
		logger.info("AbstractCall.AbstractCall()");

	}

	public void initCalls(String s) {
		logger.info("AbstractCall.initCalls(" + s + ")");
		RestAssured.baseURI = s;

	}

	public boolean checkResponseStatusCode(int code) {
		logger.info("AbstractCall.checkResponseStatusCode(" + code + ") " + response.getStatusCode());

		logger.info(response.getStatusLine());
		logger.info(response.getHeaders());

		return (response.getStatusCode() == code);
	}

	public boolean checkResponseHeadersContain(String str) {
		logger.info("AbstractCall.checkResponseHeadersContain(" + str + ")" + response.getHeaders().toString());

		String s = response.getHeaders().toString();

		return (s.contains( str ));
	}


	public boolean checkResponseHeaders(String headers) {
		logger.info("AbstractCall.checkResponseHeaders(" + headers + ")" + response.getHeaders());

		return (response.getHeaders().toString().equals(headers));
	}


	public boolean checkResponseContentType(String type) {
		logger.info("AbstractCall.checkResponseContentType("  + type + ") " + response.getContentType());

		return (response.getContentType().equals(type));
	}


	public boolean checkResponseStatusLine(String line) {
		logger.info("AbstractCall.checkResponseStatusLine(" + line + ") [" + response.getStatusLine() + "]");

		return (response.getStatusLine().equals(line));
	}


	public boolean checkResponseKeyExists(String response, String key) {

		logger.info("AbstractCall.checkResponseKeyExists");
		JsonParser parser = new JsonParser();
		JsonObject jsonObject = parser.parse(response).getAsJsonObject();
		logger.info(jsonObject.get(key));
		return jsonObject.has(key);
	}

	public boolean checkResponseKeyValueExists(String response, String key, String val) {
//		logger.info("AbstractCall.checkResponseKeyValueExists("
//				+ response + "," + key + "," + val + ")");
		boolean ret;
		JsonParser parser = new JsonParser();
		JsonObject jsonObject = parser.parse(response).getAsJsonObject();
		logger.info("============================");
		String x = jsonObject.get(key).toString();
		logger.info("a[key] [" + x + "]");
		logger.info("val    [" + val + "]");

		ret = (val.equals(x));
		logger.info("AbstractCall.checkResponseKeyValueExists("
				+ response + "," + key + "," + val + ") => ["  +  jsonObject.get(key) + "] " + ret);

		return ret;

	}

	public boolean checkResponseKeyValueExists(String response, String key, int i) {
//		logger.info("AbstractCall.checkResponseKeyValueExists("
//				+ response + "," + key + "," + val + ")");
		boolean ret;
		JsonParser parser = new JsonParser();
		JsonObject jsonObject = parser.parse(response).getAsJsonObject();
		logger.info("============================");
		String x = jsonObject.get(key).toString();
		int y = Integer.parseInt(x);
		logger.info("a[key] [" + y + "]");
		logger.info("val    [" + i + "]");

		ret = (i == y);
		logger.info("AbstractCall.checkResponseKeyValueExists("
				+ response + "," + key + "," + i + ") => ["  +  jsonObject.get(key) + "] " + ret);

		return ret;

	}







}