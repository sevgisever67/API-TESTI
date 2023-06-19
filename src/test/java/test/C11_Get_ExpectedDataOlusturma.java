package test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C11_Get_ExpectedDataOlusturma {
    @Test
    public void get01() {
          /*
       https://jsonplaceholder.typicode.com/posts/22 url'ine
       bir GET request yolladigimizda donen response body’sinin
       asagida verilen ile ayni oldugunu test ediniz
       Response body :
      {
      "userId":3,
      "id":22,
      "title":"dolor sint quo a velit explicabo quia nam",
      "body":"eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse"
      }
     */

        // 1 url hazırla
        String url = "https://jsonplaceholder.typicode.com/posts/22";
        // 2 Expected datayı hazırla

        JSONObject expectedData = new JSONObject();
        expectedData.put("userId", 3);
        expectedData.put("id", 22);
        expectedData.put("title", "dolor sint quo a velit explicabo quia nam");
        expectedData.put("body", "eos qui et ipsum ipsam suscipit aut" +
                "\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit" +
                "\nnam impedit esse");


        Response response=given().when().get(url);
        response.prettyPrint();



        JsonPath resJP=response.jsonPath();
        Assert.assertEquals(expectedData.get("userId"),resJP.get("userId"));




    }



}
