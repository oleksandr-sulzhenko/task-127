package org.example.api.extensions;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.example.api.dto.BaseDto;

import static io.restassured.RestAssured.*;


/*
    General CRUD requests that can be used for all new entities
 */
abstract class Extension<T extends BaseDto> {
    protected final String baseEndpoint;
    protected final String domain;
    protected final Class<T> clazz;

    public Extension(String domain, String baseEndpoint, Class<T> clazz) {
        this.baseEndpoint = baseEndpoint;
        this.domain = domain;
        this.clazz = clazz;
    }

    protected Response sentGeneralGetRequest(String endpoint) {
        return given()
                .when().get(domain + endpoint)
                .thenReturn();
    }

    protected Response sentGeneralPostRequest(String endpoint, T t) {
        return given()
                .body(t)
                .when().post(domain + endpoint)
                .thenReturn();
    }

    protected Response sentGeneralPutRequest(String endpoint, T t) {
        return given()
                .body(t)
                .when().put(domain + endpoint)
                .thenReturn();
    }

    protected Response sentGeneralDeleteRequest(String endpoint) {
        return given()
                .when().delete(domain + endpoint)
                .thenReturn();
    }
}