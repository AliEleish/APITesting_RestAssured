package PostRequests;

import Models.RequestModels.ProductAPIModel;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class CreateSerializedProduct {

    @Test
    public void createSerializedProduct()
    {
      String endPoint ="http://localhost:81/api_testing2/product/create.php";
      ProductAPIModel product = new ProductAPIModel("Dijavu bag",
              "This is a Women bag", 300 , 2);
      given().body(product).when().post(endPoint).then().log().body();

    }
}
