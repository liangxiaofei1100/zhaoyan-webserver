package com.zhaoyan.webserver.web.product;

import com.zhaoyan.webserver.domain.product.http.ProductListRequest;
import com.zhaoyan.webserver.domain.product.http.ProductListResponse;
import com.zhaoyan.webserver.service.product.ProductAddService;
import com.zhaoyan.webserver.service.product.ProductListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductListService productListService;
    @Autowired
    ProductAddService productAddService;

    /**
     * 获取商品列表Json格式数据。
     */
    @RequestMapping(value = "/list", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.GET,
            consumes="application/json")
    public @ResponseBody ProductListResponse getProductListJson() {
        return productListService.getProductList();
    }

    /**
     * 获取商品列表页面
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getProductListPage() {
        return "product";
    }

    /**
     * 处理/product/view/{productId}形式的URL
     */
    @RequestMapping(value = "view/{productId}", method = RequestMethod.GET)
    public String viewProduct(@PathVariable("productId") Integer productId, Map<String, Object> model) {

        model.put("product", null);
        return "product";
    }
}
