package Tests.CustomerTests;

import Actions.BaseClass;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Delete_Calls extends BaseClass
{
   @Test
    void delete_Call(){
       String URL="https://reqres.in/api/users?page=1";
       Response response= delete(URL);
      Assert.assertEquals(response.getStatusCode(),204);
   }
}
