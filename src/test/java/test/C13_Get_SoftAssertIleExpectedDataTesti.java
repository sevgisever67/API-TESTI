package test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C13_Get_SoftAssertIleExpectedDataTesti {

    /*
            http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request
           gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.
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
    public void get01() {
        String url = "http://dummy.restapiexample.com/api/v1/employee/3";

        //Expected
        JSONObject expectedData = new JSONObject();
        expectedData.put("status", "success");
        expectedData.put("id", 3);
        expectedData.put("employee_name", "Ashton Cox");
        expectedData.put("employee_salary", 86000);
        expectedData.put("employee_age", 66);
        expectedData.put("profile_image", "");

        JSONObject expectedOutor = new JSONObject();
        expectedOutor.put("status", "success");
        expectedOutor.put("data", expectedData);
        expectedOutor.put("message", "Successfully! Record has been fetched.");

        Response actualData = given().when().get(url);


        JsonPath jsonPath = actualData.jsonPath();
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(jsonPath.get("status"),expectedOutor.get("status"));
        softAssert.assertEquals(jsonPath.get("data.employee_name"),expectedOutor.getJSONObject("data").get("employee_name"));



    }

}
