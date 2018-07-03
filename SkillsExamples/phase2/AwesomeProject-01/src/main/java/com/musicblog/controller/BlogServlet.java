package com.musicblog.controller;

import com.musicblog.dao.impl.CategoryDAO;
import com.musicblog.dao.impl.PostDAO;
import com.musicblog.model.Category;
import com.musicblog.model.Post;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/blog/*", "/blog", "/newpost"})
public class BlogServlet extends HttpServlet {

    CategoryDAO categoryDAO = new CategoryDAO();
    PostDAO postDAO = new PostDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String postId = req.getParameter("post");
        String categoryId = req.getParameter("category");
        String url = req.getRequestURL().toString();

        if(url.contains("newpost")){
            System.out.println("\t\t BlogServlet - newPost");
            List<Category> categories = categoryDAO.getAll();
            req.setAttribute("categories", categories);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/newpost.jsp");
            rd.forward(req, resp);
            return;
        }

        if(postId != null){
            System.out.println("\t\t BlogServlet - postId");
            Post post = postDAO.getById(Integer.parseInt(postId));
            req.setAttribute("post", post );
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/post.jsp");
            rd.forward(req, resp);
        }
        else{
            System.out.println("\t\t BlogServlet - getAll");
            List<Post> posts = categoryId == null ? postDAO.getAll() :
                    postDAO.getPostsByCategoryId(Integer.parseInt(categoryId));
            req.setAttribute("posts", posts);
            List<Category> categories = categoryDAO.getAll();
            req.setAttribute("categories", categories);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/index.jsp");
            rd.forward(req, resp);

        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String title = req.getParameter("title");
        String summary = req.getParameter("summary");
        String body = req.getParameter("body");
        String category = req.getParameter("category");

        System.out.println("title = " + title
        + "id " + id
        + "summary " + summary
        + "body " + body
        + "category" + category);

        if (ValidateParam(title, body, summary)){
            Category cat =  categoryDAO.getById(Integer.parseInt(category));

            Post post = new Post(title, summary, body, cat);
            if (id != null) {
                post.setId(Integer.parseInt(id));
                System.out.println("\t\t Edit post");
                postDAO.edit(post);
            }else{
                System.out.println("\t\t Create post");
                postDAO.create(post);
            }
            resp.sendRedirect("/blog");
        }
        else {
            Post post = new Post();
            if(!isNullorEmpty(title)) post.setTitle(title);
            if(!isNullorEmpty(body)) post.setBody(body);
            if(!isNullorEmpty(summary)) post.setSummary(summary);
            req.setAttribute("error", "Please, fill required fields");
            req.setAttribute("post", post);
            req.setAttribute("categories", categoryDAO.getAll());
            //TODO ???
            System.out.println("Please, fill required fields");
            getServletContext().getRequestDispatcher("/jsp/newpost.jsp").forward(req, resp);
            System.out.println("\t\tPlease, fill required fields");
        }

    }

    private boolean ValidateParam(String title, String body, String summary){
        if (isNullorEmpty(title)) return false;
        if (isNullorEmpty(body)) return false;
        if (isNullorEmpty(summary)) return false;
        return true;

    }

    private boolean isNullorEmpty(String s){
        return s == null || s.isEmpty();
    }
}

