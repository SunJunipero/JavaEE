package com.musicblog.dao.impl;

import com.musicblog.dao.AbstractDAO;
import com.musicblog.model.MainEntity;
import com.musicblog.util.DatabaseUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDAOImpl <T extends MainEntity> implements AbstractDAO<T> {

    DatabaseUtil databaseUtil = new DatabaseUtil();
    ApplicationContext context = new GenericXmlApplicationContext("classpath:springContext.xml");


        @Override
    public T create(T entity) {
            Connection connection = null;
            PreparedStatement statement = null;
            ResultSet set = null;

            try {
                //connection = databaseUtil.gettingTestConnection();
                connection = databaseUtil.getConnection();
                statement = connection.prepareStatement(getCreateQuery(), Statement.RETURN_GENERATED_KEYS);
                fillCreateStatement(statement, entity);
                statement.executeUpdate();
                set = statement.getGeneratedKeys();
                System.out.println("\t\tgetGeneratedKeys()");
                System.out.println(set);
                if (set.next()) {
                    Integer anInt = set.getInt(1);
                    System.out.println("anInt - " + anInt);
                    return getById(anInt);
                }
            } catch (SQLException e) {
                e.printStackTrace();

            }
            finally {
                if (connection != null) try {connection.close();}  catch (SQLException e) {e.printStackTrace();}
                if (statement != null) try {statement.close(); } catch (SQLException e) {  e.printStackTrace();}
                if (set != null) try {set.close(); } catch (SQLException e) {  e.printStackTrace();}
            }
            return null;
        }


    @Override
    public void delete(T entity) {
            Connection connection = null;
            PreparedStatement statement = null;
        try {
            //connection = databaseUtil.gettingTestConnection();
            connection = databaseUtil.getConnection();
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
            Connection connection = null;
            PreparedStatement statement = null;

            try{
                //connection = databaseUtil.gettingTestConnection();
                connection = databaseUtil.getConnection();
                statement= connection.prepareStatement(getEditQuery());
                fillEditStatement(statement, entity);
                statement.executeUpdate();
                return entity;

            } catch (SQLException e) {
                e.printStackTrace();
            }
            finally {
                if (connection != null) try {connection.close();}  catch (SQLException e) {e.printStackTrace();}
                if (statement != null) try {statement.close(); } catch (SQLException e) {  e.printStackTrace();}

            }
        return null;
    }



    @Override
    public T getById(Integer id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = databaseUtil.gettingTestConnection();
            //connection = databaseUtil.getConnection();
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

    public T getByIdbySpring(Integer id) {
        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
        T entity = jdbcTemplate.queryForObject(getByIdQuery(), new Object[]{id}, (resultSet, i) -> getEntity(resultSet));
        return entity;
    }



    @Override
    public List<T> getAll() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        ArrayList<T> list = new ArrayList<>();

        try {
            //change on getConnection at final
           // connection = databaseUtil.gettingTestConnection();
            connection = databaseUtil.getConnection();
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

    public abstract void fillCreateStatement(PreparedStatement statement, T entity);
    public abstract void fillEditStatement(PreparedStatement statement, T entity);

    public abstract String getAllQuery();
    public abstract String getByIdQuery();
    public abstract String getDeleteQuery();
    public abstract String getCreateQuery();
    public abstract String getEditQuery();

    public abstract T getEntity(ResultSet set);

}
