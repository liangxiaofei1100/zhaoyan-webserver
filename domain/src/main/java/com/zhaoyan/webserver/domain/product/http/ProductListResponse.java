package com.zhaoyan.webserver.domain.product.http;

import com.zhaoyan.webserver.domain.common.http.Response;

import java.util.List;

public class ProductListResponse extends Response {
    public List<Product> productList;

    public static class Product {
        public long id;
        public String name;
        public String description;
        public int number;
        public String imageUrl;

        @Override
        public String toString() {
            return "Product{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", description='" + description + '\'' +
                    ", number=" + number +
                    ", imageUrl='" + imageUrl + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "ProductListResponse{" +
                "productList=" + productList +
                '}';
    }
}
