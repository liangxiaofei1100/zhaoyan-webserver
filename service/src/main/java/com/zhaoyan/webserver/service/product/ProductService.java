package com.zhaoyan.webserver.service.product;


import com.zhaoyan.webserver.dao.product.ProductDao;
import com.zhaoyan.webserver.domain.product.db.ProductModel;
import com.zhaoyan.webserver.domain.product.http.ProductListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductDao productListDao;

    public ProductListResponse getProductList() {
        List<ProductModel> productModels = productListDao.getProductList();
        List<ProductListResponse.Product> products = new ArrayList<>();
        for (ProductModel productModel: productModels){
            ProductListResponse.Product product = new ProductListResponse.Product();
            product.id = productModel.id;
            product.name = productModel.name;
            product.description = productModel.description;
            product.number = productModel.number;
            product.imageUrl = productModel.imageUrl;
            products.add(product);
        }

        ProductListResponse response = new ProductListResponse();
        response.buildOk();
        response.productList = products;
        return response;
    }
}
