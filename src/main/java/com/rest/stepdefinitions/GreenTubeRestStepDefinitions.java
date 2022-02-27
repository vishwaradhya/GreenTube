package com.rest.stepdefinitions;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import com.framework.commonutils.Paths;
import com.framework.commonutils.PropertiesFile;
import com.framework.commonutils.UserDataPath;
import com.framework.rest.RestImpl;
import com.jayway.restassured.response.Response;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class GreenTubeRestStepDefinitions extends RestImpl {
	public static final String BASE_URL;
	public static final String APP_ID = "";
	public static Response httpResponse;
	protected static Map<String, String> query = new HashMap<>();
	static {

		BASE_URL = PropertiesFile.getPropertyValue(UserDataPath.USER_DATA_PATH, "BASE_URL");
		query.put("apiKey", PropertiesFile.getPropertyValue(UserDataPath.USER_DATA_PATH, "APP_KEY"));
	}

	@Given("^user get the maps with pin for following places$")
	public void addDetails(DataTable dataTable) {

		StringBuffer coordinates = new StringBuffer();
		for (final Map<String, String> row : dataTable.asMaps(String.class, String.class)) {

			coordinates.append(row.get("longitude-latitude"));
		}
		httpResponse = getRequestWithQueryParams(BASE_URL, coordinates + Paths.PIN_MAP, query);
	}

	@When("^user updates maps by following values$")
	public void updateValues(DataTable dataTable) {

		StringBuffer coordinates = new StringBuffer();
		for (final Map<String, String> row : dataTable.asMaps(String.class, String.class)) {
			coordinates.append(row.get("longitude-latitude"));
		}

		httpResponse = getRequestWithQueryParams(BASE_URL, coordinates + Paths.PIN_MAP, query);

	}

	@Given("^user get the maps with invalid API KEY with following valid details$")
	public void invalidApiKey(DataTable dataTable) {

		StringBuffer coordinates = new StringBuffer();
		for (final Map<String, String> row : dataTable.asMaps(String.class, String.class)) {
			coordinates.append(row.get("longitude-latitude"));
		}
		query.put("apiKey", PropertiesFile.getPropertyValue(UserDataPath.USER_DATA_PATH, "APP_INVALID_KEY"));

		httpResponse = getRequestWithQueryParams(BASE_URL, Paths.MAPS_GET, query);
	}

	
	@Given("^user get the maps with invalid base url with following valid details$")
	public void invalidBaseUrl(DataTable dataTable) {
	   
		StringBuffer coordinates = new StringBuffer();
		for (final Map<String, String> row : dataTable.asMaps(String.class, String.class)) {
			coordinates.append(row.get("longitude-latitude"));
		}

		query.put("apiKey", PropertiesFile.getPropertyValue(UserDataPath.USER_DATA_PATH, "APP_KEY"));
		httpResponse = getRequestWithQueryParams(PropertiesFile.getPropertyValue(UserDataPath.USER_DATA_PATH, "BASE_URL_INVALID"), coordinates + Paths.PIN_MAP, query);
	}
	
	@Given("^user verifies the status code (\\d+)$")
	public void verifyStatusCode(int statusCode) {

		assertTrue("Respose Code not matched Expected " + statusCode + " Actual is " + httpResponse.getStatusCode(),
				httpResponse.getStatusCode() == statusCode);
	}

}
