package tests.Store;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import tests.BaseTest;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class DeleteOrder extends BaseTest {

    @Test
    public void verifyValidDeleteOrder(){
        int orderID = SetOrder.orderID;

        RestAssured.given().log().all()
                .when().delete("store/order/"+orderID)
                .then().log().all().assertThat().statusCode(200)
                .body("message",equalTo(String.valueOf(orderID)));
    }

    @Test
    public void verifyDeleteInvalidOrderID(){

        RestAssured.given().log().all()
                .when().delete("store/order/"+15015190)
                .then().log().all().assertThat().statusCode(404)
                .body("message",equalTo("Order Not Found"));
    }
    @Test
    public void verifyDeleteStringOrderID(){

        RestAssured.given().log().all()
                .when().delete("store/order/"+"invalid")
                .then().log().all().assertThat().statusCode(404)
                .body("message",containsString("NumberFormatException"));
    }

    @Test
    public void verifyDeleteSameOrderID(){
        int orderID = SetOrder.orderID;

        RestAssured.given().log().all()
                .when().delete("store/order/"+orderID)
                .then().log().all().assertThat().statusCode(404)
                .body("message",equalTo("Order Not Found"));

    }
}
