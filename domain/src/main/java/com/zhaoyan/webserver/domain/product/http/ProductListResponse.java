package com.zhaoyan.webserver.domain.product.http;

import com.zhaoyan.webserver.domain.common.http.Response;

import java.util.List;

public class ProductListResponse extends Response{
    public List<Product> productList;

    static public class Product {
        public long id;
        public String name;
        public String description;
        public int number;
    }
}
