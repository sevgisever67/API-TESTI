package test;

import io.restassured.response.Response;
import org.hamcrest.Matchers.*;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C10_Get_ResponseBodyTestiListKullanimi {
    @Test
    public void get() {

        /*
            http://dummy.restapiexample.com/api/v1/employees url'ine bir GET request yolladigimizda
            donen Response'in
            status code'unun 200,
            ve content type'inin application/json,
            ve response body'sindeki
                employees sayisinin 24
                ve employee'lerden birinin "Ashton Cox"
                ve girilen yaslar icinde 61,40 ve 30 degerlerinin oldugunu test edin
            test edin.
     */
        String url = " http://dummy.restapiexample.com/api/v1/employees";
        Response response = given().when().get(url);
        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType("application/json")
                .body("data.id", hasSize(24),  // kaç tane eleman var
                        "data.employee_name", hasItem("Ashton Cox"),  // list dönüyor
                        "data.employee_age", hasItems(61, 30, 40) // list döndürüyor
                );



    }
}

