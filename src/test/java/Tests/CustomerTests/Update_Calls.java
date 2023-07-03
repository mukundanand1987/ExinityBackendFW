package Tests.CustomerTests;

import Actions.BaseClass;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class Update_Calls extends BaseClass {
@Test
    void update_Calls() throws IOException {
        String URL ="https://reqres.in/api/users/2";
        String fileLocation="VerifyPutResponse.json";
        String postPayload=fetchFileDetails(fileLocation);

        Response response= update(URL,postPayload);
        int statusCodeFromResponse =response.getStatusCode();
        Assert.assertEquals(statusCodeFromResponse,200);
    }
}
