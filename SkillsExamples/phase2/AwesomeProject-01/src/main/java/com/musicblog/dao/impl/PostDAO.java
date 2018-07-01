package com.musicblog.dao.impl;

import com.musicblog.model.Category;
import com.musicblog.model.Post;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PostDAO extends AbstractDAOImpl <Post> {
    @Override
    public void fillEditStatement(PreparedStatement statement, Post entity) {
            try {
                statement.setString(1, entity.getTitle());
                statement.setString(2, entity.getSummary());
                statement.setString(3, entity.getBody());
                statement.setInt(4, entity.getCategory().getId());
                statement.setInt(5, entity.getId());
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    @Override
    public void fillCreateStatement(PreparedStatement statement, Post entity) {
        try {
            statement.setString(1, entity.getTitle());
            statement.setString(2, entity.getSummary());
            statement.setString(3, entity.getBody());
            statement.setInt(4, entity.getCategory().getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getCreateQuery() {
        return databaseUtil.getQuery("create.post");
    }

    @Override
    public String getDeleteQuery()
    {
        return databaseUtil.getQuery("delete.post.by.id");
    }

    @Override
    public String getAllQuery() {

        return databaseUtil.getQuery("get.all.posts");
    }

    @Override
    public String getByIdQuery() {

        return databaseUtil.getQuery("get.post.by.id");
    }


    @Override
    public String getEditQuery() {
        return databaseUtil.getQuery("update.post");
    }



    private CategoryDAO category = new CategoryDAO();
    @Override
    public Post getEntity(ResultSet set) {
        try {
            int anInt = set.getInt(5);
            Category byId = category.getById(anInt);
            return new Post(set, byId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
