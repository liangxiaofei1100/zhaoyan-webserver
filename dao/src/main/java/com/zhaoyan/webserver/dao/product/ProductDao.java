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
     * 根据商品Id获得商品信息
     *
     * @param productId 商品ID
     * @return 商品数据
     */
    Product getProductById(long productId);

    /**
     * 删除一个商品
     *
     * @param productId 商品Id
     */
    void deleteProduct(long productId);

    /**
     * 添加一个商品
     *
     * @param product 商品数据
     */
    void addProduct(Product product);

    /**
     * 修改一个商品
     *
     * @param product 商品数据
     */
    void updateProduct(Product product);
}
