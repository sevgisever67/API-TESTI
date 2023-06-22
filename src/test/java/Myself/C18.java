package Myself;

import baseUrl.JsonPlaceHolderBaseURL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testData.TestDataJsonPlace;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

public class C18 extends JsonPlaceHolderBaseURL {
    /*
           https://jsonplaceholder.typicode.com/posts/22 url'ine bir GET
           request yolladigimizda donen response’in status kodunun 200 ve
           response body’sinin asagida verilen ile ayni oldugunu test ediniz
           Response body = Expected Body
           {
           "userId":3,
           "id":22,
           "title":"dolor sint quo a velit explicabo quia nam",
           "body":"eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita ear
           um mollitia molestiae aut atque rem suscipit\nnam impedit esse"
           }
     */
    @Test
    public void get01() {
        // 1 url ve request body hazırla
        specJsonPlace.pathParams("pp1", "posts", "pp2", 22);

        // 2 expected data
        TestDataJsonPlace testDatajson = new TestDataJsonPlace();
        JSONObject expData = testDatajson.expectedBodyOlusturJSON();

        // Response i kaydet
        Response response = given().spec(specJsonPlace).when().get("/{pp1}/{pp2}");
        response.prettyPrint();

        //******** 1. Yol **********//
        response
                .then()
                .assertThat()
                .body("userId", Matchers.equalTo(3))
                .body("id", Matchers.equalTo(22))
                .body("title", Matchers.equalTo("dolor sint quo a velit explicabo quia nam"))
                .body("body", Matchers.equalTo("eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse"));




        //******** 2. Yol **********//
        JsonPath resJP=response.jsonPath();
        assertEquals(testDatajson.basariliStatusCode,response.getStatusCode());
        assertEquals(expData.get("userId"), resJP.get("userId"));
        assertEquals(expData.get("id"), resJP.get("id"));
        assertEquals(expData.get("title"), resJP.get("title"));
        assertEquals(expData.get("body"), resJP.get("body"));
    }
}
