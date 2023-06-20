package test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C14_Put_SoftAssertIleExpectedDataTesti {

    /*
    https://dummy.restapiexample.com/api/v1/update/21 url’ine asagidaki body’ye sahip bir PUT
       request gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.
       Request Body
       {
       "status": "success",
       "data": {
       "name": “Ahmet",
       "salary": "1230",
       "age": "44",
       "id": 40
       }
       }
       Response Body
       { "status": "success",
       "data": {
       "name": “Ahmet",
       "salary": "1230",
       "age": "44",
       "id": 40 }
       },
"message": "Successfully! Record ha
s been updated."
     */

    @Test
    public void put01() {
        String url = "https://dummy.restapiexample.com/api/v1/update/21";

        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "Ahmet");
        requestBody.put("salary", "1230");
        requestBody.put("age", "44");
        requestBody.put("id", 40);

        // Response Body
        JSONObject expectedData = new JSONObject();
        expectedData.put("status", "success");
        expectedData.put("data", requestBody);
        expectedData.put("message", "Successfully! Record has been updated.");


        // put
        Response actualData = given()
                .contentType(ContentType.JSON).when()
                .body(requestBody.toString()).put(url);

        //
        actualData.prettyPrint();

        JsonPath jsonPath=actualData.jsonPath();
        Assert.assertEquals(jsonPath.get("data.status"),expectedData.getJSONObject("data").get("status"));
      //  Assert.assertEquals(jsonPath.get("data.data.name"),expectedData.getJSONObject("data").get("name"));
    }
}