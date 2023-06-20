package Myself;

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
        String url="http://dummy.restapiexample.com/api/v1/update/21";

        JSONObject requestBody=new JSONObject();
        requestBody.put("status", "success");
        requestBody.put("name", "Ahmet");
        requestBody.put("salary", "1230");
        requestBody.put("age", "44");
        requestBody.put("id", 40);

        // Response Body
        JSONObject expectedData=new JSONObject();
        expectedData.put("status", "success");
        expectedData.put("name", "Ahmet");
        expectedData.put("salary", "1230");
        expectedData.put("age", "44");
        expectedData.put("id", 40);

        // put
        Response actualData=given()
                .contentType(ContentType.JSON).when()
                .body(requestBody.toString()).put(url);

        //
        actualData.prettyPrint();

    //    JsonPath jsonPath=actualData.jsonPath();
     //   Assert.assertEquals(expectedData.get("status"),jsonPath.get("data.status")

    }
}
