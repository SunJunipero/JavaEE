import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/login", "/welcome"})
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String pass = req.getParameter("pass");

        if(login.equals("admin") && pass.equals("pass")){
            req.getSession(true).setAttribute("token", 1);
            resp.sendRedirect("/welcome");
        }
        else {
            resp.sendRedirect("/login.html");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("from get method");

        PrintWriter writer = resp.getWriter();

        writer.println("<html>");
        writer.println("<head><title>Servlet Show Parameters</title></head>");
        writer.println("<body>");
        writer.println("<h1> PARAMETERS !!! </h1>");
        writer.println("</body>");
        writer.println("</html>");
        System.out.println("end get method");

    }
}
