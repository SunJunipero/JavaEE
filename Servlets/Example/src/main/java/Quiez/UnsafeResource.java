package Quiez;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/unsafe")
public class UnsafeResource extends HttpServlet {

    String resource = "initial resource";

    protected void proccesServlet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        resource= request.getParameter("source");
        PrintWriter writer = response.getWriter();

        writer.println("<html>");
        writer.println("<head>Quiz servlet</head>");
        writer.println("<body>");
        writer.println("<h1> parameter =>" + resource + " </h1>");
        writer.println("</body>");
        writer.println("</html>");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        proccesServlet(req, resp);
    }
}
