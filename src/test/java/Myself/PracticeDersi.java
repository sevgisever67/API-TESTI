package Myself;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import static io.restassured.RestAssured.given;


// 1 - Gonderecegimiz Request icin gerekli olan URL ve ihtiyacimiz varsa Request Body hazirla
//  https://www.heallifehospital.com/api/opdList
// 2 - Eger soruda bize verilmisse Expected Data hazirla
// 3 - Bize donen Response'i Actual Data olarak kaydet
// 4 - Expected Data ile Actual Datayi karsilastirmamiz yani Assertion yapmamiz gerek

public class PracticeDersi {
    //api/opdList endpoint'ine gecerli authorization bilgileri ile bir GET request gönderildiginde
    // dönen status code'un 200 oldugu ve response message bilgisinin "Success" oldugu dogrulanmali
    @Test
    public void test01() {

        // spect ile base url olusştur
        RequestSpecification spec =
                new RequestSpecBuilder().setBaseUri("https://www.heallifehospital.com/").build();

        String token = "BsSCbYy9KwyQ104dq19hK56I3DR5rF";

        spec.pathParams("pp1", "api", "pp2", "opdList");
        String fullPath="/{pp1}/{pp2}";
        Response response = given()
                .contentType(ContentType.JSON)
                .spec(spec)
                .headers("Authorization",
                        "Bearer "+ token,
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON)
                .when()
                .get(fullPath);



    }
}