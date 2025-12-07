package tests.Pet;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import tests.BaseTest;

import static org.hamcrest.Matchers.*;

public class DeletePet extends BaseTest {

    @Test(groups = "delete")
    public void verifyDeletePetByValidID(){
        int petID = AddPet.petID;

        RestAssured.given().log().all()
                .header("Content-type", "application/json")
                .when().delete("pet/"+petID)
                .then().log().all().assertThat().statusCode(200);
    }


    @Test
    public  void verifyDeletePetByInvalidID(){
        int invalidPetID = 121089139;

        RestAssured.given().log().all()
                .header("Content-type", "application/json")
                .when().delete("pet/"+invalidPetID)
                .then().log().all().assertThat().statusCode(404)
                .body("message",equalTo("Pet not found"));
    }

    @Test
    public  void verifyFindPetByStringID(){

        RestAssured.given().log().all()
                .header("Content-type", "application/json")
                .when().delete("pet/"+"invalid")
                .then().log().all().assertThat().statusCode(404)
                .body("message",containsString("NumberFormatException"));
    }


    @Test(dependsOnGroups = "delete")
    public  void verifyFindPetBySameID(){
        int petID = AddPet.petID;

        RestAssured.given().log().all()
                .header("Content-type", "application/json")
                .when().delete("pet/"+petID)
                .then().log().all().assertThat().statusCode(404)
                .body("message",containsString("NumberFormatException"));
    }
}
