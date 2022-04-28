package PutRequests;

import Models.RequestModels.ProductAPIModel;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class updateProductWithSerializedBody {

    @Test
    public void updatProductSerializedBody()
    {
        String endPoint = "http://localhost:81/api_testing2/product/update.php";
        ProductAPIModel product= new ProductAPIModel(19 , "Creatine-MaxMuscle" ,
             "This is a gym product for men to be used after working out",   15 , 4);
        given().body(product).when().put(endPoint).then().log().body();
    }
}
