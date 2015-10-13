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
    public Product getProductById(long productId) {
        return hibernateTemplate.get(Product.class, productId);
    }

    @Override
    public void deleteProductById(long productId) {
        Product product = hibernateTemplate.get(Product.class, productId);
        // 如果商品不存在，就不处理。
        if (product != null) {
            hibernateTemplate.delete(product);
        }
    }

    @Override
    public void addProduct(Product product) {
        hibernateTemplate.save(product);
    }

    @Override
    public void updateProduct(Product product) {
        hibernateTemplate.update(product);
    }
}
