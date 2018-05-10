import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

@WebServlet(value = "/AnnInitServlet", initParams ={
        @WebInitParam(name = "param1", value = "value1"),
        @WebInitParam(name = "param2", value = "value2")
}
)
public class AnnatationParamInitServlet extends HttpServlet {
    String param1;
    String param2;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        param1 = config.getInitParameter("param1");
        param2 = config.getInitParameter("param2");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        String param1 = getServletConfig().getInitParameter("param1");
//        String param2 = getServletConfig().getInitParameter("param2");

        Random random = new Random();
        param1 = String.valueOf(random.nextInt(100));
        param2 = String.valueOf(random.nextInt(66));

        String initParam1 = getServletConfig().getInitParameter("param1");
        String initParam2 = getServletConfig().getInitParameter("param2");


        PrintWriter writer = resp.getWriter();

        writer.println("<html>");
        writer.println("<head><title>Init param servlet</title></head>");
        writer.println("<body>");
        writer.println("<h1>Init param servlet</h1>");
        writer.println("<h1>Parameter 1 = " + param1 + "</h1>");
        writer.println("<h1>Parameter 2 = " + param2 + "</h1>");
        writer.println("<h1>initParameter 1 = " + initParam1 + "</h1>");
        writer.println("<h1>initParameter 2 = " + initParam2+ "</h1>");
        writer.println("</body>");
        writer.println("</html>");
    }
}