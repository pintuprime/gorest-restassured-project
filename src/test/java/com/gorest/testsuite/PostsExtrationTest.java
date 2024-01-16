package com.gorest.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class PostsExtrationTest {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://gorest.co.in";
        response = given()
                .when()
                .get("/public/v2/posts?page=1&per_page=25")
                .then().statusCode(200);
    }

//1. Extract the title
@Test
public void test001() {

    List<Integer> title = response.extract().path("title");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println(" Extract the title: " + title);
    System.out.println("------------------End of Test---------------------------");
}
//2. Extract the total number of record
@Test
public void test002() {

    int totalRecord =  response.extract().path("size()");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The total number of record is : " + totalRecord);
    System.out.println("------------------End of Test---------------------------");

}
//3. Extract the body of 15th record
@Test
public void test003() {

    String body = response.extract().path("[14].body");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The body of 15th record is : " + body);
    System.out.println("------------------End of Test---------------------------");
}
//4. Extract the user_id of all the records
@Test
public void test004() {

    List<Integer> id = response.extract().path("user_id");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println(" Extract the user_id of all the records: " + id);
    System.out.println("------------------End of Test---------------------------");
}
//5. Extract the title of all the records
@Test
public void test005() {

    List<Integer> title = response.extract().path("title");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("  Extract the title of all the records: " + title);
    System.out.println("------------------End of Test---------------------------");
}
//6. Extract the title of all records whose user_id = 5914184
@Test
public void test006() {

    List<String> title = response.extract().path("findAll{it.user_id == 5914184}.title");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("  Extract the title of all the records whose user_id = 5914184: " + title);
    System.out.println("------------------End of Test---------------------------");
}
//7. Extract the body of all records whose id = 5914068
@Test
public void test007() {

    List<String> body = response.extract().path("findAll{it.user_id == 5914068}.body");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("Extract the body of all records whose id = 5914068: " + body);
    System.out.println("------------------End of Test---------------------------");
}
}
