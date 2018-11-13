package com.example.gridcrud;

import com.example.gridcrud.dao.daoimpl.BookDaoImpl;

public class Demo {
    public static void main(String[] args) {
        BookDaoImpl bookDao = new BookDaoImpl();

        System.out.println(bookDao.getById(2));

        System.out.println(bookDao.getById(5));

        System.out.println(bookDao.getById(3));
    }
}
