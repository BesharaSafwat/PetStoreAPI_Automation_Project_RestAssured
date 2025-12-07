package tests.Pet;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import tests.BaseTest;
import tests.Store.SetOrder;

import static org.hamcrest.Matchers.equalTo;

public class AddPet extends BaseTest {

    public static int petID = 1234;

    @Test
    public void verifyAddPetWithValidInput(){

        RestAssured.given().log().all()
                .body("{\n" +
                        "  \"id\":"+petID+",\n" +
                        "  \"category\": {\n" +
                        "    \"id\": 0,\n" +
                        "    \"name\": \"string\"\n" +
                        "  },\n" +
                        "  \"name\": \"doggie\",\n" +
                        "  \"photoUrls\": [\n" +
                        "    \"string\"\n" +
                        "  ],\n" +
                        "  \"tags\": [\n" +
                        "    {\n" +
                        "      \"id\": 0,\n" +
                        "      \"name\": \"string\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"status\": \"available\"\n" +
                        "}")
                .header("Content-type", "application/json")
                .when().post("pet")
                .then().log().all().assertThat().statusCode(200)
                .body("id",equalTo(petID));
    }

    @Test
    public void verifyAddPetWithInvalidInput(){

        RestAssured.given().log().all()
                .body("{\n" +
                        "  \"id\": ,\n" +
                        "  \"category\": {\n" +
                        "    \"id\": 0,\n" +
                        "    \"name\": \"string\"\n" +
                        "  },\n" +
                        "  \"name\": \"doggie\",\n" +
                        "  \"photoUrls\": [\n" +
                        "    \"string\"\n" +
                        "  ],\n" +
                        "  \"tags\": [\n" +
                        "    {\n" +
                        "      \"id\": 0,\n" +
                        "      \"name\": \"string\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"status\": \"available\"\n" +
                        "}")
                .header("Content-type", "application/json")
                .when().post("pet")
                .then().log().all().assertThat().statusCode(400)
                .body("message",equalTo("baf input"));
    }

}
