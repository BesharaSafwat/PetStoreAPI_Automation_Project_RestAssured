package tests.Pet;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import tests.BaseTest;

import static org.hamcrest.Matchers.*;

public class FindPetByStatus extends BaseTest {

    @Test
    public  void verifyFindPetByValidStatus(){
//        int petID = AddPet.petID;

        RestAssured.given().log().all()
                .queryParam("status","pending")
                .header("Content-type", "application/json")
                .when().get("pet/findByStatus")
                .then().log().all().assertThat().statusCode(200);
    }

    @Test
    public  void verifyFindPetByInvalidStatus(){

        RestAssured.given().log().all()
                .queryParam("status","134")
                .header("Content-type", "application/json")
                .when().get("pet/findByStatus")
                .then().log().all().assertThat().statusCode(not(200));
    }
}
