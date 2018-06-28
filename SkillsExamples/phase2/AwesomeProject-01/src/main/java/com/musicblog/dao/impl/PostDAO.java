package com.musicblog.dao.impl;

import com.musicblog.model.Category;
import com.musicblog.model.Post;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PostDAO extends AbstractDAOImpl <Post> {
    @Override
    public String getAllQuery() {
        return databaseUtil.getQuery("get.all.posts");
    }

    @Override
    public String getByIdQuery() {
        return databaseUtil.getQuery("get.post.by.id");
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
