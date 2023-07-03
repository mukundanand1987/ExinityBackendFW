package Actions;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class BaseClass {

    String env;
    public Response get( String URL){
        RestAssured.baseURI=URL;
        RequestSpecification request=RestAssured.given();
        Response response = request.get();
        return response;
    }

    public String fetchFileDetails(String fileLocation) throws IOException {
        String resultFromJsonFile = new String(Files.readAllBytes(Paths.get(fileLocation)));
        return resultFromJsonFile;
    }

   public Response post(String URL, String postPayload){
    RestAssured.baseURI =URL;
    RequestSpecification request = RestAssured.given();
    request.header("Content-Type", "application/json");
    request.body(postPayload);
    Response response=request.post();
    return response;
}

    public Response update(String URL, String postPayload){
        RestAssured.baseURI =URL;
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.body(postPayload);
        Response response=request.put();
        return response;
    }

public Response delete(String URL){
    RestAssured.baseURI =URL;
    RequestSpecification request=RestAssured.given();
    Response response = request.delete();
    return response;
}


    @Test
    public String fetchJsonAttributeValue() {
        try (InputStream input = new FileInputStream("src/test/resources/environment-sit.properties")) {

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            System.out.println(prop.getProperty("env"));
            env=prop.getProperty("env");
            return env;

        } catch (IOException ex) {
            ex.printStackTrace();
            return "Unable to fetch URL";
        }

    }


}
