package com.bestbuy.crudtest;

import com.bestbuy.model.StorePojo;
import com.bestbuy.testbase.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class StoresCURDTest extends TestBase {


    @Before
    public void setUp() {
        RestAssured.basePath = "/stores";
    }

    @Test
    public void test001() {

        StorePojo storePojo = new StorePojo();
        storePojo.setName("Tesco");
        storePojo.setType("Ashford");
        storePojo.setAddress("11 ");
        storePojo.setAddress2("cecil Road");
        storePojo.setCity("Hounslow");
        storePojo.setState("London");
        storePojo.setZip("Tw1 3QP");
        storePojo.setLat(123345);
        storePojo.setLng(12345);
        storePojo.setHours("8:00");

        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .body(storePojo)
                .post();

        response.then().log().all().statusCode(201);


    }


    @Test
    public void test002() {

        Response response = given()
                .when()
                .get("/8922");
        response.then().log().all().statusCode(200);

    }

    @Test
    public void test003() {
        StorePojo storePojo = new StorePojo();
        storePojo.setHours("9:00");
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .body(storePojo)
                .patch("/8922");
        response.then().log().all().statusCode(200);
    }

    @Test
    public void test004() {
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .delete("/8922");
        response.then().log().all().statusCode(200);
    }

}
