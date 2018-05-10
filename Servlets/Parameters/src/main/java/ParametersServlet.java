import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/paramservlet")
public class ParametersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String parameter1 = req.getParameter("parameter1");
        String parameter2 = req.getParameter("parameter2");
        String parameter3 = req.getParameter("parameter3");

        String parameter4 = req.getParameter("text");
        String parameter5 = req.getParameter("select");
        String parameter6 = req.getParameter("check");


        for (Enumeration<String> parameterNames = req.getParameterNames(); parameterNames.hasMoreElements();){
            String name = parameterNames.nextElement();
            String value = req.getParameter(name);

            System.out.println("Name " + name);
            System.out.println("Value " + value);
        }

        PrintWriter writer = resp.getWriter();

        writer.println("<html>");
        writer.println("<head><title>Servlet Show Parameters</title></head>");
        writer.println("<body>");
        writer.println("<h1> PARAMETERS </h1>");
        writer.println("<h1> parameter 1 = " + parameter1 +  "</h1>");
        writer.println("<h1> parameter 2 = " + parameter2 +  "</h1>");
        writer.println("<h1> parameter 3 = " + parameter3 +  "</h1>");
        writer.println("<h1> parameter 4 = " + parameter4 +  "</h1>");
        writer.println("<h1> parameter 5 = " + parameter5 +  "</h1>");
        writer.println("<h1> parameter 6 = " + parameter6 +  "</h1>");
        writer.println("</body>");
        writer.println("</html>");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}