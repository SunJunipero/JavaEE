package com.petshop.project.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class MyBatisUtil {
    private static String config = "BdConfiguration.xml";
    private static SqlSessionFactory sessionFactory;

    static {
        try {
            Reader resourceAsReader = Resources.getResourceAsReader(config);
            sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsReader);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSessionFactory(){
        return sessionFactory;
    }

}
