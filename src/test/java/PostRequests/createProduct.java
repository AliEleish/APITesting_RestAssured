package PostRequests;

import APIsBody.createProductBody;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class createProduct {

    @Test
    public void createNewProduct()
    {
        String endPoint = "http://localhost:81/api_testing2/product/create.php";
//        JSONObject body = new JSONObject();
//        body.put("name","Creatine-MonoHydrate");
//        body.put("description","This is a gym product for men to be used after working out");
//        body.put("price","8.00");
//        body.put("category_id","4");
        var response= given().body(createProductBody.getAPIBody("AirMax334","This is a men shoe"
                        , "150" ,"1" ).toJSONString())
                .when().post(endPoint).then();
        response.log().body();

    }
}
