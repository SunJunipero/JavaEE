import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/thread")
public class ThreadServlet extends HttpServlet {

    static int i = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //System.out.println(Thread.currentThread().getName());
        synchronized (this) {
            for (int j = 0; j < 1_000_000; j++) {
                i++;
            }
            System.out.println(i);
        }
    }

}
