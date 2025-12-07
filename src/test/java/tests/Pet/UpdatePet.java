package tests.Pet;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import tests.BaseTest;

import static org.hamcrest.Matchers.equalTo;

public class UpdatePet extends BaseTest {

    @Test
    public void verifyUpdatePetWithValidBody(){
        int petID = AddPet.petID;

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
                .when().put("pet")
                .then().log().all().assertThat().statusCode(200)
                .body("id",equalTo(petID));
    }

    @Test
    public void verifyUpdatePetWithInvalidID(){
        RestAssured.given().log().all()
                .body("{\n" +
                        "  \"id\":\" \",\n" +
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
                .when().put("pet")
                .then().log().all().assertThat().statusCode(400)
                .body("message",equalTo("Invalid ID supplied"));
    }
}
