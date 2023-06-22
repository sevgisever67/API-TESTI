package test;

import baseUrl.JsonPlaceHolderBaseURL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testData.TestDataJsonPlace;

import static io.restassured.RestAssured.given;

public class C18_Get_TestDataClassKullanimi extends JsonPlaceHolderBaseURL {
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
    public  void get01(){
        // 1 url
        specJsonPlace.pathParams("pp1","posts","pp2",22);

        // 2 Expected data hazırla
        TestDataJsonPlace testDataJsonPlace=new TestDataJsonPlace();
        JSONObject expectedData=testDataJsonPlace.expectedDataOlusturJson();

        // 3
        Response response=given().spec(specJsonPlace).when().get("/{pp1}/{pp2}");

        // 4 Assertion
        JsonPath jsonPath=response.jsonPath();
        //Assert.assertEquals(testDataJsonPlace.basarilistatusKod,);
        Assert.assertEquals(expectedData.get("userId"),jsonPath.get("userId"));








    }

}
