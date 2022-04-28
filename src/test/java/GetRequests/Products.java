package GetRequests;

import Models.RequestModels.ProductAPIModel;
import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Products {


    @Test
    public void getAllProducts()
    {

        String endpoint = "http://localhost:81/api_testing2/product/read.php";
       var response = given().when().get(endpoint).then().log().headers().log().body()
               .assertThat().header("Content-Type", equalTo("application/json; charset=UTF-8"))
               .body("records.size()", greaterThan(0))
               .body("records.name", everyItem(notNullValue()))
               .body("records.id", everyItem(notNullValue()))
               .body("records.description", everyItem(notNullValue()))
               .body("records.price", everyItem(notNullValue()))
               .body("records.category_id", everyItem(notNullValue()))
               .body("records.category_name", everyItem(notNullValue())).
               extract().response();
//                List<String> nameList =  response.jsonPath().getList("records.name");
//                System.out.println(nameList);

//                for (int i=0 ; i < nameList.size() ; i++)
//                {
//                   response.getBody().jso
//                }

//        String responseBodyAsString = response.toString();
//       JsonPath responseJsonPath = JsonPath.from(responseBodyAsString);
//      List<String> nameList =responseJsonPath.getList("records.name");
//      System.out.println(nameList);

    }


    @Test
    public void getSpecificProduct()
    {
        String endpoint = "http://localhost:81/api_testing2/product/read_one.php";
        given().queryParam("id",5).when().get(endpoint).then().log().body();
    }

    @Test
    public void getSpecificProductDeserialized()
    {
        String resourceEndpoint = "http://localhost:81/api_testing2/product/read_one.php";

        ProductAPIModel expectedProductAPIResponse = new ProductAPIModel(5, "Stretchy Dance Pants"
        ,"Whether dancing the samba, mastering a yoga pose, or scaling the climbing wall, our stretchy dance pants, made from 80% organic cotton and 20% Lycra, are the most versatile and comfortable workout pants you’ll ever have the pleasure of wearing.",
                55.00 , 2 , "Active Wear - Women");
        ProductAPIModel actualProductAPIResponse =
                given().param("id",5)
                        .when().get(resourceEndpoint)
                        .as(ProductAPIModel.class);

        assertThat(actualProductAPIResponse , samePropertyValuesAs(expectedProductAPIResponse));
    }
}
