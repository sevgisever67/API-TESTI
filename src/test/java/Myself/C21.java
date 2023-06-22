package Myself;

import baseUrl.HerokuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import testData.TestDataHerokuapp;
import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class C21 extends HerokuAppBaseUrl {
      /*
    https://restful-booker.herokuapp.com/booking url’ine asagidaki body'ye sahip
    bir POST request gonderdigimizde donen response’un status kodunu ve id haric
    body'sinin asagidaki gibi oldugunu test edin.
    Request body
          {
          "firstname" : "Ali",
          "lastname" : “Bak",
          "totalprice" : 500,
          "depositpaid" : false,
          "bookingdates" : {
                      "checkin" : "2021-06-01",
                      "checkout" : "2021-06-10"
                        },
          "additionalneeds" : "wi-fi"
           }
    Expected Body
    {
    "bookingid":24,
    "booking":{
            "firstname":"Ali",
            "lastname":"Bak",
            "totalprice":500,
            "depositpaid":false,
            "bookingdates":{
                            "checkin":"2021-06-01",
                            "checkout":"2021-06-10"
                            },
            "additionalneeds":"wi-fi"
               }
    }
     */

    @Test
    public void post01() {
        // 1 url ve requesy body
        specHerokuApp.pathParam("pp1","booking");
        TestDataHerokuapp testDataHerokuapp=new TestDataHerokuapp();
        JSONObject reguestBody=testDataHerokuapp.bookingOlusturJSON();

        // 2 Exprcted olustur
        JSONObject expBody=testDataHerokuapp.expectedBodyOlusturJSON();

        // 3 Response yi kaydet
        Response response=given()
                .spec(specHerokuApp)
                .contentType(ContentType.JSON)
                .when()
                .body(reguestBody.toString())
                .post("/{pp1}");

        response.prettyPrint();


        // 4 Assertions
        JsonPath rspJP=response.jsonPath();
        assertEquals(expBody.getJSONObject("booking").get("firstname"),rspJP.get("booking.firstname"));
        assertEquals(testDataHerokuapp.basariliStatusCode,response.getStatusCode());


    }
}