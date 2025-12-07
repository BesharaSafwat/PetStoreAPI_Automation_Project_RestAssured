package tests.Store;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import tests.BaseTest;

import java.util.Base64;

public class GetAllPets extends BaseTest {

    @Test
    public void verifyValidGetAllPets(){

        RestAssured.given().log().all().when().get("store/inventory")
                .then().log().all().assertThat().statusCode(200);
    }

    @Test
    public void verifyInvalidGetAllPets(){

        RestAssured.given().log().all().when().get("store/")
                .then().log().all().assertThat().statusCode(405);
    }

}
