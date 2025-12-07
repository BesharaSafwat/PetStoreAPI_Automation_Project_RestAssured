package tests.User;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import tests.BaseTest;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

public class CreateUserWithList extends BaseTest {
    public static String username = "beshara_awad";
    public static String password = "12345678";

    @Test
    public void verifyCreateUserWithValidBody() {
        String validBodyJson = "[\n" +
                "  {\n" +
                "     \"id\": 191,\n" +
                "    \"username\": \"alikamal\",\n" +
                "    \"firstName\": \"ali\",\n" +
                "    \"lastName\": \"kamal\",\n" +
                "    \"email\": \"alikamal@petstore\",\n" +
                "    \"password\": \"string\",\n" +
                "    \"phone\": \"010\",\n" +
                "    \"userStatus\": 0\n" +
                "  }, \n" +
                "  {\n" +
                "     \"id\": 192,\n" +
                "    \"username\": \"ahmedkamal\",\n" +
                "    \"firstName\": \"ahmed\",\n" +
                "    \"lastName\": \"kamal\",\n" +
                "    \"email\": \"a.kamal@petstore\",\n" +
                "    \"password\": \"string\",\n" +
                "    \"phone\": \"011\",\n" +
                "    \"userStatus\": 0\n" +
                "  },  \n" +
                "  {\n" +
                "     \"id\": 193,\n" +
                "    \"username\": \"beshara\",\n" +
                "    \"firstName\": \"beshara\",\n" +
                "    \"lastName\": \"awad\",\n" +
                "    \"email\": \"beshara@petstore\",\n" +
                "    \"password\": \"string\",\n" +
                "    \"phone\": \"015\",\n" +
                "    \"userStatus\": 0\n" +
                "  }\n" +
                "]";

        // Positive Case
        RestAssured.given().log().all()
                .body(validBodyJson)
                .header("Content-type", "application/json")
                .when().post("user/createWithList")
                .then().log().all().assertThat().statusCode(200)
                .body("message",equalTo("ok"));

    }

    @Test
    public void verifyCreateUsersWithEmptyBody(){
        String emptyBodyJson = "[]";

        RestAssured.given().log().all()
                .body(emptyBodyJson)
                .header("Content-type", "application/json")
                .when().post("user/createWithList")
                .then().log().all().assertThat().statusCode(not(200))
                .body("message",not("ok"));
    }
}
