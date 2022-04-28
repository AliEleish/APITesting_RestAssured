package BodyObjects;

import Models.RequestModels.ProductAPIModel;

public class productBodyObject {
    ProductAPIModel productBodyObject = new ProductAPIModel();

    public ProductAPIModel creatNewProduct(String name , String description , double price , int categoryID)
    {
        productBodyObject.setName(name);
        productBodyObject.setDescription(description);
        productBodyObject.setPrice(price);
        productBodyObject.setCategory_id(categoryID);

        return productBodyObject;
    }

    public ProductAPIModel updateProduct(int id, String name , String description , double price , int categoryID)
    {
        productBodyObject.setId(id);
        productBodyObject.setName(name);
        productBodyObject.setDescription(description);
        productBodyObject.setPrice(price);
        productBodyObject.setCategory_id(categoryID);

        return productBodyObject;
    }
}
