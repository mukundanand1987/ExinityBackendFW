package Tests.CustomerTests;

import Actions.BaseClass;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class Get_Calls extends BaseClass {
    @Test
    void testGetResponse(){
        Response response=RestAssured.get("https://reqres.in/api/users?page=2");
        String email=response.body().jsonPath().get("data.email[1]");
        System.out.println("Email of User 2 is :  "+email);
    }
    @Test
    void assertGetResponseAgainstJsonFile() throws IOException {
        String URL="https://reqres.in/api/users?page=2";
        String fileLocation="VerifyGetResponse.json";
        String expectedResponse=fetchFileDetails(fileLocation);
        String resultFromResponse= get(URL).getBody().asString();;//Code to get entire JSON response from Result
        Assert.assertEquals(expectedResponse,resultFromResponse);
    }



    }



