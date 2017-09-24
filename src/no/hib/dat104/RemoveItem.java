package no.hib.dat104;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "removeItem",
        description = "Servlet som sletter ting fra handlekurv",
        urlPatterns = "/remove")
public class RemoveItem extends HttpServlet
{
    public void service(HttpServletRequest request,
                        HttpServletResponse response)
            throws IOException, ServletException
    {

// Get the index of the item to remove.
        //int itemIndex = Integer.parseInt(request.getParameter("item"));

        HttpSession s = request.getSession();

// Get the cart.
        Cart cart = (Cart) s.getAttribute("cart");

// If there is no shopping cart, create one.
        if (cart == null)
        {
            cart = new Cart();

            s.setAttribute("cart", cart);
        }

        cart.removeItem(request.getParameter("item"));

// Now display the cart and allow the user to check out or order more items.
        response.sendRedirect(response.encodeRedirectURL("webshop"));
    }
}