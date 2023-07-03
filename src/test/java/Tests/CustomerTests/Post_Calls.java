package Tests.CustomerTests;

import Actions.BaseClass;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Post_Calls extends BaseClass {
    //Website: https://www.toolsqa.com/rest-assured/post-request-using-rest-assured/
    @Test
    void post_Calls_Using_Object_Creation_Payload(){
        //Create the Payload for POST call
        Map<String,Object> map= new HashMap<String,Object>();
        map.put("name","Mukund");
        map.put("job","Engineer");
        JSONObject payload=new JSONObject(map);

        RestAssured.baseURI ="https://reqres.in/api/users";
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.body(payload.toJSONString());
        Response response=request.post();
        System.out.println(response.getStatusCode());
        System.out.println(response.getBody().asString());

        String id=response.body().jsonPath().get("id");
        System.out.println("Id of the created user is :  "+ id);
    }

@Test
void post_Calls_Using_Payload_From_JsonFile() throws IOException {
    String URL ="https://reqres.in/api/users";
    String fileLocation="VerifyPostResponse.json";
    String postPayload=fetchFileDetails(fileLocation);

    Response response= post(URL,postPayload);
    int statusCodeFromResponse =response.getStatusCode();
    Assert.assertEquals(statusCodeFromResponse,201);
}

        }
