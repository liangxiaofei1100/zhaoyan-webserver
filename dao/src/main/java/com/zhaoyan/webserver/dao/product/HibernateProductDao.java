package com.zhaoyan.webserver.dao.product;

import com.zhaoyan.webserver.domain.product.db.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HibernateProductDao implements ProductDao{

    @Autowired
    HibernateTemplate hibernateTemplate;

    @Override
    public List<Product> getProductList() {
        List<Product> products = (List<Product>) hibernateTemplate.find("from Product");
        return products;
    }

    @Override
    public void addProduct(Product product) {
        hibernateTemplate.save(product);
    }
}
