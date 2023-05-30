package com.bestbuy.crudtest;

import com.bestbuy.model.ProductPojo;
import com.bestbuy.testbase.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ProductsCRUDTest extends TestBase {

    @Before
    public void setUp() {
        RestAssured.basePath = "/products";
    }

    @Test
    public void test001() {
        ProductPojo productPojo = new ProductPojo();
        productPojo.setName("MacBook");
        productPojo.setType("Pro");
        productPojo.setPrice(2000.99);
        productPojo.setShipping(10);
        productPojo.setUpc(12345);
        productPojo.setDescription("any");
        productPojo.setManufacturer("ABC");
        productPojo.setModel("Mac01");
        productPojo.setUrl("");
        productPojo.setImage(" ");

        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .body(productPojo)
                .post();

        response.then().log().all().statusCode(201);

    }


    @Test
    public void test002() {
        Response response = given()
                .when()
                .get("/abc");
        response.then().log().all().statusCode(200);

    }

    @Test
    public void test003() {
        ProductPojo productPojo = new ProductPojo();
        productPojo.setPrice(1400.99);
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .body(productPojo)
                .patch("/abc");
        response.then().log().all().statusCode(200);
    }

    @Test
    public void test004() {
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .delete("/abc");
        response.then().log().all().statusCode(200);
    }

}





