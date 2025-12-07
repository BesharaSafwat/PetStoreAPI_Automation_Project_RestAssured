package tests.Pet;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import tests.BaseTest;

import static org.hamcrest.Matchers.*;

public class FindPetByID extends BaseTest {

    @Test
    public  void verifyFindPetByValidID(){
        int petID = AddPet.petID;

        RestAssured.given().log().all()
                .header("Content-type", "application/json")
                .when().get("pet/"+petID)
                .then().log().all().assertThat().statusCode(200)
                .body("id",equalTo(petID));
    }

    @Test
    public  void verifyFindPetByInvalidID(){
        int invalidPetID = 121089139;

        RestAssured.given().log().all()
                .header("Content-type", "application/json")
                .when().get("pet/"+invalidPetID)
                .then().log().all().assertThat().statusCode(404)
                .body("message",equalTo("Pet not found"));
    }

    @Test
    public  void verifyFindPetByStringID(){

        RestAssured.given().log().all()
                .header("Content-type", "application/json")
                .when().get("pet/"+"invalid")
                .then().log().all().assertThat().statusCode(404)
                .body("message",containsString("NumberFormatException"));
    }
}
