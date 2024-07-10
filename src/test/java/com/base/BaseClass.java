package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClass {
	RequestSpecification reqspec;
	Response response;
	
	public void addHeaders(Headers headers) {
		reqspec = RestAssured.given().headers(headers);
	}

	public void addHeader(String key, String value) {
		reqspec = RestAssured.given().header(key, value);

	}
	
	public void addBasicAuth(String userName, String password) {
		reqspec = reqspec.auth().preemptive().basic(userName, password);

	}

	public void addReqBody(String payload) {
		reqspec = reqspec.body(payload);

	}
	
	public void addReqBody(Object payload) {
		reqspec = reqspec.body(payload);

	}
	
	public void addMultiPartFormData(String key, File file) {
		reqspec.multiPart(key, file);
	}
	

	public Response addReqType(String type, String endpoint) {
		switch (type) {
		case "GET":
			response = reqspec.get(endpoint);
			break;
		case "POST":
			response = reqspec.post(endpoint);
			break;
		case "PUT":
			response = reqspec.put(endpoint);
			break;
		case "PATCH":
			response = reqspec.patch(endpoint);
			break;
		case "DELETE":
			response = reqspec.delete(endpoint);
			break;

		default:
			break;
		}
		return response;

	}

	public int getStatusCode(Response response) {
		int statusCode = response.getStatusCode();
		return statusCode;
	}

	public String getResBodyAsString(Response response) {
		String asString = response.asString();
		return asString;
	}

	public String getResBodyAsPrettyString(Response response) {
		String asPrettyString = response.asPrettyString();
		return asPrettyString;

	}
	

	public String getProjectPath() {
		return System.getProperty("user.dir");
	}
	
	public String getPropertyFileValue(String key) throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream(getProjectPath()+"\\config\\config.properties"));
		String value = (String)properties.get(key);
		return value;
	}

}
