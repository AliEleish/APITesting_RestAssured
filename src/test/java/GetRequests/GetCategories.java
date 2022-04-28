package GetRequests;

import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetCategories {

    @Test
    public void getAllCategories()
    {
        String endPoint = "http://localhost:81/api_testing2/category/read.php";
        Map<String,String> headers = new HashMap<>();
       // headers.put("Access-Control-Allow-Origin","*");
        headers.put("Content-Type" , "application/json");
       var response= given().headers(headers).when().get(endPoint).then();
       response.log().body();
    }
}
