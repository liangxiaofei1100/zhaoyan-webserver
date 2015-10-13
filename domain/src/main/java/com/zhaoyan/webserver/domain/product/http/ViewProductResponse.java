package com.zhaoyan.webserver.domain.product.http;


import com.zhaoyan.webserver.domain.common.http.Response;

/**
 * 商品详情
 */
public class ViewProductResponse extends Response{
    public Product product;

    public static class Product {
        public long id;
        public String name;
        public String description;
        public int number;
        public String imageUrl;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

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

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

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
        return "ViewProductResponse{" +
                "product=" + product +
                '}';
    }
}
