package com.musicblog.dao.impl;

import com.musicblog.dao.AbstractDAO;
import com.musicblog.model.MainEntity;
import com.musicblog.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDAOImpl <T extends MainEntity> implements AbstractDAO<T> {

    DatabaseUtil databaseUtil = new DatabaseUtil();

        @Override
    public T create(T entity) {
        return null;
    }

    @Override
    public void delete(T entity) {
            Connection connection = null;
            PreparedStatement statement = null;
        try {
            connection = databaseUtil.gettingTestConnection();
            statement = connection.prepareStatement(getDeleteQuery());
            statement.setInt(1, entity.getId());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (connection != null) try {connection.close();}  catch (SQLException e) {e.printStackTrace();}
            if (statement != null) try {statement.close(); } catch (SQLException e) {  e.printStackTrace();}

        }


    }


    @Override
    public T edit(T entity) {
        return null;
    }

    @Override
    public T getById(Integer id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = databaseUtil.gettingTestConnection();
            statement = connection.prepareStatement(getByIdQuery());
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return getEntity(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (connection != null) try {connection.close();}  catch (SQLException e) {e.printStackTrace();}
            if (statement != null) try {statement.close(); } catch (SQLException e) {  e.printStackTrace();}
            if (resultSet != null) try {resultSet.close(); } catch (SQLException e) {  e.printStackTrace();}
        }
        return null;
    }



    @Override
    public List<T> getAll() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        ArrayList<T> list = new ArrayList<>();

        try {
            //change on getConnection at final
            connection = databaseUtil.gettingTestConnection();
            statement = connection.prepareStatement(getAllQuery());
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                list.add(getEntity(resultSet));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) try {connection.close();}  catch (SQLException e) {e.printStackTrace();}
            if (statement != null) try {statement.close(); } catch (SQLException e) {  e.printStackTrace();}
            if (resultSet != null) try {resultSet.close(); } catch (SQLException e) {  e.printStackTrace();}


        }
        return list;
    }

    public abstract String getAllQuery();
    public abstract String getByIdQuery();
    protected abstract String getDeleteQuery();
    public abstract T getEntity(ResultSet set);
}
