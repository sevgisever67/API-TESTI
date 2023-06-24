package test;

import baseUrl.DummyBaseURL;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.DummyDataPOJO;
import pojos.DummyExpectedBudyPOJO;

import static io.restassured.RestAssured.given;

public class C27_Get_Pojo_Veda_Classi extends DummyBaseURL {
    /*
    http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request
     gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.
    Response Body
    {
    "status":"success",
    "data":{
            "id":3,
            "employee_name":"Ashton Cox",
            "employee_salary":86000,
            "employee_age":66,
            "profile_image":""
            },
    "message":"Successfully! Record has been fetched."
    }
     */
    @Test
    public void get01() {

        specDummy.pathParams("pp1","api","pp2","v1","pp3","employee","pp4",3);
        DummyDataPOJO data=new DummyDataPOJO(3,"Ashton Cox",86000,66,"");
        DummyExpectedBudyPOJO expBody=new DummyExpectedBudyPOJO("success",data,"Successfully! Record has been fetched.");
        Response response=given()
                .spec(specDummy)
                .when()
                .get("/{pp1}/{pp2}/{pp3}/{pp4}");

        DummyExpectedBudyPOJO resPojo=response.as(DummyExpectedBudyPOJO.class);
        Assert.assertEquals(expBody.getStatus(),resPojo.getStatus());
        Assert.assertEquals(expBody.getMessage(),resPojo.getMessage());
        Assert.assertEquals(expBody.getData().getEmployee_age(),resPojo.getData().getEmployee_age());
    }


}
