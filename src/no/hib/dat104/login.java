package no.hib.dat104;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "login",
            description = "Login page for webshop",
            urlPatterns = "/login"
)

public class login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {


        boolean invalidPasswordRedirect = request
                .getParameter("invalidPassword") != null;

        response.setContentType("text/html; charset=ISO-8859-1");

        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"ISO-8859-1\">");
        out.println("<title>Login</title>");
        out.println("</head>");
        out.println("<body>");

        if (invalidPasswordRedirect) {
            out.println("<p> Passordet du gav inn var feil. Prøv igjen: </p>");

        } else {
            out.println("<p>Gi inn passord:</p>");
        }

        out.println("<form action=\"login\" method=\"post\">");
        out.println("  <fieldset>");
        out.println("    <legend>Velkommen til EDB-shoppen!</legend>");
        out.println("    <p>Du bør skrive inn følgende: " + getServletConfig().getInitParameter("pwd") +"</p>");
        out.println("    <p><input type=\"password\" name=\"pwd\" /></p>");
        out.println("    <p><input type=\"submit\" value=\"Logg inn\" />" +
                "</p>");
        out.println("  </fieldset>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        boolean correctPwd = request
                .getParameter("pwd").equals(getServletConfig().getInitParameter("pwd"));

        if (!correctPwd) {
            response.sendRedirect("login?invalidPassword");
        } else {

            HttpSession s = request.getSession(false);
            if (s != null) {
                s.invalidate();
            }
            s = request.getSession(true);
            s.setMaxInactiveInterval(10);

            s.setAttribute("cart", new Cart());

            response.sendRedirect("webshop");
        }
    }
}
