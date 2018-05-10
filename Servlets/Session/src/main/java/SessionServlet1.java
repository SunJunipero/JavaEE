import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/session1")
public class SessionServlet1 extends HttpServlet {
    public static final String PARAMETER_SESSION = "parameterSession";
    public static final String PARAMETER_CONTEXT = "parameterContext";

    protected void processRequest(HttpServletResponse response, HttpServletRequest request) throws IOException {

        String param1 = request.getParameter("param1");

        HttpSession session = request.getSession(true);

        //void setAttribute(String var1, Object var2);
        session.setAttribute(PARAMETER_SESSION, param1);

        getServletContext().setAttribute(PARAMETER_CONTEXT, param1);

        PrintWriter writer = response.getWriter();

        writer.println("<html>");
        writer.println("<head><title>Init param servlet</title></head>");
        writer.println("<body>");
        writer.println("<h1>Servlet info</h1>");
        writer.println("<h1>Parameter 1 = " + param1 + "</h1>");
        writer.println("<a href='/session2'> Show parameter <a>");
        writer.println("</body>");
        writer.println("</html>");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(resp, req);
    }
}
