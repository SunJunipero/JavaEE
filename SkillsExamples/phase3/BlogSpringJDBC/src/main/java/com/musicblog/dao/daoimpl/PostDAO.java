package com.musicblog.dao.daoimpl;

import com.musicblog.model.Category;
import com.musicblog.model.Post;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.core.SqlParameter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    public void fillEditStatement(PreparedStatement statement, Post entity) {

    }

    @Override
    public String getAllQuery() {
        return null;
    }

    @Override
    public String getByIdQuery() {
        return null;
    }

    @Override
    public String getDeleteQuery() {
        return null;
    }

    @Override
    public String getCreateQuery() {
        return databaseUtil.getQuery("create.post");
    }

    @Override
    public String getEditQuery() {
        return null;
    }

    @Override
    public Post getEntity(ResultSet set) {
        return null;
    }
}
