package com.zhaoyan.webserver.domain.product.db;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
    @Id
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
