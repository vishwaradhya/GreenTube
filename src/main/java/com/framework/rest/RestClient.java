package com.framework.rest;

import com.jayway.restassured.response.Response;

public interface RestClient {

	public Response getRequest(String url, String path);

	public Response postRequest(String url, String path, String contentType, String rawBody);

	public Response putRequest(String url, String path, String contentType, String rawBody);

	public Response deleteRequest(String url, String path);
}
