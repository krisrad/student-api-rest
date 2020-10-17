package com.demo.studentapirest;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Tests_Data_Driven_Examples extends data_for_testng_tests{

    @Test(dataProvider = "DynamicDataForPost2")
    public void test_user_post(String firstName, String lastName, int subjectId) {

        JSONObject reqBody = new JSONObject();
        reqBody.put("firstName", firstName);
        reqBody.put("lastName", lastName);
        reqBody.put("subjectId", subjectId);

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

    @Test(dataProvider="DataForDelete")
    public void test_user_delete(int userId) {

        baseURI = "http://localhost:3000/";
        when()
                .delete("/users/"+userId)
                .then()
                .statusCode(200)
                .log().all();

    }

}
