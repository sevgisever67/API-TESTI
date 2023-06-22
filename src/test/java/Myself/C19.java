package Myself;

import baseUrl.JsonPlaceHolderBaseURL;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testData.TestDataJsonPlace;

import static io.restassured.RestAssured.given;

public class C19 extends JsonPlaceHolderBaseURL {    /*
    https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki body’e sahip bir PUT
    request yolladigimizda donen response’in
    status kodunun 200, content type’inin “application/json; charset=utf-8”,
    Connection header degerinin “keep-alive”
    ve response body’sinin asagida verilen ile ayni oldugunu test ediniz
    Request Body
        {
        "title":"Ali",
        "body":"Merhaba",
        "userId":10,
        "id":70
        }
    Expected Data
        {
        "title":"Ali",
        "body":"Merhaba",
        "userId":10,
        "id":70
        }
  */
    @Test
    public void put01(){
        // 1
        specJsonPlace.pathParams("pp1","posts","pp2",70);
        TestDataJsonPlace jsonPlace=new TestDataJsonPlace();
        JSONObject requesyBody=jsonPlace.requestBodyOlusturJSON();

        // 2  exp Data
        TestDataJsonPlace jsonPlace2=new TestDataJsonPlace();
        JSONObject expData=jsonPlace.requestBodyOlusturJSON();

        // 3 response koyadet

        Response response=given().spec(specJsonPlace)
                .contentType(ContentType.JSON)
                .when()
                .body(requesyBody.toString())
                .put("/{pp1}/{pp2}");
        response.prettyPrint();

        // 4 Assertions
        JsonPath rspJP=response.jsonPath();
        Assert.assertEquals(jsonPlace.basariliStatusCode,response.getStatusCode());
        Assert.assertEquals(jsonPlace.connectionHeaderDegeri,response.getHeader("Connection"));
        Assert.assertEquals(jsonPlace.contentType,response.getContentType());
        Assert.assertEquals(expData.get("title"),rspJP.get("title"));
    }




}
