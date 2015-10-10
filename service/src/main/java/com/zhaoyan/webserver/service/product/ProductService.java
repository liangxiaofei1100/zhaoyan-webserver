package com.zhaoyan.webserver.service.product;


import com.zhaoyan.webserver.dao.product.ProductDao;
import com.zhaoyan.webserver.domain.product.db.Product;
import com.zhaoyan.webserver.domain.product.http.AddProductRequest;
import com.zhaoyan.webserver.domain.product.http.AddProductResponse;
import com.zhaoyan.webserver.domain.product.http.ProductListResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    Logger logger = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    @Qualifier("hibernateProductDao")
    ProductDao productDao;

    public ProductListResponse getProductList() {
        List<Product> productModels = productDao.getProductList();
        List<ProductListResponse.Product> products = new ArrayList<>();
        for (Product productModel : productModels) {
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
        Product product = new Product();
        product.name = addProductRequest.product.name;
        product.number = addProductRequest.product.number;
        product.description = addProductRequest.product.description;
        productDao.addProduct(product);

        AddProductResponse response = new AddProductResponse();
        response.buildOk();
        return response;
    }
}
