package controller;

import model.Person;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 for run http://localhost:8080/form
 */
@WebServlet("/form")
public class FormServlet extends HttpServlet {
    private List<Person> persons;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        persons = new ArrayList<>();
        persons.add(new Person("Alex", "Turner"));
        persons.add(new Person("Miles", "Kane"));
        persons.add(new Person("Marsel", "Prust"));

    }

    protected void processRequest(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
        if (request.getParameter("submit") != null){
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            persons.add(new Person(name, surname));
        }

        //TODO look at stream and lambda
        if(request.getParameter("delete") != null){
            String deleteName = request.getParameter("delete");
            Iterator<Person> iterator = persons.iterator();

            //persons.removeIf(next -> next.getName().equals("delete"));

            while (iterator.hasNext()) {
                Person next = iterator.next();
                if(next.getName().equals(deleteName))
                    iterator.remove();
            }
        }

        request.setAttribute("persons", persons);
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/index.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(resp, req);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(resp, req);
    }
}
