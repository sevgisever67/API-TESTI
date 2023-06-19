package Myself;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import netscape.javascript.JSObject;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PostJsonBody {
  /*
            https://restful-booker.herokuapp.com/booking
            url’ine asagidaki body'ye sahip
            bir POST request gonderdigimizde
                       {
                            "firstname" : "Ali",
                            "lastname" : "Bak",
                            "totalprice" : 500,
                            "depositpaid" : false,
                            "bookingdates" : {
                                            "checkin" : "2021-06-01",
                                            "checkout" : "2021-06-10"
                                             },
                            "additionalneeds" : "wi-fi"
                        }
            donen Response’un,
            status code’unun 200,
            ve content type’inin application/json; charset=utf-8,
            ve response body’sindeki
                "firstname“in,"Ali",
                ve "lastname“in, "Bak",
                ve "totalprice“in,500,
                ve "depositpaid“in,false,
                ve "checkin" tarihinin 2021-06-01
                ve "checkout" tarihinin 2021-06-10
                ve "additionalneeds“in,"wi-fi"
            oldugunu test edin
     */

    @Test
    public  void post(){
        String url="https://restful-booker.herokuapp.com/booking";

        JSONObject bookingDateOBJ=new JSONObject();
        bookingDateOBJ.put("checkin","2021-06-01");
        bookingDateOBJ.put("checkout","2021-06-10");
        JSONObject kisiselBilgiler=new JSONObject();
        kisiselBilgiler.put( "firstname" , "Ali");
        kisiselBilgiler.put("lastname" , "Bak");
        kisiselBilgiler.put("totalprice" , 500);
        kisiselBilgiler.put("depositpaid" , false);
        kisiselBilgiler.put("bookingdates",bookingDateOBJ);
        kisiselBilgiler.put( "additionalneeds" , "wi-fi");

        Response response=given().contentType(ContentType.JSON).when().body(kisiselBilgiler.toString()).post(url);



    }

}
