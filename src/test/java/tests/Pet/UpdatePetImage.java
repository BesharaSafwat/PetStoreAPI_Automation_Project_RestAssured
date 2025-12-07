package tests.Pet;

import io.restassured.RestAssured;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;
import tests.BaseTest;

import java.io.File;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;

public class UpdatePetImage extends BaseTest {

    @Test
    public void verifyUpdatePetImageWithValidData() {
        int petID = AddPet.petID;

        File petImageFile = new File("src/test/java/resources/petImage1.jpg");
        RestAssured.given().log().all()
                .header("Content-type", "multipart/form-data")
                .multiPart("additionalMetadata","Pet Image 1")
                .multiPart("file", petImageFile)
                .when().post("pet/"+petID+"/uploadImage")
                .then().log().all().assertThat().statusCode(200)
                .body("message", containsString("File uploaded "));
    }

    @Test
    public void verifyUpdatePetImageWithInvalidData() {
        int petID = AddPet.petID;

        File invalidPetImageFile = new File("src/test/java/resources/invalidPetImage.pdf");
        RestAssured.given().log().all()
                .header("Content-type", "multipart/form-data")
                .multiPart("additionalMetadata", "Pet Image 1")
                .multiPart("file", invalidPetImageFile)
                .when().post("pet/" + petID + "/uploadImage")
                .then().log().all().assertThat().statusCode(not(200));
    }

    @Test
    public void verifyUpdatePetImageWithInvalidID() {
        int invalidPetID = 1341414141;

        File invalidPetImageFile = new File("src/test/java/resources/invalidPetImage.pdf");
        RestAssured.given().log().all()
                .header("Content-type", "multipart/form-data")
                .multiPart("additionalMetadata", "Pet Image 1")
                .multiPart("file", invalidPetImageFile)
                .when().post("pet/" + invalidPetID + "/uploadImage")
                .then().log().all().assertThat().statusCode(404)
                .body("message", containsString("not found"));
    }
}
