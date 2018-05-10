import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Cycle")
public class LifeCycle extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("Initialization Servlet");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("Service method");
        super.service(req, res);
    }

    @Override
    public void destroy() {
        System.out.println("Destroy Servlet");
    }

    @Override

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("from doGet method");
        String s = "<html>"+
                "<header><title>Life cycle servlet</header></title>"+
                "<body>This is life cycle</body>"+
                "</html>";
        resp.getWriter().write(s);
    }
}
