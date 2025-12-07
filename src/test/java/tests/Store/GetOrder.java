package tests.Store;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import tests.BaseTest;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class GetOrder extends BaseTest {

    @Test
    public void verifySuccessfulGetOrder(){
        int orderID = SetOrder.orderID;

        RestAssured.given().log().all()
                .when().get("store/order/"+orderID)
                .then().log().all().assertThat().statusCode(200)
                .body("id",equalTo(orderID));
    }

    @Test
    public void verifyGetOrderByInvalidOrderID(){

        RestAssured.given().log().all()
                .when().get("store/order/"+1212148813)
                .then().log().all().assertThat().statusCode(404)
                .body("message",equalTo("Order not found"));
    }

    @Test
    public void verifyGetOrderByStringOrderID(){

        RestAssured.given().log().all()
                .when().get("store/order/"+"invalid")
                .then().log().all().assertThat().statusCode(404)
                .body("message",containsString("NumberFormatException"));
    }
}
