package DeleteRequests;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class DeleteProduct {

    private JSONObject requestPayLoad = new JSONObject();

    @Test
    public void deleteProduct()
    {
        String endPoint = "http://localhost:81/api_testing2/product/delete.php";
        requestPayLoad.put("id",21);
        var Response = given().body(requestPayLoad.toJSONString()).when()
                .delete(endPoint).then();
        Response.log().body();

    }
}
