import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/target")
public class TargetServlet extends HttpServlet {

    protected void processServlet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = response.getWriter();

        writer.println("</html>");
        writer.println("<head>");
        writer.println("<title> Target Servlet</title>");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("<h1> parameter = "+ request.getParameter("param") + "</h1>");
        writer.println("</body>");
        writer.println("</html>");
        writer.close();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processServlet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processServlet(req, resp);
    }
}