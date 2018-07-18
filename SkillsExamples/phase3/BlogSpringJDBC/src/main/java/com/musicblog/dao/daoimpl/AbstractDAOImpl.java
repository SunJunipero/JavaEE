package com.musicblog.dao.daoimpl;

import com.musicblog.dao.AbstractDAO;
import com.musicblog.model.BaseEntity;
import com.musicblog.util.DatabaseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.List;

public abstract class AbstractDAOImpl <T extends BaseEntity> implements AbstractDAO<T> {

    private static final Logger log = LoggerFactory.getLogger(AbstractDAOImpl.class);

    DatabaseUtil databaseUtil = new DatabaseUtil();
    ApplicationContext context = new GenericXmlApplicationContext("classpath:springContext.xml");
    JdbcTemplate jdbc = context.getBean("jdbcTemplate", JdbcTemplate.class);

    @Override
    public T create(T entity) {
        PreparedStatementCreatorFactory creatorFactory = new PreparedStatementCreatorFactory(getCreateQuery());
        creatorFactory.setGeneratedKeysColumnNames("id");
        PreparedStatementCreator preparedStatementCreator = fillCreateStatement(creatorFactory, entity);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        int insertCount = jdbc.update(preparedStatementCreator, keyHolder);
        log.debug("Insert count: {}", insertCount);
        log.debug("New Region's id: {}", keyHolder.getKey().longValue());
        return null;
    }

    @Override
    public T update(T entity) {
        return null;
    }

    @Override
    public void delete(T entity) {

    }

    @Override
    public T getById(Integer id) {
        return null;
    }

    @Override
    public List<T> getAll() {
        return null;
    }

    public abstract PreparedStatementCreator fillCreateStatement(PreparedStatementCreatorFactory creatorFactory, T entity);
    public abstract void fillEditStatement(PreparedStatement statement, T entity);

    public abstract String getAllQuery();
    public abstract String getByIdQuery();
    public abstract String getDeleteQuery();
    public abstract String getCreateQuery();
    public abstract String getEditQuery();

    public abstract T getEntity(ResultSet set);
}
