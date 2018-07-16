package com.musicblog.controller;

import com.musicblog.dao.AbstractDAO;
import com.musicblog.dao.impl.CategoryDAO;
import com.musicblog.dao.impl.PostDAO;
import com.musicblog.Category;
import com.musicblog.Post;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin")
public class BlogAdminServlet extends HttpServlet {
    AbstractDAO<Post> postDao = new PostDAO();
    AbstractDAO<Category> categoryDao = new CategoryDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mode = req.getParameter("mode");

        if ("posts".equals(mode)) {
            List<Post> posts = postDao.getAll();
            req.setAttribute("posts", posts);
            List<Category> categories = categoryDao.getAll();
            req.setAttribute("categories", categories);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/posts.jsp");
            rd.forward(req, resp);
            return;
        }

        if ("categories".equals(mode)) {
            List<Category> categories = categoryDao.getAll();
            req.setAttribute("categories", categories);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/categories.jsp");
            rd.forward(req, resp);
            return;
        }

        String action = req.getParameter("action");
        String postId = req.getParameter("post");
        String categoryId = req.getParameter("category");

        if ("edit".equals(action)) {
            System.out.println("\t\t  jsp/newpost.jsp");
            String target = "/jsp/newpost.jsp";
            if (postId != null) {
                System.out.println("\t\t  postId != null");
                Post post = postDao.getById(Integer.parseInt(postId));
                List<Category> categories = categoryDao.getAll();
                req.setAttribute("post", post);
                req.setAttribute("categories", categories);
            }
            if (categoryId != null) {
                target = "/admin/categories.jsp";
                Category category = categoryDao.getById(Integer.parseInt(categoryId));
                req.setAttribute("category", category);
            }
            RequestDispatcher rd = getServletContext().getRequestDispatcher(target);
            rd.forward(req, resp);
            return;
        }

        if ("delete".equals(action)) {

            if (postId != null) {
                Post post = postDao.getById(Integer.parseInt(postId));
                if (post != null)
                    postDao.delete(post);
                resp.sendRedirect("/admin?mode=posts");
                return;
            }

            if (categoryId != null) {
                Category category = categoryDao.getById(Integer.parseInt(categoryId));
                if (category != null)
                    categoryDao.delete(category);

                resp.sendRedirect("/admin?mode=categories");
                return;
            }

        }



        // forward to main admin page
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/index.jsp");
        rd.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String id = req.getParameter("id");

        if (name != null) {
            Category category = new Category(name);
            // edit action
            if (id != null){
                category.setId(Integer.parseInt(id));
                categoryDao.edit(category);
            }
            else{
                // create new category
                categoryDao.create(category);
            }

        }
        resp.sendRedirect("/admin?mode=categories");

    }
}
