import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/session2")
public class SessionServlet2 extends HttpServlet {
    protected void processServlet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //посмотреть еще раз про интерфейсы !!!
        //приведение типов
        String param1 = (String) request.getSession(true).getAttribute(SessionServlet1.PARAMETER_SESSION);


        String param2 = (String) getServletContext().getAttribute(SessionServlet1.PARAMETER_CONTEXT);

        PrintWriter writer = response.getWriter();

        writer.println("<html>");
        writer.println("<head><title>Init param servlet</title></head>");
        writer.println("<body>");
        writer.println("<h1>Servlet session info</h1>");
        writer.println("<h1>Parameter session = " + param1 + "</h1>");
        writer.println("<h1>Parameter context = " + param2 + "</h1>");
        writer.println("<a href='index.jsp'> Go home <a>");
        writer.println("</body>");
        writer.println("</html>");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processServlet(req, resp);
    }
}
