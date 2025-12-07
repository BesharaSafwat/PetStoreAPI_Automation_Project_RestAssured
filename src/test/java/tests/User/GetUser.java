package tests.User;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import tests.BaseTest;

import static org.hamcrest.Matchers.*;

public class GetUser extends BaseTest {

    @Test
    public void verifyGetUser(){
        String username = CreateUser.username;

        RestAssured.given().log().all()
                .header("Content-type", "application/json")
                .when().get("user/"+username)
                .then().log().all().assertThat().statusCode(200)
                .body("username",equalTo(username));
    }

    @Test
    public void verifyGetInvalidUser(){
        String username = "invalid_username";

        RestAssured.given().log().all()
                .header("Content-type", "application/json")
                .when().get("user/"+username)
                .then().log().all().assertThat().statusCode(404)
                .body("message",equalTo("User not found"));
    }
}
