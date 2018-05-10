import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/xss")
public class XSSServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String one = req.getParameter("one");
            one = one == null ? "" : one.replaceAll("<", "&lt;").replaceAll(">","&gt;");
            String two = req.getParameter("two");
            System.out.println("getParameter");
            System.out.println(one);
            resp.getWriter().write(
                    "<html>"+ "<head></head>"+
                            "<body>"+
                            "<form action='xss' method='get'>"+
                            "<textarea  name='one'/></textarea>"+
                            "<input type='submit' name='submit'/>"+
                            "one = "+ one +
                            "two = "+ two +
                            "</form>"+
                            "</body>"+
                            "</html>");
    }
}
