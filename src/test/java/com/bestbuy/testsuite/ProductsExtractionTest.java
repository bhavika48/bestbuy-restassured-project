package com.bestbuy.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ProductsExtractionTest {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/products")
                .then().statusCode(200);

    }


    @Test
    public void test021ExtractTheLimit() {
        int limit = response.extract().path("limit");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + limit);
        System.out.println("------------------End of Test---------------------------");

    }

    @Test
    public void test022ExtractTheTotal() {
        int total = response.extract().path("total");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + total);
        System.out.println("------------------End of Test---------------------------");

    }

    @Test
    public void test023ExtractTheNameOf5thProduct() {
        String productName = response.extract().path("data[5].name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The first product name is : " + productName);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test024ExtractTheNamesOfAllTheProducts() {
        List<String> productName = response.extract().path("data.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The names of the products are :" + productName);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test025ExtractTheProductIdOfAllTheProducts() {
        List<Integer> listOfIds = response.extract().path("data.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("List of Ids are : " + listOfIds);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test026PrintTheSizeOfTheDataList() {
        int size = response.extract().path("data.size");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + size);
        System.out.println("------------------End of Test---------------------------");

    }

    @Test
    public void test027GetAllTheValueOfTheProductWhereProductNameEnergizerMAXBatteriesAA4Pack() {
        List<HashMap<String, ?>> values = response.extract().path("data.findAll{it.name == 'Energizer - MAX Batteries AA (4-Pack)'}");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The values for product name 'Duracell - AA Batteries (8-Pack)' are: " + values);
        System.out.println("------------------End of Test---------------------------");

    }

    @Test
    public void test028GetTheModelOfTheProductWhereProductNameEnergizerNCellE90Batteries2Pack() {
        String modelName = response.extract().path("data[8].model");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The names of the products are :" + modelName);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test029GetAllTheCategoriesOf8thProducts() {
        List<HashMap<String, ?>> name = response.extract().path("data[8].categories");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The first product name is : " + name);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test030GetCategoriesOfTheStoreWhereProductId150115() {
        List<Integer> categories = response.extract().path("data[3].categories");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The first product name is : " + categories);
        System.out.println("------------------End of Test---------------------------");

    }


    @Test
    public void test031GetAllTheDescriptionsOfAllTheProducts() {
        List<HashMap<String, ?>> productName = response.extract().path("data.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The names of the products are :" + productName);
        System.out.println("------------------End of Test---------------------------");

    }

    @Test
    public void test032GetIdOfAllTheAllCategoriesOfAllTheProducts() {
        List<HashMap<String, ?>> Id = response.extract().path("data.categories.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The names of the products are :" + Id);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test033FindTheProductNamesWhereTypeHardGood() {
        List<HashMap<String, ?>> productName = response.extract().path("data.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The names of the products are :" + productName);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test034FindTheTotalNumberOfCategoriesForTheProductWhereProductNameDuracellAAVCopperTopBatteries4Pack() {
        // System.out.println(response.extract().path("data.findAll{it.name =='Duracell-AA1.5V CopperTop Batteries (4-Pack)'}").toString());
        System.out.println(response.extract().path("data.findAll{it.name =='Duracell - AA 1.5V CopperTop Batteries (4-Pack)'}.categories.size").toString());
        List<Double> categories = response.extract().path("data.findAll{it.name =='Duracell-AA1.5V CopperTop Batteries (4-Pack)'}.categories");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The price of product name 'Duracell-AA1.5V CopperTop Batteries (4-Pack)' is : " + categories);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test035FindTheCreatedAtForAllProductsWhosePriceLessThan549() {
        List<String> productNames = response.extract().path("data.findAll{it.price < 5.49}.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The names of products that price is less than 5.49 are: " + productNames);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test036FindTheNameOfAllCategoriesWhereProductNameEnergizerMAXBatteriesAA4Pack() {
        List<HashMap<String, ?>> categories = response.extract().path("data[3].categories");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The names of the categories where product name 'Energizer - MAX Batteries AA (4-Pack)' are :" + categories);
        System.out.println("------------------End of Test---------------------------");
    }


    @Test
    public void test037FindTheManufacturerOfAllTheProducts() {
        List<HashMap<String, ?>> manufacturer = response.extract().path("data.manufacturer");
        // String manufacturer = response.extract().path("data.manufacturer");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The names of the manufacturer are :" + manufacturer);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test038FindTheImageOfProductsWhoseManufacturerIsEnergizer() {
        String image = response.extract().path("data[3].image");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The names of the products are :" + image);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test040FindTheURLOfAllTheProducts() {
        //    String url = response.extract().path("data.url");
        List<HashMap<String, ?>> url = response.extract().path("data.url");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The URL of all the products: " + url);
        System.out.println("------------------End of Test---------------------------");
    }
}
