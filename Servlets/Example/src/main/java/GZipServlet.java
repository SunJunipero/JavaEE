import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.zip.GZIPOutputStream;

@WebServlet("/gzip")
public class GZipServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getHeader("Accept-Encoding").contains("gzip")) {
            resp.setHeader("Content-Encoding", "gzip");
            PrintWriter writer = new PrintWriter(new GZIPOutputStream(resp.getOutputStream()));
            writer.println("Hello World!");
            writer.flush();
            writer.close();
        }
    }
}
