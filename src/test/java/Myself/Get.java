package Myself;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get {

    @Test
    public void get(){
 /*
                https://restful-booker.herokuapp.com/booking/10 url’ine
                bir GET request gonderdigimizde donen Response’un,
                status code’unun 200,
                ve content type’inin application/json; charset=utf-8,
                ve response body’sindeki
                    "firstname“in,"Jim",
                    ve "lastname“in, "Wilson",
                    ve "totalprice“in, 609,
                    ve "depositpaid“in,false,
                    ve "additionalneeds“in,"Breakfast"
                oldugunu test edin
         */

        String url ="https://restful-booker.herokuapp.com/booking/10";

        Response response=given().when().get(url);
        // Assertionları yap;
        response.then().assertThat().statusCode(200)
                .contentType("application/json; charset=utf-8")
                .body(
                "firstname", Matchers.equalTo("Jim"),
                "lastname",Matchers.equalTo("Wilson"),
                "totalprice",Matchers.equalTo(609),
                "depositpaid",Matchers.equalTo(false),
                "additionalneeds",equals("Breakfast"));





    }
}
