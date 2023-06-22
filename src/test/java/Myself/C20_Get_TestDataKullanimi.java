package Myself;

import baseUrl.DummyBaseURL;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testData.TestDataDummy;
import static io.restassured.RestAssured.given;


public class C20_Get_TestDataKullanimi extends DummyBaseURL {
    /*

        http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request
        gonderdigimizde donen response’un status code’unun 200, content Type’inin
        application/json ve body’sinin asagidaki gibi oldugunu test edin.
        Response Body
        {
        "status": "success",
        "data": {
        "id": 3,
        "employee_name": "Ashton Cox",
        "employee_salary": 86000,
        "employee_age": 66,
        "profile_image": ""
        },
        "message": "Successfully! Record has been fetched."
        }
     */

    @Test
    public void get01(){
        //1 url ve request body hazırla
        specDummy.pathParams("pp1","api","pp2","v1","pp3","employee","pp4",3);

        // 2 expected

        JSONObject data=new JSONObject();
        data.put("id", 3);
        data.put("employee_name", "Ashton Cox");
        data.put("employee_salary", 86000);
        data.put("employee_age", 66);
        data.put("profile_image", "");

        JSONObject expectedBody=new JSONObject();
        expectedBody.put("status", "success");
        expectedBody.put("data",data);
        expectedBody.put("message", "Successfully! Record has been fetched.");


        // 3 Response kaydet
        Response response=given().spec(specDummy)
                .when().get("/{pp1}/{pp2}/{pp3}/{pp4}");


        response.prettyPrint();

        TestDataDummy testDataDummy=new TestDataDummy();
        JsonPath resJP=response.jsonPath();
        Assert.assertEquals(testDataDummy.basariliStatusCode,response.getStatusCode());
        Assert.assertEquals(testDataDummy.contentType,response.getContentType());
        Assert.assertEquals(expectedBody.getJSONObject("data").get("id"),resJP.get("data.id"));
        Assert.assertEquals(expectedBody.getJSONObject("data").get("employee_age"),resJP.get("data.employee_age"));
     //   Assert.assertEquals(expectedBody.getJSONObject("data").get("profile_image"),resJP.get("data.profile_image"));














    }

}
