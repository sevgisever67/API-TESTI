package test;

import org.json.JSONObject;
import org.junit.Test;

public class C3_JsonObjesiOlusturma {
    /*
    Asagidaki JSON Objesini olusturup konsolda yazdirin.
    {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":1
    }
    */

    @Test
    public void jsonOject() {
        JSONObject ilkjJsonObject = new JSONObject();

        ilkjJsonObject.put("title", "Ahmet");
        ilkjJsonObject.put("body", "Merhaba");
        ilkjJsonObject.put("userId", 1);

        System.out.println(ilkjJsonObject);

    }

    @Test
    public void nestedJsonOject() {

        /*
                {
                 "firstname":"Jim",
                 "additionalneeds":"Breakfast",
                 "bookingdates":{
                         "checkin":"2018-01-01",
                         "checkout":"2019-01-01"
                    },
                  "totalprice":111,
                  "depositpaid":true,
                  "lastname":"Brown"
                  }
         */

        JSONObject bookingInnerJson=new JSONObject();
        bookingInnerJson.put( "checkin","2018-01-01");
        bookingInnerJson.put( "checkout","2019-01-01");

        JSONObject bookingOuther=new JSONObject();
        bookingOuther.put( "firstname","Jim");
        bookingOuther.put(  "additionalneeds","Breakfast");
        bookingOuther.put( "totalprice",111);
        bookingOuther.put( "depositpaid",true);
        bookingOuther.put("lastname","Brown");
        bookingOuther.put("bookingdates",bookingInnerJson);










    }
}
