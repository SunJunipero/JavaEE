package com.musicblog.dao.daoimpl;

import com.musicblog.model.Category;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.core.SqlParameter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class CategoryDAO extends AbstractDAOImpl<Category> {
    @Override
    public PreparedStatementCreator fillCreateStatement(PreparedStatementCreatorFactory creatorFactory, Category entity) {
        creatorFactory.addParameter(new SqlParameter(Types.VARCHAR));
        return creatorFactory.newPreparedStatementCreator(new Object[]{entity.getName()});
    }

    @Override
    public Object[] fillEditStatement(Category entity) {
        return new Object[]{entity.getName(), entity.getId()};
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
    public String getDeleteQuery() {
        return databaseUtil.getQuery("delete.category");
    }

    @Override
    public String getCreateQuery() {
        return databaseUtil.getQuery("create.category");
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
