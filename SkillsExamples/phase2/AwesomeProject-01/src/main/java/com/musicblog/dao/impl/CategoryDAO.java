package com.musicblog.dao.impl;

import com.musicblog.dao.AbstractDAO;
import com.musicblog.model.Category;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CategoryDAO extends AbstractDAOImpl<Category> {

    @Override
    public void fillEditStatement(PreparedStatement statement, Category entity) {
        try {
            statement.setString(1, entity.getName());
            statement.setInt(2, entity.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void fillCreateStatement(PreparedStatement statement, Category entity) {
        try {
            statement.setString(1, entity.getName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getCreateQuery() {
        return databaseUtil.getQuery("create.category");
    }

    @Override
    public String getDeleteQuery() {
        return databaseUtil.getQuery("delete.category");
    }

    @Override
    public String getAllQuery() {
        return databaseUtil.getQuery("get.all.categories");
    }

    @Override
    public String getByIdQuery() {
        return databaseUtil.getQuery("get.category.by.id");
    }

    @Override
    public String getEditQuery() {
         return databaseUtil.getQuery("update.category") ;
    }

    @Override
    public Category getEntity(ResultSet set) {
        try {
            return new Category(set.getInt("id"), set.getString("name"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
