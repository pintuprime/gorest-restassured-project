package com.gorest.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class UserExtractionTest {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://gorest.co.in";
        response = given()
                .when()
                .get("/public/v2/users?page=1&per_page=20")
                .then().statusCode(200);
    }
//1. Extract the All Ids
@Test
public void test01() {

    List<Integer> allIds = response.extract().path("id");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("List of all Ids are : " + allIds);
    System.out.println("------------------End of Test---------------------------");
}
//2. Extract the all Names
@Test
public void test02() {

    List<Integer> allNames = response.extract().path("name");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("List of all Ids are : " + allNames);
    System.out.println("------------------End of Test---------------------------");
}
//3. Extract the name of 5th object
@Test
public void test03() {

    String name = response.extract().path("[4].name");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The name of 5th object : " + name);
    System.out.println("------------------End of Test---------------------------");
}

//4. Extract the names of all object whose status = inactive
@Test
public void test04() {

    List<String> names = response.extract().path("findAll{it.status == 'inactive'}.name");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The names of all object whose status = inactive : " + names);
    System.out.println("------------------End of Test---------------------------");
}
//5. Extract the gender of all the object whose status = active
@Test
public void test05() {

    List<String> gender = response.extract().path("findAll{it.status == 'active'}.gender");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The  gender of all the object whose status = active : " + gender);
    System.out.println("------------------End of Test---------------------------");
}
//6. Print the names of the object whose gender = female
@Test
public void test06() {

    List<String> genderFemale = response.extract().path("findAll{it.gender == 'female'}.name");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The  gender of all the object whose status = active : " + genderFemale);
    System.out.println("------------------End of Test---------------------------");
}
//7. Get all the emails of the object where status = inactive
@Test
public void test07() {

    List<String> email = response.extract().path("findAll{it.status == 'inactive'}.email");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The emails of the object where status = inactive : " + email);
    System.out.println("------------------End of Test---------------------------");
}
//8. Get the ids of the object where gender = male
@Test
public void test08() {

    List<String> ids = response.extract().path("findAll{it.gender == 'male'}.id");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The  gender of all the object whose status = active : " + ids);
    System.out.println("------------------End of Test---------------------------");
}

//9. Get all the status
@Test
public void test09() {

    List<String> status = response.extract().path("status");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The  gender of all the object whose status = active : " +status);
    System.out.println("------------------End of Test---------------------------");
}
//10. Get email of the object where name = "Amb. Dandapaani Pilla"
@Test
public void test10() {

    List<String> email = response.extract().path("findAll{it.name == 'Amb. Dandapaani Pilla'}.email");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println(" email of the object where name = Amb. Dandapaani Pilla : " + email);
    System.out.println("------------------End of Test---------------------------");
}

//11. Get gender of id = 5914139
@Test
public void test11() {

    List<String> genderId = response.extract().path("findAll{it.id == 5914139}.gender");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The  gender of all the object whose status = active : " + genderId);
    System.out.println("------------------End of Test---------------------------");
}
}
