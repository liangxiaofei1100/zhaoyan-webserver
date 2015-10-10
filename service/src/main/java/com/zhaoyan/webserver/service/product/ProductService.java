package com.zhaoyan.webserver.service.product;


import com.zhaoyan.webserver.dao.product.ProductDao;
import com.zhaoyan.webserver.domain.product.db.ProductModel;
import com.zhaoyan.webserver.domain.product.http.AddProductRequest;
import com.zhaoyan.webserver.domain.product.http.AddProductResponse;
import com.zhaoyan.webserver.domain.product.http.ProductListResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    Logger logger = LoggerFactory.getLogger(ProductService.class);
    @Autowired
    ProductDao productDao;

    public ProductListResponse getProductList() {
        List<ProductModel> productModels = productDao.getProductList();
        List<ProductListResponse.Product> products = new ArrayList<>();
        for (ProductModel productModel : productModels) {
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


    public AddProductResponse addProduct(AddProductRequest addProductRequest) {
        ProductModel productModel = new ProductModel();
        productModel.name = addProductRequest.product.name;
        productModel.number = addProductRequest.product.number;
        productModel.description = addProductRequest.product.description;
        int id = productDao.addProduct(productModel);
        logger.debug("addProduct(): id=" + id);
        AddProductResponse response = new AddProductResponse();
        response.buildOk();
        return response;
    }
}
