package no.hib.dat104;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name = "login",
            description = "Login page for webshop",
            urlPatterns = "/login"
)

public class login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {


        boolean invalidPassRedir = request
                .getParameter("invalidPassword") != null;
        request.setAttribute("invalidPasswordRedirect", invalidPassRedir);

        request.getRequestDispatcher("WEB-INF/login.jsp").forward(request,
                response);
    }
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        boolean correctPwd = request.getParameter("pwd").equals(getServletConfig().getInitParameter("pwd"));

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
