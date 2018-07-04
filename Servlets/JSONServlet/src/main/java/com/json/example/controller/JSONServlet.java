package com.json.example.controller;

import com.json.example.model.Person;
import com.json.example.util.PersonHolder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/persons")
public class JSONServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Person> perons = PersonHolder.getPerons();

        /**
         * Way1: (for simple object and small amounts)
         */

    }
}
