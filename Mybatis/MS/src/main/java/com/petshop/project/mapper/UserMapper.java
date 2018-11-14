package com.petshop.project.mapper;

import com.petshop.project.model.User;
import com.petshop.project.model.UserRole;
import com.petshop.project.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
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

        SqlSession session1 = sessionFactory.openSession();
        UserRole userRole = new UserRole();
        userRole.setUser_id(user.getUser_id());
        userRole.setRole("ROLE_USER");
        System.out.println(userRole);
        session1.insert("mybatis.userMapper.insertRole", userRole);
        session1.commit();


        session1.close();


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

    public void deleteUsers(int[] users_ids){
        for (int users_id : users_ids) {
            deleteUser(users_id);
        }
    }

    public void addUsers(User[] users){
        for (User user : users) {
            addUser(user);
        }
    }

    public void updateUsers(User[] users){
        for (User user : users) {
            updateUser(user);
        }
    }


}
