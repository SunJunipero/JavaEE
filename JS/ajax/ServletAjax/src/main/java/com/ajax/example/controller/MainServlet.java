package com.ajax.example.controller;

import com.ajax.example.model.MyDb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/cities")
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {

        String country = httpServletRequest.getParameter("country");

        if(country != null){
            List<String> citiesByCountry = MyDb.getCitiesByCountry(country);
            StringBuilder sb = new StringBuilder();
            for (String s : citiesByCountry) {
                sb.append(s).append("|");
            }
            httpServletResponse.setContentType("text/plain");
            Writer writer = httpServletResponse.getWriter();
            writer.write(sb.toString());
            writer.flush();

        }
        else {
            ArrayList<String> countries = new ArrayList<String>();
            countries.add("Russia");
            countries.add("USA");
            countries.add("Spain");

            httpServletRequest.setAttribute("countries", countries);
            getServletContext().getRequestDispatcher("/index.jsp").forward(httpServletRequest, httpServletResponse);
        }


    }
}
