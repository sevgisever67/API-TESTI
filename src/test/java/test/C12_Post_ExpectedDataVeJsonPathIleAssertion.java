package test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

public class C12_Post_ExpectedDataVeJsonPathIleAssertion {
    /*
    https://restful-booker.herokuapp.com/booking url’ine
    asagidaki body'ye sahip bir POST request gonderdigimizde
    donen response’un id disinda asagidaki gibi oldugunu test edin.
                        Request body
                   {
                        "firstname" : "Ahmet",
                        "lastname" : “Bulut",
                        "totalprice" : 500,
                        "depositpaid" : false,
                        "bookingdates" : {
                                 "checkin" : "2021-06-01",
                                 "checkout" : "2021-06-10"
                                          },
                        "additionalneeds" : "wi-fi"
                    }
                        Response Body - Expected Body
                   {
                    "bookingid":24,
                    "booking":{
                        "firstname":"Ahmet",
                        "lastname":"Bulut",
                        "totalprice":500,
                        "depositpaid":false,
                        "bookingdates":{
                            "checkin":"2021-06-01",
                            "checkout":"2021-06-10"
                                        }
                        ,
                        "additionalneeds":"wi-fi"
                             }
                    }
*/

    @Test
    public void get() {


     // 1 url ve request body hazırla
        String url="https://restful-booker.herokuapp.com/booking";

        JSONObject bookingdate=new JSONObject();
        bookingdate.put( "checkin" , "2021-06-01");
        bookingdate.put(   "checkout" , "2021-06-10");

        JSONObject requestBody=new JSONObject() ;
        requestBody.put("firstname" , "Ahmet");
        requestBody.put("lastname" , "Bulut");
        requestBody.put( "totalprice" , 500);
        requestBody.put("depositpaid" , false);
        requestBody.put("bookingdates",bookingdate);
        requestBody.put("additionalneeds","wi-fi");


        // 2 Expected Datayı hazırla

        JSONObject expectedData=new JSONObject();
        JSONObject exBookingdate=new JSONObject();
        exBookingdate.put( "checkin" , "2021-06-01");
        exBookingdate.put(   "checkout" , "2021-06-10");


        expectedData.put( "bookingid",24);
        expectedData.put("firstname" , "Ahmet");
        expectedData.put("lastname" , "Bulut");
        expectedData.put( "totalprice" , 500);
        expectedData.put("depositpaid" , false);
        expectedData.put("bookingdates",exBookingdate);
        expectedData.put("additionalneeds","wi-fi");


        // 3 sorguyu yap ve kaydet
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .body(requestBody.toString())
                .post(url);

        response.prettyPrint();


        JsonPath resJP=response.jsonPath();
        assertEquals(expectedData.getJSONObject("booking").get("firstname"),resJP.get("booking.firstname"));

        // 3 Assertion yap



    }
}
