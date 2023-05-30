package com.bestbuy.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class StoresExtractionTest {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/stores")
                .then().statusCode(200).log().all();
    }

    //1. Extract the limit
    @Test
    public void test001() {
        int limit = response.extract().path("limit");
        System.out.println("The value of limit is : " + limit);
    }

    //2. Extract the total
    @Test
    public void test002() {
        int total = response.extract().path("total");
        System.out.println("The value of total is : " + total);
    }

    //3. Extract the name of 5th store
    @Test
    public void test003() {
        String storeName5 = response.extract().path("data[4].name");
        System.out.println("The value of storeName5 is : " + storeName5);
    }

    //4. Extract the names of all the store
    @Test
    public void test004() {
        //List<String> storeNames = response.extract().path("data.findAll.name");
        List<String> storeNames = response.extract().jsonPath().getList("data.name");
        System.out.println("The value of storeNames is : " + storeNames);
    }

    //5. Extract the storeId of all the store
    @Test
    public void test005() {

        List<Integer> storeId = response.extract().jsonPath().getList("data.id");
        System.out.println("The value of storeId is : " + storeId);
    }

    //6. Print the size of the data list
    @Test
    public void test006() {
        int sizeOfData = response.extract().path("data.size");
        System.out.println("The value of sizeOfData is : " + sizeOfData);
    }

    //7. Get all the value of the store where store name = St Cloud
    @Test
    public void test007GetAllTheValueOfTheStoreWhereStoreNameStCloud() {
        List<String> name = response.extract().path("data.findAll{it.name == 'St Cloud'}");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The Value Of The Store Where Store NameS tCloud: " + name);
        System.out.println("------------------End of Test---------------------------");
    }

    //8. Get the address of the store where store name = Rochester
    @Test
    public void test008GetTheAddressOfTheStoreWhereStoreNameRochester() {
        String address = response.extract().path("data[8].address");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The first product name is : " + address);
    }

    //9. Get all the services of 8th store
    @Test
    public void test009GetAllTheServicesOf8thStore() {
        List<Integer> listOfServices = response.extract().path("data[8].services");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("List of all services of 08th stores are : " + listOfServices);
        System.out.println("------------------End of Test---------------------------");
    }

    //10. Get storeservices of the store where service name = Windows Store
    @Test
    public void test011GetAllTheStoreIdOfAllTheStore() {
        List<Integer> serviceName = response.extract().path("data.storeservices");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("List of Ids are : " + serviceName);
        System.out.println("------------------End of Test---------------------------");

    }

    //11. Get all the storeId of all the store
    @Test
    public void test0011storeId() {
        List<Integer> storeOfIds = response.extract().path("data.findAll.services.findAll.storeservices.storeId");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("List of store Ids are : " + storeOfIds);
        System.out.println("------------------End of Test---------------------------");
    }

    //12. Get id of all the store
    @Test
    public void test0012Id() {
        List<Integer> allStoreId = response.extract().path("data.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("List of store Ids are : " + allStoreId);
        System.out.println("------------------End of Test---------------------------");
    }

//13. Find the store names Where state = ND

    @Test
    public void test0013storeNameND() {
        List<String> storeNameNd = response.extract().path("data.findAll{it.state=='ND'}.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("List of store storeName is= : " + storeNameNd);
        System.out.println("------------------End of Test---------------------------");
    }

    //14. Find the Total number of services for the store where store name = Rochester
    @Test
    public void test0014storeNameND() {
        int totalNoOfServices = response.extract().path("data.findAll{it.name='Rochester'}.services.size");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Total number of services : " + totalNoOfServices);
        System.out.println("------------------End of Test---------------------------");
    }

    //15. Find the createdAt for all services whose name = “ Windows Store”
    @Test
    public void test0015serviceNameWindowStore() {
        List<String> totalNoOfServices = response.extract().path("data.findAll{it.name='Windows Store'}.createdAt");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("createdAt for all services of Windows Store : " + totalNoOfServices);
        System.out.println("------------------End of Test---------------------------");
    }

    //   16. Find the name of all services Where store name = “Fargo”
    @Test
    public void test0016serviceNameFargo() {
        List<String> totalNoOfServices = response.extract().path("data.findAll{it.name='Fargo'}.services.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("createdAt for all services of Windows Store : " + totalNoOfServices);
        System.out.println("------------------End of Test---------------------------");
    }

    //   17. Find the zip of all the store
    @Test
    public void test0017zipOfStore() {
        List<String> zipOfAllStrore = response.extract().path("data.zip");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println(" zip of all the store : " + zipOfAllStrore);
        System.out.println("------------------End of Test---------------------------");
    }

    //18. Find the zip of store name = Roseville
    @Test
    public void test0018zipOfStoreNameRoseville() {
        List<String> totalNoOfServices = response.extract().path("data.findAll{it.name=='Roseville'}.zip");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("zip of store name: " + totalNoOfServices);
        System.out.println("------------------End of Test---------------------------");
    }

    //19. Find the storeservices details of the service name = Magnolia Home Theater
    @Test
    public void test0019storeSercicesOfMagnoliaHomeTheater() {
        List<Double> sercicesOfMagnoliaHomeTheater = response.extract().path("data.findAll{it.name=='Magnolia Home Theater'}.storeservices");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("storeservices details of the service name = Magnolia Home Theater: " + sercicesOfMagnoliaHomeTheater);
        System.out.println("------------------End of Test---------------------------");
    }

    //20. Find the lat of all the stores  Write
    @Test
    public void test20latofallthestoresWrite() {
        List<String> storesWrite = response.extract().path("data.lat");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("lat of all the stores  Write: " + storesWrite);
        System.out.println("------------------End of Test---------------------------");
    }

}
