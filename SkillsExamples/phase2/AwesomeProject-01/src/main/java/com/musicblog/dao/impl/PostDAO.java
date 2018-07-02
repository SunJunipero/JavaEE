package com.musicblog.dao.impl;

import com.musicblog.model.Category;
import com.musicblog.model.Post;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public List<Post> getPostsByCategoryId (Integer categoryId){
        ArrayList<Post> posts = new ArrayList<>();
        Category category = this.category.getById(categoryId);

        try (Connection connection = databaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement("select * from blog.posts where categoryId = ?")){
            statement.setInt(1, categoryId);
            try (ResultSet resultSet = statement.executeQuery()){
                while (resultSet.next()){
                    posts.add(new Post(resultSet, category));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return posts;
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
