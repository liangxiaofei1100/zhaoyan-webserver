package com.zhaoyan.webserver.service.product;


import com.zhaoyan.webserver.dao.product.ProductDao;
import com.zhaoyan.webserver.domain.product.db.Product;
import com.zhaoyan.webserver.domain.product.http.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    Logger logger = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    @Qualifier("hibernateProductDao")
    ProductDao productDao;

    // 属性复制工具，每创建一个BeanCopier大约要100ms，创建后调用则基本不花费时间
    private static BeanCopier copierProductToProductListResponse =
            BeanCopier.create(Product.class, ProductListResponse.Product.class, false);
    private static BeanCopier copierProductToViewProductResponse =
            BeanCopier.create(Product.class, ViewProductResponse.Product.class, false);
    private static BeanCopier copierAddProductResponseToProduct =
            BeanCopier.create(AddProductRequest.Product.class, Product.class, false);

    /**
     * 商品列表
     */
    public ProductListResponse getProductList() {
        List<Product> productDBs = productDao.getProductList();
        List<ProductListResponse.Product> products = new ArrayList<>();

        for (Product productDB : productDBs) {
            logger.debug("productDB: " + productDB);
            ProductListResponse.Product productProductListResponse = new ProductListResponse.Product();
            copierProductToProductListResponse.copy(productDB, productProductListResponse, null);
            logger.debug("productProductListResponse: " + productProductListResponse);
            products.add(productProductListResponse);
        }
        ProductListResponse response = new ProductListResponse();
        response.buildOk();
        response.productList = products;
        return response;
    }

    /**
     * 查看商品详情
     */
    public ViewProductResponse getProductById(long productId) {
        Product productDB = productDao.getProductById(productId);
        ViewProductResponse.Product productViewProductResponse = new ViewProductResponse.Product();
        copierProductToViewProductResponse.copy(productDB, productViewProductResponse, null);

        ViewProductResponse response = new ViewProductResponse();
        response.buildOk();
        response.product = productViewProductResponse;
        return response;
    }

    /**
     * 添加商品
     */
    public AddProductResponse addProduct(AddProductRequest addProductRequest) {
        Product product = new Product();
        copierAddProductResponseToProduct.copy(addProductRequest.product, product, null);
        productDao.addProduct(product);

        AddProductResponse response = new AddProductResponse();
        response.buildOk();
        return response;
    }

    /**
     * 删除商品
     */
    public void deleteProduct(DeleteProductRequest request) {
        productDao.deleteProductById(request.productId);
    }
}
