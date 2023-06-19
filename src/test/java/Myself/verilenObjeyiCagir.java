package Myself;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import java.util.Arrays;

public class verilenObjeyiCagir {
      /*  {
    "firstName": "John",
    "lastName": "doe",
    "age": 26,
    "address": {
        "streetAddress": "naist street",
        "city": "Nara",
        "postalCode": "630-0192"
                },
    "phoneNumbers": [
                    {
                        "type": "iPhone",
                        "number": "0123-4567-8888"
                    },
                    {
                        "type": "home",
                        "number": "0123-4567-8910"
                    }
                    ]
    }
     */@Test
    public void verilenObjeyiCagir(){


        JSONObject address=new JSONObject();
        address.put("streetAddress","naist street");
        address.put( "city", "Nara");
        address.put("postalCode", "630-0192");


          JSONArray arrPhoneNumber=new JSONArray();

          JSONObject cepTel=new JSONObject();
          cepTel.put( "type", "iPhone");
          cepTel.put( "number", "0123-4567-8888");

          JSONObject evTel=new JSONObject();
          evTel.put( "type", "home");
          evTel.put( "number", "0123-4567-8910");

          arrPhoneNumber.put(0,cepTel);
          arrPhoneNumber.put(1,evTel);


          JSONObject kisiselBilgiler=new JSONObject();
          kisiselBilgiler.put("firstName", "John");
          kisiselBilgiler.put("lastName", "doe");
          kisiselBilgiler.put("age", 26);
          kisiselBilgiler.put("address",address);
          kisiselBilgiler.put("phoneNumbers",arrPhoneNumber);


          System.out.println(kisiselBilgiler.get("firstName"));
          System.out.println(kisiselBilgiler.getJSONObject("address").get("city"));
          System.out.println(kisiselBilgiler.getJSONArray("phoneNumbers").getJSONObject(0).get("type"));

          System.out.println(arrPhoneNumber);


      }
}
