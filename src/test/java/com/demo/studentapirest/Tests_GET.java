package com.demo.studentapirest;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

public class Tests_GET {

    @Test
    public void test_1() {

        given()
                .header("Content-Type", "application-json")
                .param("page", 2)
                .get("https://reqres.in/api/users")
        .then()
                .statusCode(200)
                .body("data.id[1]", equalTo(8))
                .body("data.first_name", hasItems("Michael", "Lindsay"));

    }
}
