package com.demo.studentapirest;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.junit.Test;
import static io.restassured.RestAssured.*;

public class Tests_01_json_server_api {

    @Test
    public void test_get_users() {
        baseURI = "http://localhost:3000/";
        given()
                .get("/users")
        .then()
                .statusCode(200)
                .log().all();

    }

    @Test
    public void test_get_subjects() {
        baseURI = "http://localhost:3000/";
        enableLoggingOfRequestAndResponseIfValidationFails();
        given()
                .param("name", "MySQL")
                .get("/subjects")
        .then()
                .statusCode(200);

    }

    @Test
    public void test_user_post() {

        JSONObject reqBody = new JSONObject();
        reqBody.put("firstName", "John");
        reqBody.put("lastName", "Hopkins");
        reqBody.put("subjectId", "1");

        baseURI = "http://localhost:3000/";
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Content-Type", "application/json")
                .body(reqBody.toJSONString())
        .when()
                .post("/users")
        .then()
                .statusCode(201)
                .log().all();

    }

    @Test
    public void test_user_patch() {

        JSONObject reqBody = new JSONObject();
        reqBody.put("lastName", "Abraham");

        baseURI = "http://localhost:3000/";
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Content-Type", "application/json")
                .body(reqBody.toJSONString())
        .when()
                .patch("/users/4")
        .then()
                .statusCode(200)
                .log().all();

    }

    @Test
    public void test_user_put() {

        JSONObject reqBody = new JSONObject();
        reqBody.put("firstName", "Mary");
        reqBody.put("lastName", "Jane");
        reqBody.put("subjectId", "1");

        baseURI = "http://localhost:3000/";
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Content-Type", "application/json")
                .body(reqBody.toJSONString())
        .when()
                .put("/users/4")
        .then()
                .statusCode(200)
                .log().all();

    }

    @Test
    public void test_user_delete() {

        baseURI = "http://localhost:3000/";
        when()
                .delete("/users/4")
        .then()
                .statusCode(200)
                .log().all();

    }

}
