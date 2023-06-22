package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

public class HerokuAppBaseUrl {

    protected RequestSpecification specHerokuApp;

    @BeforeMethod
    public void setup(){

        specHerokuApp =new RequestSpecBuilder()
                .setBaseUri("https://restful-booker.herokuapp.com")
                .build();
    }
}