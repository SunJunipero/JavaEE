import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/source")
public class SourceServlet  extends HttpServlet{
    protected void proccesServlet(HttpServletResponse response, HttpServletRequest request) throws IOException, ServletException {
        if(request.getParameter("redirect" ) != null)
            response.sendRedirect("/target");
        else getServletContext().getRequestDispatcher("/target").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        proccesServlet(resp, req);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        proccesServlet(resp, req);
    }

    /*
    redirect :
    http://localhost:8080/source?param=test&redirect=yes --> http://localhost:8080/target
    forward:
    http://localhost:8080/source?param=test --> http://localhost:8080/source?param=test
     */
}