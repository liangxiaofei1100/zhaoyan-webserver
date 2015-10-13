package com.zhaoyan.webserver.service;

import com.zhaoyan.webserver.domain.product.db.Product;
import com.zhaoyan.webserver.domain.product.http.ViewProductResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.cglib.beans.BeanCopier;


public class PropertyCopyTest {

    public static void main(String[] args) {
        Product product1 = new Product();
        product1.id = 11313;
        product1.name = "apple";
        product1.description = "des";
        product1.number = 13;
        product1.imageUrl = "image";
        ViewProductResponse.Product product2 = new ViewProductResponse.Product();

        int testCount = 10000;

        long start = System.currentTimeMillis();
        for (int i = 0; i < testCount; i++) {
            BeanUtils.copyProperties(product1, product2);
        }
        long end = System.currentTimeMillis();
        System.out.println("BeanUtils cost time " + (end - start));
        System.out.println("product1=" + product1);
        System.out.println("product2=" + product2);

        product2 = new ViewProductResponse.Product();

        BeanCopier productBeanCopier = BeanCopier.create(Product.class, ViewProductResponse.Product.class, false);
        start = System.currentTimeMillis();
        for (int i = 0; i < testCount; i++) {
            productBeanCopier.copy(product1, product2, null);
        }
        end = System.currentTimeMillis();
        System.out.println("BeanCopier cost time " + (end - start));
        System.out.println("product1=" + product1);
        System.out.println("product2=" + product2);
    }
}
