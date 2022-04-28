package Challenges;

import Models.ResopnseModel.ProductAPIResponseModel;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class getMultivitaminProduct {


    @Test
    public void getMultivitamin() {
        String resourceEndpoint = "http://localhost:81/api_testing2/product/read_one.php";
        ProductAPIResponseModel ProductAPIActualResponseBody =
                given().queryParam("id", 18).when().get(resourceEndpoint).then().assertThat().statusCode(200)
        .header("Content-Type", equalTo("application/json")).extract().as(ProductAPIResponseModel.class);

        Assert.assertEquals(ProductAPIActualResponseBody.getId() , 18);
        Assert.assertEquals(ProductAPIActualResponseBody.getName(),"Multi-Vitamin (90 capsules)");
        Assert.assertEquals(ProductAPIActualResponseBody.getDescription(),"A daily dose of our Multi-Vitamins fulfills a day’s nutritional needs for over 12 vitamins and minerals.");
        Assertions.assertEquals(ProductAPIActualResponseBody.getPrice(), 10.00);
        Assert.assertEquals(ProductAPIActualResponseBody.getCategory_id(),4);
        Assert.assertEquals(ProductAPIActualResponseBody.getCategory_name(),"Supplements");
    }
}
