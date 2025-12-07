package tests.Store;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import tests.BaseTest;
import tests.Pet.AddPet;

import java.time.LocalDateTime;

import static org.hamcrest.Matchers.equalTo;

public class SetOrder extends BaseTest {

    public static int orderID = 12;

    @Test
    public void verifySuccessfulSetOrder(){

        String orderDateAndTime =  LocalDateTime.now().toString();
        int petID = AddPet.petID;
        RestAssured.given().log().all()
                .body("{\n" +
                        "  \"id\":"+orderID+",\n" +
                        "  \"petId\": "+petID+",\n" +
                        "  \"quantity\": 1,\n" +
                        "  \"shipDate\": \""+orderDateAndTime+"\",\n" +
                        "  \"status\": \"placed\",\n" +
                        "  \"complete\": true\n" +
                        "}")
                .header("Content-Type","application/json")
                .when().post("/store/order")
                .then().log().all().assertThat().statusCode(200)
                .body("status",equalTo("placed"))
                .body("id",equalTo(orderID));
    }

    @Test
    public void verifySetOrderWithEmptyBody(){

        RestAssured.given().log().all()
                .body("{}")
                .header("Content-Type","application/json")
                .when().post("/store/order")
                .then().log().all().assertThat().statusCode(400);
    }
}
