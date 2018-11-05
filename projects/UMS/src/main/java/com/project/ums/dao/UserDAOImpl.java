package com.project.ums.dao;

import com.project.ums.model.User;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements AbstractDAO<User> {

    private User user = new User();

    @Autowired
    protected HibernateTemplate ht;

    public User getById(int id) {
        return ht.get(user.getClass(), id);
    }

    public List<User> getAll() {
        return (List<User>) ht.loadAll(user.getClass());
    }

    public User create(User entity) {
        ht.save(entity);
        return entity;
    }

//    public User update(User entity) {
//        ht.getSessionFactory().getCurrentSession().clear();
//        ht.saveOrUpdate(entity);
//        return entity;
//    }
    public User update(User entity) {
        Session session = ht.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        User user = ((User) session.load(User.class, entity.getUser_id()));
        user.setEmail(entity.getEmail());
        user.setUser_first_name(entity.getUser_first_name());
        user.setUser_last_name(entity.getUser_last_name());
        user.setUser_name(entity.getUser_name());
        user.setPassword(entity.getPassword());
        user.setBirthday(entity.getBirthday());
        user.setIs_active(entity.isIs_active());
        user.setLast_updated_stamp(entity.getLast_updated_stamp());
        user.setAddress(entity.getAddress());
        session.saveOrUpdate(user);
        return user;
    }

    public void delete(User entity) {
        ht.delete(entity);
    }
}
