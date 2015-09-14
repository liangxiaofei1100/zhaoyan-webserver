package com.zhaoyan.webserver.dao.common;

import com.zhaoyan.webserver.domain.common.GreetingModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class GreetingDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public GreetingModel getGreetingMessage() {
        final GreetingModel greetingModel = new GreetingModel();

        String sql = getRamdomRecordSql("id", "greeting", 1);
        Object[] params = new Object[]{};
        jdbcTemplate.query(sql, params, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                greetingModel.message = resultSet.getString("message");
            }
        });

        if (greetingModel.message == null) {
            greetingModel.message = "";
        }

        return greetingModel;
    }

    public static String getRamdomRecordSql(String idColumn, String table, int count) {
        String sql = "SELECT * FROM " + table + " WHERE " + idColumn + " >= ((SELECT MAX(" + idColumn +
                ") FROM " + table + " )-(SELECT MIN(" + idColumn + ") FROM " + table +
                " )) * RAND() + (SELECT MIN(" + idColumn + ") FROM " + table + " )  LIMIT " + count;
        return sql;
    }

}
