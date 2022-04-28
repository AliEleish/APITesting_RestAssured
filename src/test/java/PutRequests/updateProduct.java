package PutRequests;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class updateProduct {

    private JSONObject requestPayLoad = new JSONObject();

    @Test
    public void updateSpecificProduct()
    {
        String endPoint = "http://localhost:81/api_testing2/product/update.php";
        requestPayLoad.put("id",21);
        requestPayLoad.put("name","POLO T-Shirt");
        requestPayLoad.put("description","cool men T-shirt for casual occassions");
        requestPayLoad.put("price",200);
        requestPayLoad.put("category_id",1);

       var response= given().body(requestPayLoad.toJSONString()).when().put(endPoint).then();
       response.log().body();
    }

}
