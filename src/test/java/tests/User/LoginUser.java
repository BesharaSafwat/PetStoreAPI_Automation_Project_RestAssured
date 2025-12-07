package tests.User;

import io.restassured.RestAssured;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;
import tests.BaseTest;

public class LoginUser extends BaseTest {

    @Test
    public void verifyValidLoginUser(){
        String username = CreateUser.username;
        String password = CreateUser.password;

        RestAssured.given().log().all()
                .queryParam("username",username)
                .queryParam("password",password)
                .when().get("user/login")
                .then().log().all().assertThat().statusCode(200)
                .body("message", containsString("logged in"));
    }

    @Test
    public void verifyInvalidLoginUser(){
        String username = "invalid_username";
        String password = "invalid_password";

        RestAssured.given().log().all()
                .queryParam("username",username)
                .queryParam("password",password)
                .header("Content-type", "application/json")
                .when().get("user/login")
                .then().log().all().assertThat().statusCode(405);
    }
}
