package Challenges;

import BodyObjects.productBodyObject;
import Models.RequestModels.ProductAPIModel;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class CRUD_Product {

    @Test
    public void createNewProduct()
    {
        String resourceEndpoint = "http://localhost:81/api_testing2/product/create.php";
        productBodyObject productBody =new productBodyObject();
        ProductAPIModel productAPISerialized = productBody.creatNewProduct("sweatBand",
                "this is a stuff for the head",3 , 6);
        var response = given().body(productAPISerialized).when().post(resourceEndpoint).then();
        response.log().body();

    }

    @Test
    public void updateProduct()
    {
        String resourceEndpoint = "http://localhost:81/api_testing2/product/update.php";
        productBodyObject productBody = new productBodyObject();
        ProductAPIModel productAPISerialized = productBody.updateProduct(24 , "sweatBand" ,
                "this is a stuff for the head" ,10, 1 );
        var response = given().body(productAPISerialized).when().put(resourceEndpoint).then();
        response.log().body();
    }

    @Test
    public void getProduct()
    {
        String resourceEndpoint =  "http://localhost:81/api_testing2/product/read_one.php";
      var response=   given().queryParam("id", 24).when().get(resourceEndpoint)
              .then().assertThat().statusCode(200)
              .body("id",equalTo("24"))
              .body("name" , containsString("Band"))
              .body("description" , equalTo("this is a stuff for the head"))
              .body("price", equalTo("10.00"))
              .body("category_id", equalTo("1"));

    }

    @Test
    public void deleteProduct()
    {
        String resourceEndPoint = "http://localhost:81/api_testing2/product/delete.php";
        ProductAPIModel productBody = new ProductAPIModel(23);
        given().body(productBody).when().delete(resourceEndPoint).then().log().body();
    }
}
