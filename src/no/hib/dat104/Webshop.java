package no.hib.dat104;

import no.hib.dat104.no.hib.dat104.data.ICartEAO;
import no.hib.dat104.no.hib.dat104.data.IItemEAO;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "webshop",
            description = "Hovedside for webshop",
            urlPatterns = "/webshop")
public class Webshop extends HttpServlet {
    @EJB
    private IItemEAO itemEAO;
    @EJB
    private ICartEAO cartEAO;



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        HttpSession s = request.getSession(false);
        if (s == null) {
            response.sendRedirect("login?invalidPassword");
        }
        Cart cart = new Cart();
        if (s.getAttribute("cart") != null) {
            cart = (Cart) s.getAttribute("cart");
        }

        if (!request.getParameter("searchField").isEmpty()) {
            Item newItem = new Item(request.getParameter("searchField"));
            cart.addItem(newItem);
            itemEAO.addItem(newItem);
        }

        response.sendRedirect("webshop");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession s = request.getSession(false);
        Cart cart = (Cart) s.getAttribute("cart");
        cartEAO.addCart(cart);


        if (s == null) {
            response.sendRedirect("login?requiresLogin");
        } else {
            request.getRequestDispatcher("WEB-INF/webshop.jsp").forward(
                    request, response);
        }

    }
}
