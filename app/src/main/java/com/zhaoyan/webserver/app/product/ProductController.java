package com.zhaoyan.webserver.app.product;

import com.zhaoyan.webserver.domain.product.http.ProductListRequest;
import com.zhaoyan.webserver.domain.product.http.ProductListResponse;
import com.zhaoyan.webserver.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @ResponseBody
    @RequestMapping(value = "/product/productlist", produces = {"application/json;charset=UTF-8"})
    public ProductListResponse getProductList(@RequestBody ProductListRequest request) {
        return productService.getProductList();
    }

}
