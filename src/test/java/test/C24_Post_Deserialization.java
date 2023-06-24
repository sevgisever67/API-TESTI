package test;

import baseUrl.HerokuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import netscape.javascript.JSObject;
import org.junit.Test;
import pojos.BookingdatesPOJO;
import pojos.HerokuApRequestBodyPojo;
import pojos.JsonPlaceRequestBodyPOJO;

import static io.restassured.RestAssured.given;

public class C24_Post_Deserialization extends HerokuAppBaseUrl {
    /*
https://restful-booker.herokuapp.com/booking url’ine asagidaki body'ye sahip bir POST
request gonderdigimizde donen response’un id haric asagidaki gibi oldugunu test edin.
Response Body // expected data
{
"bookingid": 24,
"booking": {
"firstname": "Ahmet",
"lastname": "Bulut",
"totalprice": 500,
"depositpaid": false,
"bookingdates": {
"checkin": "2021-06-01",
"checkout": "2021-06-10"
},
"additionalneeds": "wi-fi"
}


}
Request body
{
"firstname" : "Ahmet",
"lastname" : “Bulut",
"totalprice" : ,
"depositpaid" : false,
"bookingdates" : {
"checkin" : "2021-06-01",
"checkout" : "2021-06-10"
},
"additionalneeds" : "wi-fi"
}


     */

    @Test
    public  void post01(){
        // 1 Url Ve Request body hazırla
        specHerokuApp.pathParam("pp1","booking");


        BookingdatesPOJO bookingdates=new BookingdatesPOJO("2021-06-01","2021-06-10");
        HerokuApRequestBodyPojo requestBodyPojo=new HerokuApRequestBodyPojo
                ("Ahmet","Bulut",500,false, bookingdates,"wi-fi");


        Response response=given().spec(specHerokuApp)
                .contentType(ContentType.JSON)
                .when()
                .body(requestBodyPojo)
                .post("/{pp1}");

        response.prettyPrint();
        // 2 - Expected body;






    }


}
