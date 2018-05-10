import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ParamInitServlet extends HttpServlet {
    String param1;
    String param2;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        param1 = getServletConfig().getInitParameter("parameter1");
        param2 = getServletConfig().getInitParameter("parameter2");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String param1 = getServletConfig().getInitParameter("parameter1");
        String param2 = getServletConfig().getInitParameter("parameter2");

        PrintWriter writer = resp.getWriter();

        writer.println("<html>");
        writer.println("<head><title>Init param servlet</title></head>");
        writer.println("<body>");
        writer.println("<h1>Init param servlet</h1>");
        writer.println("<h1>Parameter 1 = " + param1 + "</h1>");
        writer.println("<h1>Parameter 2 = " + param2 + "</h1>");
        writer.println("</body>");
        writer.println("</html>");
    }
}
