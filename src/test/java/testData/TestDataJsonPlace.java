package testData;

import org.json.JSONObject;

public class TestDataJsonPlace {
    public int basarilistatusKod=200;
    public String contentType="application/json";
    public String connectionHeader="keep-alive";

    public  JSONObject expectedDataOlusturJson(){

        JSONObject expData = new JSONObject();
        expData.put("userId",3);
        expData.put("id",22);
        expData.put("title","dolor sint quo a velit explicabo quia nam");
        expData.put("body","eos qui et ipsum ipsam suscipit aut" +
                "\nsed omnis non odio\nexpedita earum mollitia " +
                "molestiae aut atque rem suscipit\nnam impedit esse");

        return expData;
    }

    public  JSONObject requestBodyOlusturJson(){

        JSONObject rquestBody=new JSONObject();
        rquestBody.put("title","Ali");
        rquestBody.put( "body","Merhaba");
        rquestBody.put("userId",10);
        rquestBody.put( "id",70);
        return rquestBody;
    }


}
