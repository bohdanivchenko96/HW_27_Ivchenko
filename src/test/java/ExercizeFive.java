import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

public class ExercizeFive {
    @Test
    private void positivePostTest() {

        given().log().all()
                .delete("http://dummy.restapiexample.com/api/v1/delete/2")
                .then()
                .log().all()
                .statusCode(200)
                .assertThat()
                .body("status", equalTo("success"))
                .body("data", equalTo("2"))
                .body("message", equalTo("Successfully! Record has been deleted"));

    }
    @Test
    private void negativePostTest() {

        given().log().all()
                .delete("http://dummy.restapiexample.com/api/v1/delete/0")
                .then()
                .log().all()
                .statusCode(400)
                .assertThat()
                .body("status", equalTo("error"))
                .body("errors", equalTo("id is empty"))
                .body("message", equalTo("Not found record"));

    }
}
