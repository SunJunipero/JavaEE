package com.musicblog.dao.daoimpl;

import com.musicblog.model.Category;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.core.SqlParameter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;

public class CategoryDAO extends AbstractDAOImpl<Category> {
    @Override
    public PreparedStatementCreator fillCreateStatement(PreparedStatementCreatorFactory creatorFactory, Category entity) {
        creatorFactory.addParameter(new SqlParameter(Types.VARCHAR));
        return creatorFactory.newPreparedStatementCreator(new Object[]{entity.getName()});
    }

    @Override
    public void fillEditStatement(PreparedStatement statement, Category entity) {

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
        return databaseUtil.getQuery("create.category");
    }

    @Override
    public String getEditQuery() {
        return null;
    }

    @Override
    public Category getEntity(ResultSet set) {
        return null;
    }
}
