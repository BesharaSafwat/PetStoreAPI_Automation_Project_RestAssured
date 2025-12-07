package tests.User;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import tests.BaseTest;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

public class CreateUser extends BaseTest {
    public static String username = "beshara_awad";
    public static String password = "12345678";
    public static int userID = 187;

    @Test
    public void verifyCreateUserWithValidInput() {

        RestAssured.given().log().all()
                .body("  {\n" +
                                "    \"id\":"+userID+" ,\n" +
                                "    \"username\":\""+username+"\",\n" +
                                "    \"firstName\": \"ali\",\n" +
                                "    \"lastName\": \"ahmed\",\n" +
                                "    \"email\": \"string@petstore\",\n" +
                                "    \"password\":\""+password+"\",\n" +
                                "    \"phone\": \"010\",\n" +
                                "    \"userStatus\": 0\n"+
                            "}"
                )
                .header("Content-type", "application/json")
                .when().post("user")
                .then().log().all().assertThat().statusCode(200)
                .body("message",equalTo(String.valueOf(187)));


    }
    @Test
    public void verifyCreateUserWithInvalidInput() {
        RestAssured.given().log().all()
                .body(" ")
                .header("Content-type", "application/json")
                .when().post("user")
                .then().log().all().assertThat().statusCode(not(405))
                .body("message",equalTo("no data"));


    }
}
