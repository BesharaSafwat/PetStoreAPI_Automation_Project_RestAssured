package tests.Pet;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import tests.BaseTest;

import static org.hamcrest.Matchers.equalTo;

public class UpdateNameStatus extends BaseTest {

    @Test
    public void verifyUpdateNameStatusWithValidData(){
        int petID = AddPet.petID;

        RestAssured.given().log().all()
                .header("Content-type", "application/x-www-form-urlencoded")
                .formParam("name","fluffy")
                .formParam("status","pending")
                .when().post("pet/"+petID)
                .then().log().all().assertThat().statusCode(200)
                .body("message",equalTo(String.valueOf(petID)));
    }

    @Test
    public void verifyUpdateNameStatusWithInvalidData(){
        int invalidPetID = 147965781;

        RestAssured.given().log().all()
                .header("Content-type", "application/x-www-form-urlencoded")
                .formParam("name","fluffy")
                .formParam("status","pending")
                .when().post("pet/"+invalidPetID)
                .then().log().all().assertThat().statusCode(404)
                .body("message",equalTo("not found"));
    }
}
