package Myself;

import baseUrl.JsonPlaceHolderBaseURL;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.nullValue;

public class BaseUrl extends JsonPlaceHolderBaseURL {
    /*
        1-  https://jsonplaceholder.typicode.com/posts endpointine bir GET
         request gonderdigimizde donen response’un status code’unun 200 oldugunu
         ve Response’ta 100 kayit oldugunu test edin.
        */

    // 1 - Url hazirla

    @Test
    public void get01(){
        specJsonPlace.pathParam("pp1","posts");
        Response response=given().spec(specJsonPlace).when().get("/{pp1}");
     //   response.prettyPrint();

        response
                .then()
                .assertThat()
                .statusCode(200)
                .body("title", Matchers.hasSize(100));

    }
    @Test
    public void get02() {
        /*
        2- https://jsonplaceholder.typicode.com/posts/44 endpointine bir GET
            request gonderdigimizde donen response’un status code’unun 200 oldugunu
            ve “title” degerinin “optio dolor molestias sit” oldugunu test edin
         */

        // 1 - Url hazirla

        specJsonPlace.pathParams("pp1","posts","pp2","44");
        // 2 - Expected Data hazirla


        // 3 - Response'i kaydet


        Response response=given().spec(specJsonPlace).when().get("/{pp1}/{pp2}");

        response
                .then()
                .assertThat()
                .statusCode(200)
                .body("title",Matchers.equalTo("optio dolor molestias sit"));


    }

    @Test
    public void delete01() {
         /*
        3- https://jsonplaceholder.typicode.com/posts/50 endpointine bir DELETE
            request gonderdigimizde donen response’un status code’unun 200 oldugunu ve
            response body’sinin null oldugunu test edin
         */

        // 1 - Url hazirla

        specJsonPlace.pathParams("pp1","posts","pp2",50);

        // responceyi kaydet
        Response response=given().spec(specJsonPlace).when().delete("/{pp1}/{pp2}");
        response
                .then()
                .assertThat()
                .statusCode(200)
                .body("title",nullValue());





    }

    }
