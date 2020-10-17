package com.demo.studentapirest;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Tests_POST {

//    @Test
    public void test_1_post() {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "Radhakrishnan");
        map.put("job", "consultant");
        System.out.println(map);

        JSONObject request = new JSONObject(map);
        System.out.println(request);
        System.out.println(request.toJSONString());

        JSONObject newRequest = new JSONObject();
        newRequest.put("name", "Meiappan");
        newRequest.put("role", "financier");
        System.out.println(newRequest);

        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(newRequest.toJSONString())
        .when()
                .post("https://reqres.in/api/users")
        .then()
                .statusCode(201);


    }

//    @Test
    public void test_2_put() {

        JSONObject newRequest = new JSONObject();
        newRequest.put("name", "Meiappan");
        newRequest.put("role", "financier");

        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(newRequest.toJSONString())
        .when()
                .put("https://reqres.in/api/users/2")
        .then()
                .statusCode(200)
                .log().all();

    }

//    @Test
    public void test_3_patch() {

        JSONObject newRequest = new JSONObject();
        newRequest.put("name", "Meiappan");
        newRequest.put("role", "entrepreneur");

        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(newRequest.toJSONString())
                .log().all()
        .when()
                .patch("https://reqres.in/api/users/2")
        .then()
                .statusCode(200)
                .log().all();

    }

    @Test
    public void test_4_delete() {

        given()
                .delete("https://reqres.in/api/users/2")
        .then()
                .statusCode(204)
                .log().all();

    }

}
