package com.zhaoyan.webserver.dao.product;


import com.zhaoyan.webserver.domain.product.db.Product;

import java.util.List;

/**
 * 商品表
 */
public interface ProductDao {
    /**
     * 获取所有商品
     *
     * @return 所有商品列表
     */
    List<Product> getProductList();

    /**
     * 添加一个商品
     *
     * @param product 商品数据
     */
    void addProduct(Product product);
}
