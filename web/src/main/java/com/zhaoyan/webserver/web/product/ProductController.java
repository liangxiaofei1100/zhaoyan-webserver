package com.zhaoyan.webserver.web.product;

import com.zhaoyan.webserver.domain.product.http.ProductListResponse;
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
    @RequestMapping(value = "/list", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.GET,
            consumes="application/json")
    public @ResponseBody ProductListResponse getProductListJson() {
        ProductListResponse response = productService.getProductList();
        logger.debug("getProductListJson: " +response.toString());
        return response;
    }

    /**
     * 获取商品列表页面
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getProductListPage() {
        return "product_list";
    }

    /**
     * 处理/product/view/{productId}形式的URL
     */
    @RequestMapping(value = "/view/{productId}", method = RequestMethod.GET)
    public String viewProduct(@PathVariable("productId") Integer productId, Map<String, Object> model) {

        model.put("product", null);
        return "product";
    }
}
