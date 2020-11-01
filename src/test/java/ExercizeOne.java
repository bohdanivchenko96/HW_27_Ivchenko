import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.regex.Pattern;

import static com.google.common.base.CharMatcher.isNot;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ExercizeOne {

    @Test
    private void getAllEmployeesPositiveTest() {
        given().log().all()
                .when()
                .get("http://dummy.restapiexample.com/api/v1/employees")
                .then()
                .log().all()
                .statusCode(200)
                .assertThat()
                .body("status", equalTo("success"))
                .body("data.employee_name", hasItems("Sonya Frost"))
                .body("data.employee_age", instanceOf(ArrayList.class));

    }
    @Test
    private void getAllEmployeesNegativeTest() {
        given().log().all()
                .when()
                .get("http://dummy.restapiexample.com/api/v2/employees")
                .then()
                .log().all()
                .statusCode(404);

    }
}
