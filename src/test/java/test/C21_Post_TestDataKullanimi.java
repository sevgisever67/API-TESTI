package test;



import baseUrl.HerokuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;
import testData.TestDataHerokup;
import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class C21_Post_TestDataKullanimi extends HerokuAppBaseUrl {

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
    public void post01(){
        // 1 url
        specHerokuApp.pathParam("pp1","booking");
        TestDataHerokup testDataHerokup=new TestDataHerokup();
        JSONObject requestBody=testDataHerokup.bookingOlusturJson();

        // 2
        JSONObject expData=testDataHerokup.expectedDataOlusturJson();

        // 3
        Response response=given()
                .spec(specHerokuApp)
                .contentType(ContentType.JSON)
                .when()
                .body(requestBody.toString())
                .post("/{pp1}");

        // 4
        JsonPath respJP=response.jsonPath();


        assertEquals(testDataHerokup.basarilistatusKod, response.getStatusCode());
        assertEquals(expData.getJSONObject("booking").get("firstname"), respJP.get("booking.firstname"));
        assertEquals(expData.getJSONObject("booking").get("lastname"), respJP.get("booking.lastname"));
        assertEquals(expData.getJSONObject("booking").get("totalprice"), respJP.get("booking.totalprice"));
        assertEquals(expData.getJSONObject("booking").get("depositpaid"), respJP.get("booking.depositpaid"));
        assertEquals(expData.getJSONObject("booking").get("additionalneeds"), respJP.get("booking.additionalneeds"));

    }

}
