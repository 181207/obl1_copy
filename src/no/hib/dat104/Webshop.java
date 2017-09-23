package no.hib.dat104;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "webshop",
            description = "Hovedside for webshop",
            urlPatterns = "/webshop")
public class Webshop extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        HttpSession s = request.getSession(false);
        if (s == null) {
            response.sendRedirect("login?invalidPassword");
        }
        Cart cart = (Cart) s.getAttribute("cart");

        if (!request.getParameter("searchField").isEmpty()) {
            cart.addItem(new Item(request.getParameter("searchField")));
        }

        response.sendRedirect("webshop");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession s = request.getSession(false);
        Cart cart = (Cart) s.getAttribute("cart");

        if (s == null) {
            response.sendRedirect("login?requiresLogin");
        } else {
            request.getRequestDispatcher("WEB-INF/webshop.jsp").forward(
                    request, response);
        }

    }
}
