package com.musicblog.dao.daoimpl;

import com.musicblog.model.Category;
import com.musicblog.model.Post;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.core.SqlParameter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class PostDAO extends AbstractDAOImpl<Post> {
    @Override
    public PreparedStatementCreator fillCreateStatement(PreparedStatementCreatorFactory creatorFactory, Post entity) {
        creatorFactory.addParameter(new SqlParameter(Types.VARCHAR));
        creatorFactory.addParameter(new SqlParameter(Types.VARCHAR));
        creatorFactory.addParameter(new SqlParameter(Types.VARCHAR));
        creatorFactory.addParameter(new SqlParameter(Types.INTEGER));
        return creatorFactory.newPreparedStatementCreator(new Object[]{entity.getTitle(), entity.getSummary(), entity.getBody(),entity.getCategory().getId()});
    }

    @Override
    public Object[] fillEditStatement (Post entity) {
        return new Object[] {entity.getTitle(), entity.getSummary(), entity.getBody(), entity.getCategory().getId(), entity.getId()};
    }

    @Override
    public String getAllQuery() {
        return null;
    }

    @Override
    public String getByIdQuery() {
        return databaseUtil.getQuery("get.post.by.id");
    }

    @Override
    public String getDeleteQuery() {
        return databaseUtil.getQuery("delete.post");
    }

    @Override
    public String getCreateQuery() {
        return databaseUtil.getQuery("create.post");
    }

    @Override
    public String getEditQuery() {
        return databaseUtil.getQuery("update.post") ;
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
