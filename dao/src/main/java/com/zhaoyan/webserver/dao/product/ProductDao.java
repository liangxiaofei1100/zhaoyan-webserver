package com.zhaoyan.webserver.dao.product;

import com.zhaoyan.webserver.domain.product.db.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 商品表
 */
@Repository
public class ProductDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * 获取所有商品
     *
     * @return 所有商品列表
     */
    public List<ProductModel> getProductList() {
        final List<ProductModel> productModelList = new ArrayList<>();

        String sql = "SELECT * FROM product";
        Object[] params = new Object[]{};
        jdbcTemplate.query(sql, params, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                ProductModel product = new ProductModel();
                product.id = resultSet.getInt("id");
                product.name = resultSet.getString("name");
                product.description = resultSet.getString("description");
                product.number = resultSet.getInt("number");
                product.imageUrl = resultSet.getString("imageUrl");
                productModelList.add(product);
            }
        });

        return productModelList;
    }

    /**
     * 添加一个商品
     *
     * @param productModel 商品数据
     * @return 结果，1代表成功，其他代表失败。
     */
    public int addProduct(ProductModel productModel) {
        String sql = "INSERT INTO product (name,description,number) VALUES (?,?,?)";
        Object[] params = new Object[]{productModel.name, productModel.description, productModel.number};
        int result = jdbcTemplate.update(sql, params);
        return result;
    }
}
