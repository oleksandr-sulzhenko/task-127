package org.example.api.response;

import io.restassured.response.Response;

/**
 * Processes API responses for success and failure. Converts them to POJO. Can be extended to verify errors
 */
public class AssertableResponse {

    private final Response response;

    public AssertableResponse(Response response) {
        this.response = response;
    }

    public Response getResponse() {
        return response;
    }

    public AssertableResponse assertStatus(int statusCode) {
        response.then().statusCode(statusCode);
        return this;
    }

    public <T> T getResponseBody(Class<T> clazz) {
        return response.then()
                .extract().as(clazz);
    }
}

