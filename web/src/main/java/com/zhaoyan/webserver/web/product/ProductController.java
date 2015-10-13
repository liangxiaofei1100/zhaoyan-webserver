package com.zhaoyan.webserver.web.product;

import com.zhaoyan.webserver.domain.product.http.*;
import com.zhaoyan.webserver.service.product.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/product")
public class ProductController {
    Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    ProductService productService;

    /**
     * 获取商品列表Json格式数据。
     */
    @RequestMapping(value = "/list", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.GET)
    public
    @ResponseBody
    ProductListResponse getProductListJson() {
        ProductListResponse response = productService.getProductList();
        logger.debug("getProductListJson: " + response.toString());
        return response;
    }

    /**
     * 获取商品详情Json格式数据
     * 处理/product/view/{productId}形式的URL
     */
    @RequestMapping(value = "/view/{productId}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public
    @ResponseBody
    ViewProductResponse viewProductJson(@PathVariable("productId") Integer productId) {
        ViewProductResponse response = productService.getProductById(productId);
        logger.debug("viewProductJson: " + response);
        return response;
    }

    /**
     * 添加一个商品
     */
    @RequestMapping(value = "/addProduct", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    public
    @ResponseBody
    AddProductResponse addProduct(@RequestBody AddProductRequest addProductRequest) {
        logger.debug("AddProductRequest: " + addProductRequest);
        AddProductResponse response = productService.addProduct(addProductRequest);
        logger.debug("AddProductResponse: " + response);
        return response;
    }

    /**
     * 删除一个商品
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public
    @ResponseBody
    DeleteProductResponse deleteProduct(@RequestBody DeleteProductRequest request) {
        logger.debug("DeleteProductRequest: " + request);

        productService.deleteProduct(request);

        DeleteProductResponse response = new DeleteProductResponse();
        response.buildOk();
        return response;
    }
}
