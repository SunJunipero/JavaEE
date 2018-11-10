package com.petshop.project.mapper;

import com.petshop.project.model.User;
import com.petshop.project.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserMapper {
    public User getUserById (Integer id){
        SqlSessionFactory sessionFactory = MyBatisUtil.getSessionFactory();
        SqlSession session = sessionFactory.openSession();
        User user = session.selectOne("mybatis.userMapper.selectUser", id);
        session.commit();
        session.close();
        return user;
    }

    public List<User> getAllUsers(){
        SqlSessionFactory sessionFactory = MyBatisUtil.getSessionFactory();
        SqlSession session = sessionFactory.openSession();
        List<User> users = session.selectList("mybatis.userMapper.getAllUsers");
        session.commit();
        session.close();
        return users;
    }

    public void addUser(User user){
        SqlSessionFactory sessionFactory = MyBatisUtil.getSessionFactory();
        SqlSession session = sessionFactory.openSession();
        session.insert("mybatis.userMapper.insertUser", user);
        session.commit();
        session.close();
    }

    public void updateUser(User user){
        SqlSessionFactory sessionFactory = MyBatisUtil.getSessionFactory();
        SqlSession session = sessionFactory.openSession();
        session.update("mybatis.userMapper.updateUser", user);
        session.commit();
        session.close();
    }

    public void deleteUser(Integer userId){
        SqlSessionFactory sessionFactory = MyBatisUtil.getSessionFactory();
        SqlSession session = sessionFactory.openSession();
        session.delete("mybatis.userMapper.deleteUser", userId);
        session.commit();
        session.close();
    }

}
