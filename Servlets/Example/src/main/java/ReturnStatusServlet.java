import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/status")
public class ReturnStatusServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        //resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        //resp.sendRedirect("/xss");
        //resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "lol OKKK !!!");
        //resp.setHeader("Refresh", "2");
        resp.setHeader("Refresh", "2;https://hasitleaked.com/2017/mgmt-little-dark-age/");
    }
}
