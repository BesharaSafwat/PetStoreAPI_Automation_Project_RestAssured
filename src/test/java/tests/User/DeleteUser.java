package tests.User;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import tests.BaseTest;

public class DeleteUser extends BaseTest {

    @Test
    public void verifyDeleteUser(){
        String username = CreateUser.username;
        RestAssured.given().log().all()
                .header("Content-type", "application/json")
                .when().delete("user/"+username)
                .then().log().all().assertThat().statusCode(200);
    }

    @Test
    public void verifyDeleteInvalidUsername(){
        String username = "invalid_username";
        RestAssured.given().log().all()
                .header("Content-type", "application/json")
                .when().delete("user/"+username)
                .then().log().all().assertThat().statusCode(404);
    }

    @Test
    public void verifyDeleteSameUsername(){
        String username = CreateUser.username;
        RestAssured.given().log().all()
                .header("Content-type", "application/json")
                .when().delete("user/"+username)
                .then().log().all().assertThat().statusCode(404);
    }
}
