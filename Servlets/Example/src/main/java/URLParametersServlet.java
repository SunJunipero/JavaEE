import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

@WebServlet("/param")
public class URLParametersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String one = req.getParameter("one");
        String two = req.getParameter("two");
        System.out.println("getParameter");
        System.out.println(one);
        //resp.getWriter().write("Hello from param servlet");
        resp.getWriter().write(
                "<html>"+ "<head></head>"+
                "<body>"+
                "<form action='param' method='post'>"+
                "<input type='text' name='one'/>"+
                "<input type='text' name='two'/>"+
                "<input type='submit' name='submit'/>"+
                        "one = "+ one +
                        "two = "+ two +
                "</form>"+
                "</body>"+
                "</html>");



        /*
        If we have several parameters with same name, we may get by
        getParameterValues
         */
        System.out.println("getParameterValues");
        String[] ones = req.getParameterValues("one");
        for (String s : ones) {
            System.out.println(s);
        }

        /*
        Parameters name
        input - http://localhost:8080/param?one=looooool&two=kekkk&one=rock&one=am&abc=wqerty
        output - one  - looooool
                 two  - kekkk
                 abc  - wqerty
         */

        System.out.println("getParameterNames");
        Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String s = parameterNames.nextElement();
            System.out.println(s + "  - " + req.getParameter(s));
        }

         /*
        getParameterMap
        input - http://localhost:8080/param?one=looooool&two=kekkk&one=rock&one=am&abc=wqerty
        output - one
                    looooool
                    rock
                    am
                two
                    kekkk
                abc
                    wqerty
         */

        Map<String, String[]> parameterMap = req.getParameterMap();
        for (Map.Entry<String, String[]> stringEntry : parameterMap.entrySet()) {
            System.out.println(stringEntry.getKey());
            for (String s : stringEntry.getValue()) {
                System.out.println("\t" + s);
            }
        }

         /*
        get necessary info
         */

        System.out.println("get necessary info");
        System.out.println(req.getRequestURI());
        System.out.println(req.getRequestURL());
        System.out.println(req.getLocalPort());
        System.out.println(req.getRemoteHost());
        System.out.println(req.getRemoteUser());
        System.out.println(req.getServletPath());
        System.out.println(req.getScheme());
        System.out.println(req.getQueryString());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
