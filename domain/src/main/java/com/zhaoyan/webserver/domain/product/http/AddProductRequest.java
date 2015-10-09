package com.zhaoyan.webserver.domain.product.http;


import com.zhaoyan.webserver.domain.common.http.Request;

public class AddProductRequest extends Request {
    public Product product;

    public class Product {
        public String name;
        public String description;
        public int number;
    }
}
