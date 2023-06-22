package Myself;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C14_Put_SoftAssertIleExpectedDataTesti {

  /*
    https://dummy.restapiexample.com/api/v1/update/21 url’ine asagidaki
    body’ye sahip bir PUT request gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.

            Request Body
            {
                "status":"success",
                "data":{
                        "name":"Ahmet",
                        "salary":"1230",
                        "age":"44",
                        "id":40
                        }
            }

            Response Body

            {
            "status":"success",
            "data":{
                "status":"success",
                "data":{
                        "name":"Ahmet",
                        "salary":"1230",
                        "age":"44",
                        "id":40
                        }
                   },
            "message":"Successfully! Record has been updated."
            }
                 */

    @Test
    public void put01(){

        // 1 - Url ve Request Body hazirla

        String url = "https://dummy.restapiexample.com/api/v1/update/21";

        /*

         */

        JSONObject data = new JSONObject();
        data.put("name","Ahmet");
        data.put("salary","1230");
        data.put("age","44");
        data.put("id",40);

        JSONObject requestBody=new JSONObject();
        requestBody.put("status","success");
        requestBody.put("data",data);

        // 2 Expected datayı hazırla
        /*
         {
            "status":"success",
            "data":{
                "status":"success",
                "data":{
                        "name":"Ahmet",
                        "salary":"1230",
                        "age":"44",
                        "id":40
                        }
                   },
            "message":"Successfully! Record has been updated."
            }
         */


        JSONObject expectedData=new JSONObject();
        expectedData.put("status","success");
        expectedData.put("data",requestBody);
        expectedData.put("message","Successfully! Record has been updated.");

        // 3 Response i kaydet

        Response response=given()
                .contentType(ContentType.JSON)
                .when().body(requestBody.toString())
                .put(url);

        response.prettyPrint();

        // 4 Assertions


        JsonPath jsonPath=response.jsonPath();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(jsonPath.get("status"),expectedData.get("status"));
        softAssert.assertEquals(jsonPath.get("data.data.name"),
                expectedData.getJSONObject("data")
                            .getJSONObject("data").get("name"));


        softAssert.assertEquals(jsonPath.get("message"),expectedData.get("message"));
        softAssert.assertAll();




    }
}
