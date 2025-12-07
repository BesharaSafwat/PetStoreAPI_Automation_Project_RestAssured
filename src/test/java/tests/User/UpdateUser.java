package tests.User;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

public class UpdateUser extends tests.BaseTest {

    @Test
    public void verifyValidUpdateUser() {
        String newFirstname = "ali_ali_ali";
        String newUserID = "98123";

        RestAssured.given().log().all()
                .body("  {\n" +
                        "    \"id\": "+newUserID+",\n" +
                        "    \"username\":\""+CreateUser.username+ "\",\n" +
                        "    \"firstName\": \""+newFirstname+"\",\n" +
                        "    \"lastName\": \"ahmed\",\n" +
                        "    \"email\": \"string@petstore\",\n" +
                        "    \"password\": \"string\",\n" +
                        "    \"phone\": \"01012010090\",\n" +
                        "    \"userStatus\": 0\n" +
                        "  }")
                .header("accept", "application/json")
                .header("Content-type", "application/json")
                .when().put("user/"+CreateUser.username)
                .then().log().all().assertThat().statusCode(200)
                .body("message",equalTo(newUserID));
    }
    @Test
    public void verifyInvalidUpdateUser() {
        String newFirstname = null;
        String newUserID = null;

        RestAssured.given().log().all()
                .body("  {\n" +
                        "    \"id\": "+newUserID+",\n" +
                        "    \"username\":"+CreateUser.username+ ",\n" +
                        "    \"firstName\": \""+newFirstname+"\",\n" +
                        "    \"lastName\": \"ahmed\",\n" +
                        "    \"email\": \"string@petstore\",\n" +
                        "    \"password\": \"string\",\n" +
                        "    \"phone\": \"01012010090\",\n" +
                        "    \"userStatus\": 0\n" +
                        "  }")
                .header("Content-type", "application/json")
                .when().put("user/"+CreateUser.username)
                .then().log().all().assertThat().statusCode(not(200));
    }

}
