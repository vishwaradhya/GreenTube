package com.framework.rest;

import com.jayway.restassured.response.Response;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import static com.jayway.restassured.RestAssured.given;

import java.util.Map;

import com.jayway.restassured.RestAssured;

/**
 * @author Vishwaradhya Hiremath
 *
 */

public class RestImpl {

	Response response;
	private static Logger logger = LogManager.getLogger(RestImpl.class);

	/**
	 * This method is used to Send HTTP GET request
	 * 
	 * @param url  - Base URI
	 * @param path - Get Request Path
	 * @return - Returns the httpResponse for the get request
	 */
	public Response getRequest(String url, String path) {

		response = given().log().all().get(url + path).then().extract().response();

		return this.response;
	}

	/**
	 * This method is used to send POST HTTP request
	 * 
	 * @param url         - Base URI
	 * @param path        - Get Request Path
	 * @param contentType - Content Type for the request
	 * @return - Returns the httpResponse for the POST request
	 */
	public Response postRequest(String url, String path, String contentType, String rawBody) {

		RestAssured.baseURI = url + path;
		response = given().contentType(contentType).body(rawBody).when().post("").then().extract().response();

		return this.response;
	}

	/**
	 * This method is used to send PUT HTTP request
	 * 
	 * @param url         - Base URI
	 * @param path        - Get Request Path
	 * @param ContentType - Content Type for the request
	 * @return - Returns the httpResponse for the PUT request
	 */
	public Response putRequest(String url, String path, String corntentType, String rawBody) {

		RestAssured.baseURI = url + path;
		response = given().log().all().contentType(corntentType).body(rawBody).when().put().then().extract()
				.response();

		return this.response;
	}

	/**
	 * This method is used to send DELETE HTTP request
	 * 
	 * @param url  - Base URI
	 * @param path - Get Request Path
	 * @return - Returns the httpResponse for the DELETE request
	 */
	public Response deleteRequest(String url, String path) {

		response = given().delete(url + path).then().extract().response();
		return response;
	}

	/**
	 * This method is used to get the status code for a current request
	 * 
	 * @param statusCode
	 * @return
	 */
	public boolean statusCodeVerification(int statusCode) {
		logger.info("httpResponse.getStatusCode() " + response.getStatusCode());
		return this.response.getStatusCode() == statusCode;
	}

	/**
	 * This method is used to send GET HTTP request with query params
	 * 
	 * @param url         - Base URI
	 * @param path        - Get Request Path
	 * @param queryParams - query parameters in hashmap
	 * @return - Returns the httpResponse for the DELETE request
	 */
	public Response getRequestWithQueryParams(String url, String path, Map<String, String> queryParams) {
		response = given().log().all().queryParameters(queryParams).get(url + path).then().extract().response();
		return response;

	}

}
