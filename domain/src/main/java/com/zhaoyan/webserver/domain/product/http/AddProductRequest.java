package com.zhaoyan.webserver.domain.product.http;


import com.zhaoyan.webserver.domain.common.http.Request;

public class AddProductRequest extends Request {
    public Product product;

    public class Product {
        public String name;
        public String description;
        public int number;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        @Override
        public String toString() {
            return "Product{" +
                    "name='" + name + '\'' +
                    ", description='" + description + '\'' +
                    ", number=" + number +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "AddProductRequest{" +
                "product=" + product +
                '}';
    }
}
