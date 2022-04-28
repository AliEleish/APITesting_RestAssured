package APIsBody;

import org.json.simple.JSONObject;

public class createProductBody {
   private static JSONObject productAPIBody = new JSONObject();

   //used to send POST API
    public static JSONObject getAPIBody(String name , String description,String price ,String category_id)
    {
        productAPIBody.put("name",name);
        productAPIBody.put("description",description);
        productAPIBody.put("price",price);
        productAPIBody.put("category_id",category_id);

       return productAPIBody;
    }
}
